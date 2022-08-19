<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<script>
function mediaStart(){
    var record = document.getElementById("record");
    var stop = document.getElementById("stop");
    var result = document.getElementById("result");

    //미디어 장치가 있으면
    console.log(navigator.mediaDevices);
    if(navigator.mediaDevices){ //정보가 있으면 true 없으면 false
        console.log("미디어가 존재합니다.");
        const constraints = {audio:true};
        let chunks=[];//녹음된 내용을 저장할 변수

        navigator.mediaDevices.getUserMedia(constraints).then(stream=>{ // 예외처리(정상구현)
            const mediaRecorder = new MediaRecorder(stream);//클래스라서 대문자
            //녹음 시작
            record.onclick =()=>{
                chunks=[];//내용이 있으면 초기화
                mediaRecorder.start();//start
                record.style.background="red";
                record.style.color="#fff";
            }
            //녹음 정지
            stop.onclick=()=>{
                mediaRecorder.stop();
                record.style.background="";
                record.style.color="";
            }

            //녹음내용 저장하는 함수
            mediaRecorder.ondataavailable = e =>{
                chunks.push(e.data);
            }
            //녹음이 완료되면 서버로 녹음내용을 보내고 결과를 받아 표시하기
            mediaRecorder.onstop = e =>{
                //////////
                const blob =new Blob(chunks, {
                    'type':'audio/ogg codecs=opus'
                });

                //바이너리코드 변환된 음성파일을 폼에 추가해서 서버로 보냄.
                let formdata = new FormData();
                formdata.append("audioFile",blob); //<input type="file" name="audioFile">

                //비동기식 ajax 실행
                let xhr = new XMLHttpRequest();

                //1.서버에서 값을 받을때
                xhr.onload=()=>{//onload시 실행
                    if(xhr.status==200){
                        console.log(xhr.response);
                        let jsonData = JSON.parse(xhr.response);
                        result.innerHTML=jsonData.text;
                    }
                }
                //2.서버열기
                    xhr.open("POST","/clova/csr_speech_record_ok",true);
                //3.서버에 전송하기
                xhr.send(formdata);//폼 데이터로 보냄
            }

        }).catch(err=>{ //예외처리(오류) 
            console.log("Error : "+err);
        });

    }else{
        alert("녹음 기능이 없습니다.");
    }
}
</script>
</head>
<body onload="mediaStart()">
    <h1>녹음파일에 대한 CSR</h1>
    <input type="button" id="record" value="녹음시작"/>
    <input type="button" id="stop" value="녹음중지"/>
    <div id="result"></div>
    

</body>
</html>