<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
	
	</script>
</head>
<body>
	<h1>Clova Api 홈</h1>
	<ol>
		<li><a href="/clova/cfr">CFR(Clova Face Recongintion) : 얼굴감지 (눈,코,입,나이,얼굴방향,표정)</a></li>
		<li><a href="/clova/cfr_celebrity">CFR(Clova Face Recongintion) : 유명인얼굴인식</a></li>
		<li><a href="/clova/csr_speech">CSR(Clova Speech Recongintion) :  음성을 텍스트로</a></li>
		<li><a href="/clova/csr_speech_record">CSR(Clova Speech Recongintion) :  음성을 텍스트로 변환한다.(음성녹음기능)</a></li>
		<li><a href="/clova/summary">summary : 다양한 주제의 원문으로부터 핵심 문장을 추출하여 1~2줄로 요약한다.</a></li>
		<li><a href="/clova/sentiment">CLOVA Sentiment API는 텍스트 데이터를 분석해서 해당 단어/문장/문구 내용의 감정을 분석하는 서비스입니다.</a></li>
		<li><a href="/clova/captchaForm">CAPTCHA(image) : 이미지 캡차 API는 자동 입력 방지를 위해 사람의 눈으로 식별 가능한 문자가 포함된 이미지를 전송하고 입력값을 검증하는 REST API입니다.</a></li>
		<li><a href="/clova/ocrForm">OCR : 인쇄물 상의 글자와 이미지를 디지털 데이터로 자동 추출하는 기술입니다.(gateway 필요함)</a></li>
	</ol>
</body>
</html>