package com.campus.clova.controller;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Clova06_captcha_image_controller {
    String clientId="1ukf94likl";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "2hLMXxzwV9IkFgOP7HpYPL66y3hFedfZwQlfQS2g";//애플리케이션 클라이언트 시크릿값";

    //폼으로 이동하기
    @GetMapping("/clova/captchaForm")
    public String captchaForm(){
        return "clova/captchaForm_img";
    }
    String key;

    //캡챠 이미지 수신
    @RequestMapping("/clova/captchaImage")
    public void captchaImage(HttpServletRequest request,HttpServletResponse res){
        ///////////////////////////////////////
        //String clientId = "YOUR_CLIENT_ID";//애플리케이션 클라이언트 아이디값";
        //String clientSecret = "YOUR_CLIENT_SECRET";//애플리케이션 클라이언트 시크릿값";
        String path = request.getServletContext().getRealPath(("/file"));

        
        try {
            key = captchaKey(); // 키 발급시 0,  캡차 이미지 비교시 1로 세팅

            String apiURL = "https://naveropenapi.apigw.ntruss.com/captcha-bin/v1/ncaptcha?key=" + key + "&X-NCP-APIGW-API-KEY-ID" + clientId;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                InputStream is = con.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];
                // 랜덤한 이름으로 파일 생성
                String tempname = Long.valueOf(new Date().getTime()).toString();
                File f = new File(path, tempname + ".jpg");
                f.createNewFile();
                OutputStream fileoutputStream = new FileOutputStream(f);
                OutputStream outputStream = res.getOutputStream();
                
                while ((read =is.read(bytes)) != -1) {
                    fileoutputStream.write(bytes, 0, read);//파일로 쓰기
                    outputStream.write(bytes,0,read);//클라이언트에게 쓰기
                }
                is.close();
                fileoutputStream.close();
                outputStream.close();

            } else { // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        ///////////////////////////////////////
    }




    //캡챠 키값 비교
    @PostMapping("/clova/captchaCheck")
    public ResponseEntity<String> chpatchaCheck(@RequestParam("userIn") String userIn){
        //////////////////
        StringBuffer response = new StringBuffer();
        try {
            String code = "1"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
            //String key = "CAPTCHA_KEY"; // 캡차 키 발급시 받은 키값
            String value = userIn; // 사용자가 입력한 캡차 이미지 글자값
            String apiURL = "https://naveropenapi.apigw.ntruss.com/captcha/v1/nkey?code=" + code +"&key="+ key + "&value="+ value;

            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        //////////////////
        JSONObject jsonObj  = new JSONObject(response.toString());

        ResponseEntity<String> entitiy=null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
        headers.add("Content-Type","text/html; charset=UTF-8");

        String message="";

        if(jsonObj.getBoolean("result")){//문자가 맞을 경우
            message+="<script>";
            message+="alert('홈으로 이동합니다.');";
            message+="location.href='/'";
            message+="</script>";
            entitiy=new ResponseEntity<String>(message,headers,HttpStatus.OK);

        }else{//문자가 틀릴 경우
            message+="<script>";
            message+="alert('입력한 문자가 다릅니다.');";
            message+="location.href='/clova/captchaForm'";
            message+="</script>";
            entitiy=new ResponseEntity<String>(message,headers,HttpStatus.BAD_REQUEST);
        }

        return entitiy;
    }



    //캡챠 키 발급
    public String captchaKey(){
        ///////////////////
        StringBuffer response = new StringBuffer();
        try {
            String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
            String apiURL = "https://naveropenapi.apigw.ntruss.com/captcha/v1/nkey?code=" + code;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
            }catch(Exception e) {
                System.out.println(e);
            }
            JSONObject jsonObj  = new JSONObject(response.toString());
            String key = jsonObj.getString("key");

            return key;
        }
    }