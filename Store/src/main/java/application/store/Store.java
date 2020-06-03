package application.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import application.model.Devices;

@Controller
public class Store {
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	@RequestMapping("/{brandName}")
	public ModelAndView samsung(@PathVariable("brandName") String brandName) {
		ModelAndView mav = null;
		RestTemplate restTemplate = null;
		String result;
		
		switch(brandName.toLowerCase()) {
		case "samsung":
			mav = new ModelAndView("samsung");
			restTemplate=new RestTemplate();
			result=restTemplate.getForObject("http://localhost:8082/samsung/devices",String.class);
			mav.addObject("Devices",result);
			return mav;
			
		case "apple":
			mav = new ModelAndView("apple");
			restTemplate=new RestTemplate();
			ObjectMapper mapper = new ObjectMapper();
			String result2 = null;
			Devices result1=restTemplate.getForObject("http://localhost:8083/apple/devices",Devices.class);
			try {
				result2 = mapper.writeValueAsString(result1);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			mav.addObject("Devices",result2);
			return mav;
		
		default:
			return new ModelAndView("redirect: /error");		}
		
	}
	/*
	@RequestMapping("/apple")
	public ModelAndView apple() {
		ModelAndView mav=new ModelAndView("apple");
		RestTemplate restTemplate=new RestTemplate();
		String result=restTemplate.getForObject("http://localhost:8083/apple/devices",String.class);
		mav.addObject("Devices",result);
		return mav;
		
	}*/
	
}
