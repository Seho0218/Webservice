//express 모듈 추가설치
// >npm install express
// >npm install express-session
// >npm install mysql2
// >npm install ejs
// >npm install request-ip

var http = require('http');
var express = require('express');
var fs = require('fs');

var app=express();
var server = http.createServer(app);

var session  = require('express-session');
var ejs = require('ejs');

var requestip = require('request-ip');//접속자의 아이피를 구하기 위해

// ==post 방식의 데이터 request를 위한 설정 
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({extended:true}));

//==JDBC========================================
//mysql2모듈이 필요 npm install mysql2
var mysqldb = require("mysql2");
const e = require('express');
const { response } = require('express');
mysqldb.autoCommit=true;

//DB연결
var connection = mysqldb.createConnection({
    host:'localhost',
    port:3306,
    user:'root',
    password:'root1234',
    database:'mydb'
});
connection.connect();//--DB가 연결됨.
//---접속---------------------------------
//        주소, 콜백함수
app.get('/home',function(request,response){
    fs.readFile(__dirname+'/home.ejs','utf-8', function(error, homeData){
        if(!error){
            response.writeHead (200, {"Content-Type":"text/html;"});
            response.end(homeData,{
                logStatus:'N'
            });
        }
    });
});
//로그인 폼
app.get('/login',function(request, response){
    fs.readFile(__dirname+"/loginForm.html",'utf-8', function(error, loginFormData){
        if(!error){
            response.writeHead (200, {"Content-Type":"text/html;"});
            response.end(loginFormData);
        }
    });
});
//로그인 DB
app.post('/loginOk',function(request,response){
    var userid = request.body.userid;
    var userpwd = request.body.userpwd;
    console.log('아이디=', userid);
    console.log('비밀번호=', userpwd);

    //쿼리문 작성
    var sql="select userid, username from member where userid=? and userpwd=?";
    //  쿼리문, 바인딩데이터 , 쿼리문을 실행 후 콜백함수 
    connection.query(sql,[userid,userpwd], function(error,results){//results: 쿼리문 실행 결과
        console.log(error,results,results.length);
        //로그인 성공
        if(!error && results.length>0){
            //로그인 정보를 세션 저장하기
            // 세션 사용하기 위해서는 모듈 추가
            //세션 기록
            session.user={
                userid : results[0],userid,
                userpwd : results[0],username,
                authorized: true//인증받은, 검정필
            }
            //홈으로 이동하기 (session객체의 정보, 기타 필요한 정보가 있을 경우)
            fs.readFile(__dirname+"/home.ejs",'utf-8',function(e,homeData){
                if(!e){
                    response.writeHead (200, {"Content-Type":"text/html; charset=UTF-8"});
                    response.end(ejs.render(homeData,{
                        user:session.user,
                        logStatus:'Y',
                        logPwd: userpwd
                    }));
                }else{
                    response.writeHead (200, {"Content-Type":"text/html;charset=UTF-8"});
                    response.end("404 pages");
                }
            });
        }else{//로그인 실패
            fs.readFile(__dirname+"/loginForm.html","utf-8",function(err,loginData){
                if(!err){
                    response.writeHead (200, {"Content-Type":"text/html; charset=UTF-8"});
                    response.end(loginData);
                }
            });       
        }       
    });
});
//로그아웃 --session지우고 home.ejs이동
app.get("/logout",function(request,response){
    //세션이 있는지 없는지 확인
    if(session.user){//로그인 상태일때
        fs.readFile(__dirname+'/home.ejs','utf-8', function(error, homeData){
            if(!error){
                session.user=null;// 세션지우기
                response.writeHead (200, {"Content-Type":"text/html; charset=UTF-8"});
                response.end(ejs.render(homeData,{logstatus:'N'}));
            }
        });
    }else{//로그아웃
        console.log("로그아웃 상태임");
    }
});
//게시판 리스트
app.get("/boardList",function(request,response){
    //===========================================
    fs.readFile(__dirname+'/boardList.ejs','utf-8',function(error,boardListData){

        if(!error){
            //db조회(게시판 목록)
            var sql="select no, subject, userid, hit, date_format(writedate, %m-%d %H:%i) writedate";
                sql+="from board order by no desc";

            connection.query(sql,function(err,results){         
            //로그인 여부 설정
            var logStatus='N';
            if(session.user!=null){
                var logStatus='Y';         
            }
        
            response.writeHead (200, {"Content-Type":"text/html; charset=UTF-8"});
            response.end(ejs.render(boardListData,{
                results,results,
                parsing:{
                    logStatus:logStatus,
                    nowPage:3,
                    totalRecord:results.length
                }
            }));

        });

        }else{
            response.writeHead (200, {"Content-Type":"text/html;charset=UTF-8"});
            response.end("404 pages");
        }
    });
    /////////////////////////////////////////////////
});
//게시판 글쓰기 폼
app.get('/boardWrite',function(request,response){
    fs.readFile(__dirname+"/boardWrite.ejs",'utf-8', function(error, boardWriteData){
        response.writeHead (200, {"Content-Type":"text/html;charset=UTF-8"});
        if(!error){
            response.end(boardWriteData);
        }else{
            response.end("404 pages......");
        }
    })
});
//게시판 글쓰기 DB
app.post("/boardWriteOk",function(request,response){
    var subject = request.body.subject;
    var content = request.body.content;
    var userid = session.user.userid;

    //ip 구하기
    var ip=request.getClientIp(request).substring(7);

    var sql = "insert into board(subject, content, userid, ip) values(?,?,?,?)";
    var bindData= [subject, content, userid, ip];

    connection.execute(sql,bindData,function(error, result){
        //console.log(error);
        //console.log(result);
        if(result.affectiedRows>=1){
            response.redirect("/board");
        }else{
            response.writeHead (200, {"Content-Type":"text/html;charset=UTF-8"});
            response.end("<script>alert('글등록실패');history.back();</script>");
        }
    });
});

