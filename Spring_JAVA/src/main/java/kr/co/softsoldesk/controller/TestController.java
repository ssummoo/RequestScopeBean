package kr.co.softsoldesk.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import kr.co.softsoldesk.beans.DataBean1;
import kr.co.softsoldesk.beans.DataBean2;
import kr.co.softsoldesk.beans.DataBean3;
import kr.co.softsoldesk.beans.DataBean4;


@Controller
public class TestController {
	
	//@RequestScope에 정의되어 있으므로 새로운 요청정보에 대해서만 request영역으로 들어갈 수 있음
	@Autowired
	DataBean1 requestBean1;  // ==>> Singleton
	
	@Resource(name="requestBean2")  //이름을 통한 주입
	DataBean2 requestBean2;
	
	@Autowired
	DataBean3 requestBean3;  // ==>> Singleton
	
	@Resource(name="requestBean4")  //이름을 통한 주입
	DataBean4 requestBean4;
	
	
	@GetMapping("/test1")
	public String test1() {
		
		requestBean1.setData1("JAVA");
		requestBean1.setData2("HTML/CSS");
		
		requestBean2.setData3("JavaScript");
		requestBean2.setData4("Jquery");
		
		requestBean3.setData5("JSP");
		requestBean3.setData6("Spring");
		
		requestBean4.setData7("Python");
		requestBean4.setData8("BigData");
		
		return "forward:/result1"; //jsp로 전달
	}
	@GetMapping("/result1")
	public String result1(Model model) {
		
		System.out.println("data1 : "+requestBean1.getData1());
		System.out.println("data2 : "+requestBean1.getData2());

		System.out.println("data3 : "+requestBean2.getData3());
		System.out.println("data4 : "+requestBean2.getData4());
		
		System.out.println("data5 : "+requestBean3.getData5());
		System.out.println("data6 : "+requestBean3.getData6());
		
		System.out.println("data7 : "+requestBean4.getData7());
		System.out.println("data8 : "+requestBean4.getData8());
		
	
		model.addAttribute("requestBean1", requestBean1);
		model.addAttribute("requestBean2", requestBean2);
		model.addAttribute("requestBean3", requestBean3);
		model.addAttribute("requestBean4", requestBean4);
		return "result1";
	}
	
	
	
}