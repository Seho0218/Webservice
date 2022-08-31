var http = require("http");
var fs = require('fs');

http.createServer(function(request,response){
    //이미지 파일의 내용을 비동기식으로 읽어 response에 쓰기

    fs.readFile(__dirname+'/images/asdf.jpg',function(error,imgData){
        if(!error){//정상
            response.writeHead(200,{"content-type":"image/jpg"});
            response.write(imgData);
            response.end();
        }else{//에러발생
            response.writeHead(200, {"content-type":"text/html;charset=utf-8"});
            response.end("파일이 존재하지 않습니다.");
        }
    });

}).listen(10005,function(){
    console.log("server start..... http://localhost:10005");
});