//express 모듈 추가설치
// >npm install express

var http = require('http');
var express = require('express');
var fs = require('fs');

var app=express();
var server = http.createServer(app);

// ==post 방식의 데이터 request를 위한 설정 
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({extended:true}));

//==JDBC========================================
//mysql2모듈이 필요 npm install mysql2
var mysqldb = require("mysql2");
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
            response.end(homeData);
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
        console.log(results);

    });
});
// 접속대기
server.listen(10020,function(){
    console.log("express server start...http://localhost:10020/home");
})