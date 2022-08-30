var http = require("http");
var myModule=require("./node04_custom_module_create");

//[[[ 노드 전체 영역의 전역변수(내장) ]]]
//[1] __filename : 현재실행중인 파일의 절대경로와 파일명을 가진다.
//[2] __dirname : 현재실행중인 파일의 절대경로를 가진다.

var server = http.createServer(function(request,response){
    console.log("__filename-->"+__filename);
    console.log("__dirname-->"+__dirname);

    //1.실제 접속 수조
    console.log("실제 접속 주소: ", request.url);
    let pathName = request.url;
    if(pathName =="/"){
        response.writeHead(200,{"content-type":"text/html;charset=utf-8"});
        response.end("<h1 style='text-align:center; color:green'>홈페이지</h1>");
    }else if(pathName=='/address'){
        response.writeHead(200,{"content-type":"text/html;charset=utf-8"});
        response.end("<h2>주소:서울시 강남구 언주로 508</h2>");
    }else if(pathName=='/gugudna'){
        response.writeHead(200,{"content-type":"text/html;charset=utf-8"});
        response.end("<p> +myModule.gugudan(7)...</p>");
    }else{
        response.writeHead(200,{"content-type":"text/html;charset=utf-8"});
        response.end("<p> 404 Page Not Found...</p>");
    }
});

server.listen(10004,"localhost",function(){
    console.log("server in running..... http://localhost:10004");
    console.log("server in running..... http://localhost:10004/address");
    console.log("server in running..... http://localhost:10004/gugudan");
});