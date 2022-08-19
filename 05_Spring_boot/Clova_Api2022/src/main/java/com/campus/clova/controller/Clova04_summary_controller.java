package com.campus.clova.controller;

import java.io.*;
import java.net.*;

import org.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Clova04_summary_controller {
	@RequestMapping("/clova/summary")
	public String summary() {
		return "clova/summary";
	}
	@RequestMapping(value="/clova/summaryOk", method=RequestMethod.POST)
    @ResponseBody
	public String summaryOk(@RequestParam("content") String content) {

        String clientId = "6xzpv2vi46";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "0Fd5DjUUZhpqV7Gt40anXGueLrC2VuWaKtNY26eF";//애플리케이션 클라이언트 시크릿값";
       
        BufferedReader br = null;//전송받은 정보가 있는 inputstream
        StringBuffer response = new StringBuffer();

        try {
			//클라우드로 보낼 데이터를 준비한다.

			JSONObject document = new JSONObject(); // 그래들에 있어서 됌.
			document.put("content", content);	

			JSONObject option = new JSONObject();
			option.put("language","ko"); //api와 갯수 맞춰줘야함
			option.put("news","news");
			option.put("tone",3);
			option.put("summaryCount",3);// 3개의 문장

			JSONObject body = new JSONObject();
			body.put("document",document);
			body.put("option",option);

			String jsonStr = body.toString();
			System.out.println("jsonStr = "+jsonStr);
			//--------------------------------

            String apiURL = "https://naveropenapi.apigw.ntruss.com/text-summary/v1/summarize"; // 바뀐부분
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
			
			con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

			DataOutputStream dos = new DataOutputStream(con.getOutputStream());
			dos.write(jsonStr.getBytes());
			dos.flush();
			dos.close();

			//--------------------------------------------- 데이터 보내기 




			//--------------------------------------------- 데이터 받기
            int responseCode = con.getResponseCode();
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            
            //전송받은 Inputstream의 값을 읽어내기
            String inputLine;
            if(br != null) {
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();

            } 
        } catch (Exception e) {
            System.out.println(e);
        }

		System.out.println("summary ="+response.toString());
		//return response.toString();

        //결과의 summary키에 있는 값을 구하여 뷰로 전송하기
        JSONObject resultObj = new JSONObject(response.toString()); //문자열을 json객체로 생성하여 값을 구하기
        String summary = resultObj.getString("summary");
        //String summary = (String)resultObj(summary);

        return summary;

	}
}
