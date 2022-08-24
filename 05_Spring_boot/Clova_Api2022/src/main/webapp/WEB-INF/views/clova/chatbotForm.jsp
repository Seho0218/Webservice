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
        $("#query").click(function(){
            if($("#queryin").val()!==""){//질문이 있을때
                $.ajax({
                    type:"post"
                    dataType:"text",
                    async:"false",
                    url:"/clova/chatbotOk",
                    data:{queryin:$("#queryin").val()
                    },success:function(result){
                        $("jsonCode").val(result);
                    
                    },error:function(error){
                        console.log(error.responseText);
                    }
                });
            }
        })
    });
</script>
</head>
<body>
<h2>Chatbot</h2>
<div id="content" style="width=100%; height:400px; border:1px solid #ddd;"></div>
<input type="text" name="queryin" id="queryin"/>
<input type="button" value="query" id="query"/>
<textarea id="jsonCode" style="width:100%; height:300px;"></textarea>
</body>
</html>