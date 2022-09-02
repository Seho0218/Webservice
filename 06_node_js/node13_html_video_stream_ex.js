var http = require('http');
var fs = require('fs');
var mime = require('Mime');

var server = http.createServer(function(request, response){
    var mapping = request.url; // /img/k.jpg, /img/karina.jpg
    
    if(mapping == "/"){
        fs.readFile(__dirname+"/html/video_play_ex.html","utf-8",function(err, htmlData){
            if(!err){
                response.writeHead(200, {"content-type":"text/html; charset=utf-8"});
                response.end(htmlData);
            }else{
                response.writeHead(200, {"content-type":"text/html; charset=utf-8"});
                response.end("404 error page...");
            }
        });
    }else if(mapping.indexOf("/img/") == 0){//이미지 접속
        //마임구하기
        mapping = mapping.replace("/img/","/images/");
        mimeType = mime.getType(mapping.substring(1));

        fs.readFile(__dirname+mapping,'utf-8',function(error, imgCode){
            if(!error){
                response.writeHead(200,{"content-type":mimeType});
                response.end(imgCode);
            }
        });
    }else if(mapping.indexOf("/video/")==0){//동영상 보내기
        //1. streaming 처리를 하는 객체를 생성 /video/wildlife.mp4
        //한번에 읽어오는 byte 수는 65535byte이다.
        var stream = fs.createReadStream(mapping.substring(1));
        var cnt = 0;//스트리밍 횟수
        //2. 데이터를 읽어왔을 때 처리할 이벤트
        //      이벤트종류
        stream.on('data', function(videoData){
            response.write(videoData);
            console.log( ++cnt +"번째, size="+ videoData.length);
        });
        //3. 데이터를 마지막으로 읽어왔을 때 처리할 이벤트
        stream.on('end',function(){
            response.end();
            console.log("end 스트리밍.....");
        });
        //4. 데이터를 읽기 중 에러 발생
        stream.on('error',function(){
            response.end();
            console.log('error 스트리밍....');
        });
    }else if(mapping.indexOf("/js_css/")==0){//css    /js_css/style.css   /js_css/script.js
        var extension = mapping.substring(mapping.lastIndexOf(".")+1);
        if(extension == "css"){
            fs.readFile(__dirname+mapping,'utf-8',function(error, cssData){
                if(!error){
                    response.writeHead(200, {"content-type":"text/css"});
                    response.end(cssData);
                }
            });
        }else{//javascript
            fs.readFile(__dirname+mapping,'utf-8',function(e,jsData){
                if(!e){
                    response.writeHead (200, {"Content-Type":"text/javascript;"});
                    response.end(jsData);
                }
            })

        }
    }else{
        response.writeHead(200, {"content-type":"text/html; charset=utf-8"});
        response.end("404 error page...");
    }
});

server.listen(10008, function(){
    console.log("server start... http://localhost:10008");
});