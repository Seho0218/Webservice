var http = require('http');

var server= http.createServer(function(req,res){
    //post방식의 데이터 처리는 이벤트에 의해 이루어진다.
    var postData="";
    //form의 정보가 서버로 데이터가 전송되면 data이벤트가 발생한다.
    req.on('data',function(data){
        postData+=data;
        console.log("postData = ",postData);
    });

    //form의 데이터 전송이 완료되면 end이벤트가 발생한다.
    req.on('end',function(){
        var parseQuery = new URLSearchParams(postData);
        console.log("parseQuery=", parseQuery);

        res.writeHead(200,{"content-type":"text/html;charset=utf-8"});
        res.write("아이디:"+parseQuery.get("userid")+"<br/>");
        res.write("비밀번호:"+parseQuery.get("userpwd")+"<br/>");
        res.write("이름:"+parseQuery.get("username")+"<br/>");
        res.end("end");
    });
});



server.listen(10001,function(){
    console.log("server start...http://localhost:10001");
});