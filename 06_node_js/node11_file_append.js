//파일의 원 내용을 유지하ㅏ고 새로운 내용을 추가하기

var fs = require('fs');

//비동기식으로 파일 추가
var appendData= "\n-----비동기식으로 파일 내용 추가 하기 테스트중.............."
fs.appendFile(__dirname+"/dataFile/file_read.txt",appendData,'utf-8',function(err){
    if(!err){
        console.log("파일내용이 정상 추가 되었습니다.");
    }else{
        console.log("파일 내용 추가 실패하였습니다.");
    }
});

//동기식으로 파일 추가
var appData= "\n-----비동기식으로 파일 내용 추가 테스트중.............."
try{
    // dataFile/file_readtxt 읽기한 후 읽은 내용을 txtWrite.txt에 추가하기
    fs.appendFileSync(__dirname+"/dataFile/file_read.txt","utf-8",function(err,data){
        if(err){
            console.log("read fail.....");
        }else{
            fs.appendFileSync(__dirname+"/dataFile/txtWrite.txt",data,"utf-8");
            console.log("동기식 파일내용 추가완료됨....");
        }
    });
}catch(e){
    console.log("동기식 파일 추가 에러 발생.....");
}