var http = require("http");
//사용자 정의 모듈 사용하기
var my_module=require('./node04_custom_module_create');

var server = http.createServer(function(require,response){
    response.writeHead(200, {"content-type":"text/html;charset=utf-8"});
    response.write("번호-->"+my_module.num);
    response.write("</br>이름-->"+my_module.num);
    response.write("</br>합(5,7)-->"+my_module.hap(5,7));
    response.write("</br>sum(100)-->"+my_module.sum(100));
    response.end("<hr/>구구단(9)</br>"+my_module.gugudan(9));
});

server.listen(10002,function(){
    console.log("server start... http://localhost:10002");
});