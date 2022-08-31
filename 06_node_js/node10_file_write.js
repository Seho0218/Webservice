//파일로 쓰기
var fs = require('fs');

//비동기식 파일 구현: 스레드 구현
fs.readFile(__dirname+'/images/asdf.png',function(error,imgData){
    if(error){//파일 읽기 실패
        console.log("이미지 파일 읽기 실패 하였습니다.");
    }else{//파일 읽기 성공
        //읽어온 이미지 파일의 내용을 다른 파일로 비동기식으로 쓰기(콜백함수 포함)
//                  쓰기할 파일명                   쓰기할 내용,(encoding)
        fs.writeFile(__dirname+"/dataFile/asdf.png",imgData,function(e){
            if(e){//쓰기 에러 발생
                console.log("파일 비동기식 쓰기 에러가 발생하였습니다.");
            }else{
                console.log("파일 비동기식 쓰기완료");
            }
        });
    }
});
//동기식 파일 쓰기: 바로실행

var txtData = "동기식으로 파일 쓰기 테스트중....";

try{
    fs.writeFileSync(__dirname+'/dataFile/txtWrite.txt',txtData,'utf-8');
    console.log("동기식 파일 쓰기 완료..");
}catch(err){
    console.log("동기식 파일 쓰기 에러 발생됨.");
}