var http = require('http');
var fs = require('fs');
var mime = require('Mime');

var server = http.createServer(function(request, response) {
    var mapping = request.url; //img/bts2.gif /img/03.jfif,/images/03.jfif

    if(mapping == '/'){
        fs.readFile( _dirname+'/html/video_play.html','utf-8', function(err, htmlData){
            if(!err) {
                response.writeHead (200, {"Content-Type": "text/html; charset=utf-8"});
                response.end(htmlData);
            }else{
                response.writeHead (200, {"Content-Type":"text/html; charset=UTF-8"});
                response.end("404 error Page.....");
            }
    });
    }else if(mapping.indexOf("/img/")==0) {

        mapping = mapping.replace("/img/","/images/");
        mimeType=mime.getType(mapping.substring(1));

        fs.readFile(__dirname+mapping,'',function(error,imgCode){
            if(!error){
                response.writeHead(200, {"content-type":"mimeType;charset=utf-8"});
                response.end(imgCode);
            }
        });
    }else if(mapping.indexOf("/video/")==0){//동영상 보내기
        //1. streaming처리를 하는 객체 생성
        // 한번에 읽어오는 byte수는 65535byte
        var stream = fs.createReadStream(mapping.substring(1));
        var cnt= 0;//스트리밍 횟수
        //2. 데이터를 읽어 왔을때 처리할 이벤트
        //      이벤트 종류
        stream.on('data',function(videoData){
            response.write(videoData);
            console.log(++cnt +"번째, data"+videoData.length);
        });
        //3.데이터를 마지막으로 읽어왔을때 처리할 이벤트
        stream.on('end',function(){
            response.end();
            console.log("end 스트리밍....");
        });
        //4. 데이터를 읽기 중 에러 발생했을때 처리할 이벤트
        stream.on('error',function(){
            response.end();
            console.log("404 error.page....")
        });   
    }else{
        response.writeHead (200, {"Content-Type":"text/html; charset=UTF-8"});
        response.end("404 error Page.....");
    }
});

    server.listen(10007, function() {
    console.log("server start... http://localhost:10007");
});
    