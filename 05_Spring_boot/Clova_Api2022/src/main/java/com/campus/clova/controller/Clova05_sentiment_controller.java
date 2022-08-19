package com.campus.clova.controller;

import java.io.*;
import java.net.*;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Clova05_sentiment_controller {

    @GetMapping("/clova/sentiment")
    public ModelAndView sentiment(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("clova/sentiment");
        return mav;
    }
    @PostMapping("/clova/sentimentOk")
    public HashMap sentimentOk(@RequestParam("content") String content){

        String clientId = "6xzpv2vi46";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "0Fd5DjUUZhpqV7Gt40anXGueLrC2VuWaKtNY26eF";//애플리케이션 클라이언트 시크릿값";
       
        BufferedReader br = null;//전송받은 정보가 있는 inputstream
        StringBuffer response = new StringBuffer();

        HashMap map = new HashMap();

        try {
			//클라우드로 보낼 데이터를 준비한다.

			JSONObject jsonData = new JSONObject(); // 그래들에 있어서 됌.
			jsonData.put("content", content); // summaryOk에서title이라 title. key가 title인 이유는api가 그래서
			

			String jsonStr = jsonData.toString();
			System.out.println("jsonStr = "+jsonStr);
			//--------------------------------

            String apiURL = "https://naveropenapi.apigw.ntruss.com/sentiment-analysis/v1/analyze"; // 바뀐부분
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
        System.out.println(response.toString());//서버에서 받은 데이터
        //********************************************
        JSONObject jsonResult = new JSONObject(response.toString());

        //전체 감정분석
        JSONObject document=jsonResult.getJSONObject("document");
        SentimentVO analVO = new SentimentVO();
        analVO.setSentiment(document.getString("sentiment"));

        JSONObject confidence =document.getJSONObject("confidence");//11시 18분
        analVO.setNeutral(confidence.getDouble("neutral"));
        analVO.setPositive(confidence.getDouble("neutral"));
        analVO.setNegative(confidence.getDouble("negative"));

        //문장별 감정분석
        JSONArray sentencesArray = jsonResult.getJSONArray(("sentences"));

        //문장별 감정분석을 VO에 추가하고 VO를 List에 추가한다.
        List<SentimentVO> sentimentList = new ArrayList<SentimentVO>();
        for(int i=0; i<sentencesArray.length(); i++){
            JSONObject obj =sentencesArray.getJSONObject(i);
            SentimentVO vo = new SentimentVO();
            vo.setContent(obj.getString("content"));
            vo.setSentiment(obj.getString("sentiment"));

            JSONObject conObj =obj.getJSONObject("confidence"); //conObj에 감정의 비율이 들어감
            vo.setNeutral(conObj.getDouble("neutral"));
            vo.setPositive(conObj.getDouble("positive"));
            vo.setNegative(conObj.getDouble("negative"));

            sentimentList.add(vo);
        }
        map.put("analVO",analVO);//전체 결과
        map.put("list",sentimentList);//문장 결과
        //********************************************
        System.out.println("vo = "+analVO.toString());//서버에서 받은 데이터

        return map;
    }
}
