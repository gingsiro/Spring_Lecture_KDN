package com.kdn.controller;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kdn.model.domain.Member;

@Controller
public class MainController {
	/**
	 * ---1. @RequestMapping
	 * 	- url 요청에 대한 handler method를 연결하는 기능
	 * 	- 속성
	 * 		value : 요청 url
	 * 			형식] value="url" 또는 value={"url", "url", ...}
	 * 		method : 요청에 대한 처리 method 설정
	 * 			생략 시 메서드 방식 무관.
	 * 
	 * ---2. 인자 : 클라이언트의 요청 정보
	 * 
	 * 	 2.1 String : 인자명으로 요청 파라미터를 추출
	 * 		- 요청 데이터가 없어도 오류가 발생하지 않음
	 * 	ex) String name
	 * 		String name = request.getParameter("name");
	 * 
	 * 	 2.2 Primitive Type
	 * 		- 인자명으로 요청 파라미터를 추출한 후 해당 타입으로 형변환
	 * 		- 요청 데이터가 없는 경우 오류 발생
	 * 
	 * 	 2.3 @RequestParam Type(String, Primitive) 인자명
	 * 	- 요청정보를 추출
	 * 	- 속성
	 * 	value : 요청 파라미터 이름을 설정
	 * 	required : 
	 * 		true : 요청 데이터가 없으면 error발생
	 * 		false : 요청 데이터가 없어도 error발생X (기본값)
	 * 	defaultValue : 요청 데이터가 없으면 기본값 처리
	 * 
	 *   2.4 DTO (Data Transfer Object)
	 *  - 클래스에 선언된 모든 속성을 이용해서 속성명으로 요청정보 추출
	 *  - 해당 클래스의 객체 생성
	 *  - 요청정보를 세팅
	 *  - Primitive Type이면 변환도 해줌
	 *  - Request에 [클래스] 이름으로 저장
	 *  ex) Member m
	 *  	Member m = new Member();
	 *  	m.setId(request.getParameter("id"));
	 *  	m.setPw(request.getParameter("pw"));
	 *  	m.setName(request.getParameter("name"));
	 *  	m.setEmail(request.getParameter("email"));
	 *  	m.setAddress(request.getParameter("address"));
	 *  	request.setAttribute("member", m);
	 *  
	 *   2.5 @RequestParam Map
	 *  - 모든 요청 정보를 추출해서 Map 에 담아 리턴
	 *  
	 *   2.6 @ModelAttribute("request에 저장할 이름") DTO
	 *  - 클래스에 선언된 모든 속성을 이용해서 속성명으로 요청정보 추출
	 *  - 해당 클래스의 객체 생성
	 *  - 요청정보를 세팅
	 *  - Primitive Type이면 변환도 해줌
	 *  - Request에 [지정한] 이름으로 저장
	 *  - 클래스 이름이 너무 길어지면 사용할 수 있다.
	 *  
	 *   2.7 Servlet API
	 *  - HttpServletRequest, HttpServletResponse, InputStream, Reader, OutputStream, Writer, HttpSession, ...
	 *  
	 *   2.8 Model
	 *  - model 수행한 결과를 저장하는 곳
	 *  	=> Request에 setAttribute한다.
	 *  
	 *   2.9 MultipartFile
	 *  - 요청 정보에서 File정보만 추출 
	 *  - commons-io-xxx.jar, commons-fileupload-xxx.jar 라이브러리 추가 (apache-commons 1.3.2)
	 *  - MultipartFileResolver를 Bean으로 등록
	 *  
	 * ---3. 리턴
	 * 	- View 정보
	 * 	
	 * 	 3.1 String
	 *  - View에 대한 url을 문자열로 리턴
	 * 		forward : "forward:url"	 or	 "url"
	 * 		redirect : "redirect:url"
	 * 	
	 *   3.2 void
	 * 	- 요청 url에서 확장자를 뺀 경로를 view url로 사용
	 *  - View Resolver를 설정해서 view에 대한 url을 완성해야 한다.
	 * 
	 *   3.3 ModelAndView
	 * 	- Model 수행 결과와 View 정보를 저장한 객체
	 * 	-  
	 * 
	 * 	 3.4 DTO
	 *  - 리턴 타입을 DTO로 설정할 수 있음
	 *  - REST 서비스
	 *  - Jackson-mapper-asl-xxx.zip, Jacson-core-asl-xxx.zip
	 *  	=> pom.xml 에 추가해줘야하는데 mapper만 추가하면 core가 자동으로 다운되는지 확인
	 *  - @ResponseBody 추가 => 직접 출력하겠다는 의미
	 *  - mvc-config.xml에 <mvc:annotation-driven/> 필요
	 */
	
