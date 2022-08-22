<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    $(function(){
        $("#ocrForm").submit(function(){
            event.preventDefault();
            const image=$("#image")[0];
            if(image.files.length===0){//값과 데이터형 비교
                alert("텍스트가 있는 파일을 선택하세요");
                return false;
            }

            //이미지가 있을 경우
            var formData = new FormData($("#ocrForm")[0]);

            $.ajax({
                type:"post",
                dataType:"text",
                async:"false",
                url:"/clova/ocrOk",
                processData:false,
                contentType:false,
                data:formData,
                success:function(result){
                    $("#result").val(result);
                },error:function(error){
                    console.log(error.responseText);
                }
            });
        });
    });
</script>
</head>
<body>
    <h2>이미지 속 문자 추출하여 컴퓨터 데이터로 변환</h2>
    <p>복잡하고 다양한 문서나 이미지 속 문자를 추출하여 데이터화하고 관리할 수 있는 서비스입니다.</p>
    <form method="post" enctype="multipart/form-data" id="ocrForm">
        텍스트가 있는 이미지 : <input type="file" name="image" id="image"/>
        <input type="submit" value="전송하기"/>
    </form>
    <hr/>
    <textarea id="result" style="width:100%; height:100px;"></textarea>
</body>
</html>