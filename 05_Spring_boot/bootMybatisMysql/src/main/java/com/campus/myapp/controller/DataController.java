package com.campus.myapp.controller;




import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.campus.myapp.service.DataService;
import com.campus.myapp.vo.DataVO;

@RestController
@RequestMapping("/data/*")
public class DataController {
	@Inject
	DataService service;
	//자료실 목록
	ModelAndView mav = null;
    @GetMapping("dataList")
	public ModelAndView dataList() {
	
		mav= new ModelAndView();
		
		//DB저장
		mav.addObject("dataList", service.dataAllSelect());
		mav.setViewName("data/dataList");
		return mav;
	}
    //자료실 글등록 폼
    @GetMapping("dataWrite")
    public ModelAndView dataWrite() {
    	mav = new ModelAndView();
    	mav.setViewName("data/dataWrite");
    	return mav;
    }
    //자료실 글등록 + 파일업로드
    @PostMapping("dataWriteOk")      //파일 업로드 위치, MultipartRequest객체를 구한다.
    public ResponseEntity<String> dataWriteOk(DataVO vo, HttpServletRequest request) {
    	//업로드할 위치의 절대경로
    	String path = request.getSession().getServletContext().getRealPath("/upload");
    	System.out.println("path=" +path);
    	//-------------------------------------------
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
    	headers.add("Content-Type", "text/html; charset=UTF-8");
    	//파일 업로드
    	String message="";
    	
    	try {
    		//1.DataVO에 제목, 글내용은 request되어 있다.
    		//2.클라이언트 컴퓨터에 있는 파일이 서버로 복사하기 위해서는
    		// MultiPartHttpServletRequest 객체를 request객체에서 타입캐스팅으로 구한다.
    		// 해당 메소드의 request
    		
    		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request;
    		
    		//mr에는 업로드한 파일 수 만큼 MultipartFile객체가 존재한다.
    		//MultipartFile객체를 List컬렉션에 담아 리턴해준다.
    		
    		List<MultipartFile> files= mr.getFiles("filename");
    		
    		//업로드한 파일이 있을때
    		if(files !=null) {// if
    			//첨부한 파일의 수만큼 반복적으로, 순서대로 업로드를 처리한다.
    				int cnt=0;//업로드 번호 매기기
    				for(int i = 0; i<files.size(); i++) {//for 1

    					
    					//List에서 MultipartFile객체 얻어오기
    					MultipartFile mf = files.get(i);
    					
    					//업로드한 실제 파일명 orgName, path경로에 업로드
    					String orgName = mf.getOriginalFilename(); // 폼에서 선택한 파일명
    					System.out.println("원래파일명 : "+orgName);
    					
    					//이미 파일명이 존재할 경우 rename하는 작업을 수행한다.
    					if(orgName != null && !orgName.equals("")) {// if 2 원래 파일명이 있을때
    						File f = new File(path,orgName); // if file name is a.gif
    						//파일명이 존재하면 파일명을 변경을 해야한다.
    						if(f.exists()) {//if3 있으면 true 없으면 false
    							//중복되니 파일명을 변경
    							for(int renameNum = 1;;renameNum++) {
    								System.out.println(f.getName());
    								// a_1.gif
    								int dot = orgName.lastIndexOf(".");
    								String fileName = orgName.substring(0,dot);//파일명
    								String extName = orgName.substring(dot+1);//확장자
    								
    								f = new File(path,fileName+"_"+renameNum+"."+extName);
    								if(!f.exists()) { // 다른 파일명을 만들필요가 없음.
    									orgName = f.getName(); //파일명 + 파일명+ 확장자를 구해줌
    									break;
    									
    								}    								
    							}// for2
    						}//if3
    						//파일 업로드 실행
    						
    						mf.transferTo(f);
    						cnt++;
    						
    						if(cnt==1) vo.setFilename1(f.getName());
    						if(cnt==2) vo.setFilename2(f.getName());
    						
    				}//if2
    					
    			}//for1    			
    		}//if 1
    		//DB등록//////////////////
    		vo.setUserid((String)request.getSession().getAttribute("logId"));
    		int cnt = service.dataInsert(vo);//레코드 추가
    	
    		if(cnt>0) {//등록성공
    		
    			// 리스트로 이동
    			message += "<script>";
    			message += "alert('자료실 등록이 완료되었습니다.');";
    			message += "location.href = '/data/dataList'";
    			message += "</script>";
    			
    		}else {//등록실패	
    			throw new Exception();
    		}
     	}catch(Exception e){
     		e.printStackTrace();
     		//파일을 지우고 글 등록으로 다시 보내기
     		fileDelete(path,vo.getFilename1());
     		fileDelete(path,vo.getFilename2());
     		
     		message += "<script>";
     		message += "alert('글등록이 실패하였습니다.');";
     		message += "history.go(-1);";
     		message += "</script>";
    	}
    	System.out.println(message);
    	ResponseEntity<String> entity = new ResponseEntity<String>(message,headers,HttpStatus.OK);
    	return entity;
    }
    public void fileDelete(String path, String filename) {
    
    	try {
    		if(filename!=null) {
    			File file = new File(path,filename);
    			file.delete();
    		}
    	}catch(Exception e) {}
    } 
 }