	//2.2 Primitive Type
	/*@RequestMapping(value="hello.do", method=RequestMethod.GET)//잘 되던것을 POST로 바꾸면 현재는 보내는 방식이 GET이기 때문에 작동이 안됨 (405 에러) 
	public String hello(String msg){
		System.out.println("msg>>>>>>>>>>>>>>>>>>>>" + msg);
		return "hello";
	}*/
	
	//2.3 @RequestParam
	/*@RequestMapping(value="hello.do", method=RequestMethod.GET)//잘 되던것을 POST로 바꾸면 현재는 보내는 방식이 GET이기 때문에 작동이 안됨 (405 에러) 
	public String hello(@RequestParam(defaultValue="5000")int msg){
		System.out.println("msg>>>>>>>>>>>>>>>>>>>>" + msg);
		return "hello";
	}*/
	
	//2.1 String
	/*@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String login(String id, String pw){
		System.out.println(id+"/"+pw);
		return "index";
	}*/
	
	//2.3 @RequestParam
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String login(@RequestParam(required=true)String id, String pw){
		System.out.println(id+"/"+pw);
		return "index";
	}
	
	//2.4 DTO
	/*@RequestMapping(value="insertMember.do", method=RequestMethod.POST)
	public String insertMember(Member m){
		return "memberInfo";
	}*/
	
	//2.5 @RequestParam Map
	/*@RequestMapping(value="insertMember.do", method=RequestMethod.POST)
	public String insertMember(@RequestParam Map<String, String> m){
		//RequestParam은 바로 삽입이 안됨
		//저장만 해야 함
		System.out.println(m);
		return "memberInfo";
	}*/
	
	//2.6 @ModelAttribute("request에 저장할 이름") DTO
	@RequestMapping(value="insertMember.do", method=RequestMethod.POST)
	public String insertMember(@ModelAttribute("mem") Member m){
		return "memberInfo2";
	}
	
	//3.2 void
	// InternalResourceViewResolver에 의해 /WEB-INF/view/hello.jsp
	@RequestMapping(value="hello.do", method=RequestMethod.GET)//잘 되던것을 POST로 바꾸면 현재는 보내는 방식이 GET이기 때문에 작동이 안됨 (405 에러) 
	public void hello(@RequestParam(defaultValue="5000")int msg){
		System.out.println("msg>>>>>>>>>>>>>>>>>>>>" + msg);
	}
	
	//3.4 DTO
	@ResponseBody
	@RequestMapping(value="rest.do", method=RequestMethod.GET)
	public Member rest(){
		return new Member("kdn", "1111", "한전kdn", "admin@kdn.com", "나주");
	}
	
	/*
	 * 파일 업로드 처리
	 */
	@RequestMapping(value="insertBoard.do", method=RequestMethod.POST)
	public String fileUpload(MultipartFile fileUp, HttpServletRequest request, Model model){
		//저장할 파일 경로
		String dir = request.getRealPath("/upload/");
		//사용자가 업로드한 파일 이름
		String rfilename = fileUp.getOriginalFilename();
		//시스템에 저장할 파일 이름
		String sfilename = String.format("%d%s", System.currentTimeMillis(), rfilename);
		File file = null;
		try {
			file = new File(dir+"/"+sfilename);
			fileUp.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("rfilename", rfilename);
		model.addAttribute("sfilename", sfilename);
		
		return "fileInfo";
	}
}
