package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KenziController {

	@RequestMapping("kenzi.can")
	public String can(Model model) {
		model.addAttribute("greeting","안녕하세요^,^");
		return "can"; // viewResolver에 의해 경로가 앞뒤로 붙어서 /WEB-INF/view/kenzi.jsp로 리턴된다
	}
	
	
	@RequestMapping("kenzi.do")
	//void를 하면 view를 return 하지않고 메서드 결과값을 보낸다  
	public void doo(HttpServletResponse response) throws IOException {
		//response의 컨텐츠타입을 text로 함으로써 텍스트를 보낸다 
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.write("view아니고 백에서 텍스트 보내기입니다 ");
		writer.flush();
	}
	
	

	@RequestMapping("kenzi.anything")
	public String anything(Model model) {
		model.addAttribute("greeting", "오늘 날씨 너무 좋당");// request 역할
		return "anything"; //MVCStart에 있는 viewResolver에 의해서 "/WEB-INF/view/"+ hello2 +".jsp"가 붙은 jsp로 가라 
	}
	
	
	
	
}//end class

