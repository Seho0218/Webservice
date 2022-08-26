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
<style>

    #content{
        overflow:scroll;
    }

    #content ul, #content li{
        margin:0; padding:0; list-style-type:none;
    }

    #content ul{
        overflow: auto;
    }
    #content li{
        float:left;
        padding:10px;
    }
    #content li>img{
        width:200px; height:200px;
    }
</style>
<script>
    $(function(){
        $(document).on('click','#query',function(){
            if($("#queryin").val()!=""){//질문이 있을때
                $.ajax({
                    type:"post",
                    dataType:"text",
                    async:false,
                    url:"/clova/chatbotOk",
                    data:{
                        queryin:$("#queryin").val()
                    },success:function(result){

                        $("#jsonCode").val(result);
                        var jsonData = JSON.parse(result);
                        console.log(jsonData);
                        //텍스트로 답변이 왔을 경우
                        if(jsonData.bubbles[0].type=='text'){
                            var ans = jsonData.bubbles[0].data.description;
                            ans=ans.replaceAll("\n","<br/>");// \n을 <br/>로
                            $("#content").append("<p>"+ans+"</p>");
                        }else if(jsonData.bubbles[0].type=="template"){//버튼 형식의 답변일때
                            var msg = jsonData.bubbles[0].data.cover.data.description;
                            $("#content").append("<p><b>"+msg+"</b></p>");

                            jsonData.bubbles[0].data.contentTable.map(function(btn,idx){
                                tag += "<input type='button' value='"+btn[0].data.title;
                                tag += "'onclick=\"location.href=\'"+btn[0].data.data.action.data.url+"\'\"style='width:100%;'/><br/>";
                            });
                            tag+="</p>";

                            $("content").append(tag);
                        }else if(jsonData.bubbles[0].type=='carousel'){

                            var imgView="<ul>";
                            
                            jsonData.bubbles[0].data.cards.map(function(img, idx){
                                console.log(img);
                                imgView += "<li><img src='"+img.data.cover.data.imageUrl+"'/><br/>";
                                imgView += "<b>" +img.data.cover.title+"<b/><br/>";
                                imgView += img.data.cover.data.description+"<br/>";
                                imgView += "</li>";
                            });
                            imgView +="</ul>";
                            $("#content").append(imgView);
                        }
                        //스크롤바의div를 맨 아래로 이동하기
                        //$("#content").scrollTop($("#content")[0].scrollHeight);
                        var div = document.getElementbyId("content");
                        div.scrollTop=div.scrollHeight;
                        $("#queryin").val("");
                    },error:function(error){
                        console.log(error.responseText);
                    }
                });
            }
        });
    });
</script>
</head>
<body>
<h2>Chatbot</h2>
<div id="content" style="width=100%; height:400px; border:1px solid #ddd;"></div>
<input type="text" name="queryin" id="queryin"/>
<input type="button" value="query" id="query"/>
<hr/>
<textarea id="jsonCode" style="width:100%; height:300px;"></textarea>
</body>
</html>