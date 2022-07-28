package com.campus.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	@RequestMapping("/ajaxView")
	public String ajaxHome() {
		return "ajax/ajaxView"; //뷰페이지 주소
	}
	
	@RequestMapping(value ="/ajaxString", produces= "application/text;charset=UTF-8")
	@ResponseBody//리턴 되는 값이 뷰가 아닌 데이터이다.
	public String ajaxString(int num,String name, String tel){
		System.out.println(num+","+name+","+tel);
		
		String data = "<p>번호:"+num+"<br/>이름:" +name+"</br>연락처:"+tel+"</p>"; 
		
		return data;
	}
	
	@RequestMapping("/ajaxObject")
	@ResponseBody//리턴 되는 값이 뷰가 아닌 데이터이다.
	public TestVO ajaxObject(int num, String username) {
		System.out.println(num+","+username);
		
		TestVO vo = new TestVO();
		vo.setNo(9999);
		vo.setUsername("김연아");
		vo.setTel("010-1111-2222");
		vo.setAddr("서울시 강남구 역삼동");
		
		return vo;	
	}
	
	@RequestMapping("/ajaxList")
	@ResponseBody
	public List<TestVO> ajaxList(){
		List<TestVO> lst = new ArrayList<TestVO>();
		
		lst.add(new TestVO(1,"홍길동","010-2222-3333"," 서울시 강동구 "));
		lst.add(new TestVO(2,"김길동","010-2222-3334"," 서울시 강서구 "));
		lst.add(new TestVO(3,"박길동","010-2222-3335"," 서울시 강북구 "));
		lst.add(new TestVO(4,"고길동","010-2222-3336"," 서울시 강남구 "));
		
		return lst;
	}
	@RequestMapping("ajaxMap")
	@ResponseBody
	public HashMap<String,TestVO> ajaxMap() {
		HashMap<String,TestVO> map = new HashMap<String, TestVO>();
		
		map.put("m1", new TestVO(100,"이민호","010-2222-3337","서울시 강동구"));
		map.put("m2", new TestVO(200,"박서준","010-2222-3338","서울시 강서구"));
		map.put("m3", new TestVO(300,"박보검","010-2222-3339","서울시 강북구"));
		
		return map;
	}
	@RequestMapping("/ajaxJson")
	@ResponseBody
	public String ajaxJson(int num, String name, String tel) {
		
		//클라이언트 측에서 서버로 전송된 json데이터
		System.out.printf("%d, %s, %s \n",num,name,tel);
		
		int code = 5865;
		String productName = "컴퓨터";
		int price = 15000;
		
		//{"code" : "5865","productName":"컴퓨터" ,"price":"15000"}    // json을 문자열로 만드는 방법
		String jsonData="{\"code\":\""+code+"\"";
		jsonData +=",\"productName\":\""+productName+"\"";
		jsonData +=",\"price\":\""+price+"\"}";
		
		System.out.println(jsonData);
		return jsonData;
	}
	@RequestMapping(value="/ajaxForm",method=RequestMethod.POST, produces= "application/text;charset=UTF-8")
	@ResponseBody
	public String ajaxForm(@RequestParam("num") int num, @RequestParam("username") String username){
		//폼(ajaxView)에서 보낸 데이터  왼쪽을 오른쪽에
		System.out.println("번호->"+num);
		System.out.println("이름->"+username);
		
		return num+","+username;
	}
}
