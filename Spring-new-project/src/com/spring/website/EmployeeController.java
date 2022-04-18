package com.spring.website;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDAO empDao;
	
	@RequestMapping("/")
	public ModelAndView showPage(Model theModel) throws IOException {
		ModelAndView modelandview = new ModelAndView();
		EmployeeCommonBean theEmployee=new EmployeeCommonBean();
		Employee newemployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		theModel.addAttribute("employee", newemployee);
		modelandview.addObject("day", empDao.getUserList(1));
		modelandview.addObject("month", empDao.getUserList(2));
		modelandview.addObject("year", empDao.getUserList(3));
		modelandview.addObject("empStatus", empDao.getUserList(4));
		modelandview.addObject("edu", empDao.getUserList(5));
		modelandview.setViewName("addDetails");
		return modelandview;
	}
	
	@RequestMapping("/saveForm")
	public String savePage(@ModelAttribute("employee")Employee theEmployee) {
		//empDao.insertData(theEmployee);
		return "saveDetail";
	}
	
	
	@RequestMapping(value="/showDetail/{id}")    
    public ModelAndView editPage(@PathVariable("id") int id, Model theModel){    
        Employee employee=empDao.getEmpById(id);    
        ModelAndView modelandview = new ModelAndView();
        modelandview.addObject("employee", employee);
		//modelandview.addObject("userId"," "+id);
		modelandview.addObject("day", empDao.getUserList(1));
		modelandview.addObject("month", empDao.getUserList(2));
		modelandview.addObject("year", empDao.getUserList(3));
		modelandview.addObject("empStatus", empDao.getUserList(4));
		modelandview.addObject("edu", empDao.getUserList(5));
		modelandview.setViewName("editDetail");
		return modelandview;   
    }
	
	@RequestMapping("showDetail/updateForm")
	public String updatePage(@ModelAttribute("employee")Employee theEmployee) {
		empDao.updateData(theEmployee);
		return "saveDetail";
	}
	
}
