package com.campus.clova.controller;

import java.io.*;
import java.net.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Clova03_csr_speech_controller {
	
	@RequestMapping("/clova/csr_speech")
	public String csr_speech() {
		return "clova/csr_speech";
	}

	@RequestMapping(value="/clova/csr_speech_ok", method=RequestMethod.POST)
	@ResponseBody
	public String csrSpeechOk(@RequestParam("audio") MultipartFile audio, HttpServletRequest request){
		String path = request.getServletContext().getRealPath("/file");//

		////////////////////////////////
        String clientId = "6xzpv2vi46";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "0Fd5DjUUZhpqV7Gt40anXGueLrC2VuWaKtNY26eF";//애플리케이션 클라이언트 시크릿값";
		StringBuffer response = new StringBuffer();

        try {
			//음성파일 업로드
			String filename=ClovaFileupload.fileUpload(path, audio);//

            String imgFile = path+"/"+filename;
            File voiceFile = new File(imgFile);

            String language = "Kor";        // 언어 코드 ( Kor, Jpn, Eng, Chn )
            String apiURL = "https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=" + language;
            URL url = new URL(apiURL);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/octet-stream");
            conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

            OutputStream outputStream = conn.getOutputStream();
            FileInputStream inputStream = new FileInputStream(voiceFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            BufferedReader br = null;
            int responseCode = conn.getResponseCode();
            if(responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }
            String inputLine;

            if(br != null) {
               // StringBuffer response = new StringBuffer(); 위로감
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            } 
        } catch (Exception e) {
            System.out.println(e);
        }
		//--------------------------------------------------
		System.out.println("speech 결과"+response.toString());
		return response.toString();
	}
		
}

