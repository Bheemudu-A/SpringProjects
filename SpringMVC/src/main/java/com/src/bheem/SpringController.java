package com.src.bheem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringController {
	
	
	@RequestMapping("/hello")
	public String view() {		
		return "demoPage.jsp";
	}
	
	@RequestMapping("addAlien")
	public ModelAndView viewAlien(@RequestParam("Id")int idCard, @RequestParam("Name")String Name, ModelAndView mv) {

	Aliean alien = new Aliean();
		alien.setId(idCard);
		alien.setName(Name);

		mv.addObject("result", alien);	
		mv.setViewName("result.jsp");
		
		return mv;
	}
	 
}