//글내용보기
server.listen(10020,function(){
    var params = new URLSearchParams(request.url.substring(6));

    //boardView.ejs파일 일기 
    fs.readfile( dirname+"/boardView.ejs",'utf-8', function(error, viewData){ 
        if(!error){ 
            //조회수 증가 
            var sql = "update board set hit = hit + 1 where no=?" ; 
            connection.execute(sql, [params.get ('no')], function(err, result) { 
                console.log ( "조회 수==>", result) ; 
        }) ; 
        //해당레코드 선택 
        sql = "select no , subject, content, userid, hit, writedate from board where no=?"; 
        connection.execute(sql, [params.get('no')], function(err, result){ 
            if(result. length>0){//해당글이 있을때 
                var logStatus = 'N' ; 
                if(session.user!=null){ logStatus= 'Y';} 
                response.writeHead(200, {"Content-Type" : "text/html; charset=utf-8"}) ; 
                response.end(ejs.render (viewData, { 
                    record : result, 
                    logStatus:logStatus, 
                    user:session.user 
            })) ; 

        }else{//해당글이 없을때 
            response.writeHead(200, {"Content-Type" : "text/html; charset=utf-8"});
            response.end("<h1>이미 삭제된 글입니다.</h1><a href='/boardList'>게시판 목록으로 이동하기</a>"); 
        }
    });
}else{
    response.writeHead(200, {"Content-Type" : "text/html; charset=utf-8"});
    response.end("404pages...");
}
    });
}); 
///글수정 [폼] 
app.get ('/boardEdit', (request, response)=>{ //boardEdit?no=6 
    var params = new URLSearchParams(request.url.substring(11)) 
}) ; 

// ***접속대기 ********** 
server.listen (10020, function(){ 
    console.log("express server start.. http://:10020/home ");
});
