package com.campus.clova.controller;

import java.io.*;
import java.net.*;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Clova07_ocr_text_controller {
    @RequestMapping("/clova/ocrForm")
    public String ocrForm(){
        return "clova/ocrForm";   
    }
    @PostMapping("/clova/ocrOk")
    @ResponseBody
    public String ocrOk(@RequestParam("image") MultipartFile file){
        //////////////////
        String apiURL = "https://3xowxlywqa.apigw.ntruss.com/custom/v1/17842/6945660799097a4e10a20f228a5ad6ac6e528e711b241b2be4bc166bc5aa1d1a/general";// ocr에서 제공하는 url주소

		String secretKey = "Q0NpSmtaS0RsVVRZU0NsTVJ1UnlBcHl0T2hCdGxTQ0U=";

		//String imageFile = "YOUR_IMAGE_FILE";
        StringBuffer response = new StringBuffer(); //json이 문자로 저장되어 있음
        StringBuffer resultText = new StringBuffer();//inferText의 값을 문장으로 저장하기 위한 객체

		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setReadTimeout(30000);
			con.setRequestMethod("POST");
			String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
			con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			con.setRequestProperty("X-OCR-SECRET", secretKey);

			JSONObject json = new JSONObject();
			json.put("version", "V2");
			json.put("requestId", UUID.randomUUID().toString());
			json.put("timestamp", System.currentTimeMillis());
			JSONObject image = new JSONObject();
			image.put("format", "jpg");
			image.put("name", "demo");
			JSONArray images = new JSONArray();
			images.put(image);
			json.put("images", images);
			String postParams = json.toString();

			con.connect();
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			long start = System.currentTimeMillis();
			//File file = new File(imageFile);
			writeMultiPart(wr, postParams, file, boundary);
			wr.close();

			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();

			System.out.println(response);
		} catch (Exception e) {
			System.out.println(e);
		}
        //////////////////
        System.out.println("ocr_response : "+response.toString());
        ////Json 문자열을 json객체로 만들어 필요한 문자만 구하여 문장을 만든다.
        JSONObject jsonObj = new JSONObject(response.toString());
        JSONArray arr = jsonObj.getJSONArray("images");
        JSONObject imageArr =arr.getJSONObject(0); //0번째를 끄집어냄.

        JSONArray fieldArr = imageArr.getJSONArray("fields");
        for(int i=0; i<fieldArr.length();i++){
            JSONObject field = fieldArr.getJSONObject(i);
            resultText.append(field.getString("inferText")+" ");
            if(field.getBoolean("lineBreak")) {
                resultText.append("\n");
            }
        }
        /////////////////////
        return resultText.toString();
    }

    ///-----------------------------
    private static void writeMultiPart(OutputStream out, String jsonMessage, MultipartFile file, String boundary) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("--").append(boundary).append("\r\n");
		sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
		sb.append(jsonMessage);
		sb.append("\r\n");

		out.write(sb.toString().getBytes("UTF-8"));
		out.flush();

		if (!file.isEmpty()) {
			out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
			StringBuilder fileString = new StringBuilder();
			fileString
				.append("Content-Disposition:form-data; name=\"file\"; filename=");
			fileString.append("\"" + file.getName() + "\"\r\n");
			fileString.append("Content-Type: application/octet-stream\r\n\r\n");
			out.write(fileString.toString().getBytes("UTF-8"));
            out.flush();

            out.write(file.getBytes());
            out.write("\r\n".getBytes());
			out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
		}
		out.flush();
	}
    ///-----------------------------
}
