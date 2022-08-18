package com.campus.clova.controller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Clova02_cfr_celebrity_controller {
    @RequestMapping("/clova/cfr_celebrity")
    public String celebrity(){
        return "clova/cfr_celebrity";
    }

    @RequestMapping(value="/clova/cfr_celebrity_ok",method = RequestMethod.POST)
    @ResponseBody
    public String celebrityOk(@RequestParam("image") MultipartFile file, HttpSession session){//절대경로 때문에 필요
        String path = session.getServletContext().getRealPath("/file");
        

        String clientId = "6xzpv2vi46";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "0Fd5DjUUZhpqV7Gt40anXGueLrC2VuWaKtNY26eF";//애플리케이션 클라이언트 시크릿값";
        StringBuffer response = new StringBuffer();
        try {

            //파일 업로드
            String filename = ClovaFileupload.fileUpload(path, file);

      
            String paramName = "image"; // 파라미터명은 image로 지정
            String imgFile = path+"/"+filename;
            File uploadFile = new File(imgFile);
            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision/v1/celebrity"; // 유명인 얼굴 인식
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            // multipart request
            String boundary = "---" + System.currentTimeMillis() + "---";
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            OutputStream outputStream = con.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            String LINE_FEED = "\r\n";
            // file 추가
            String fileName = uploadFile.getName();
            writer.append("--" + boundary).append(LINE_FEED);
            writer.append("Content-Disposition: form-data; name=\"" + paramName + "\"; filename=\"" + fileName + "\"").append(LINE_FEED);
            writer.append("Content-Type: "  + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
            writer.append(LINE_FEED);
            writer.flush();
            FileInputStream inputStream = new FileInputStream(uploadFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            writer.append(LINE_FEED).flush();
            writer.append("--" + boundary + "--").append(LINE_FEED);
            writer.close();
            BufferedReader br = null;
            int responseCode = con.getResponseCode();
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            String inputLine;
            if(br != null) {
                while ((inputLine = br.readLine()) != null) { //데이터를 읽어오는 곳
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            } 
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("celebrity->"+response.toString());
        return response.toString(); //클라이언트로 리턴
    }
}

