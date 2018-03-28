package io.cvaldezchavez.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.cvaldezchavez.dao.SubcriptorDao;
import io.cvaldezchavez.form.Subcriptor;

@Controller
public class RegisterController {
	
	final Logger log = LoggerFactory.getLogger(RegisterController.class); 
	
	@Autowired
	private SubcriptorDao subcriptorDao;
	
	@RequestMapping("/list")
	public String home(Model model) {
		model.addAttribute("list", subcriptorDao.listSubcriptor());
		return "list";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loadForm(Model model) {
		model.addAttribute("subcriptor", new Subcriptor());
		return "form";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String submitForm(@Valid Subcriptor subcriptor, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "form";
		}
		subcriptorDao.saveSubcriptor(subcriptor);
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyyHHmmssSSS");
		log.info(String.format("Tx {%d_%s} complete", subcriptor.getId(), now.format(format)));
		model.addAttribute("message", "Successfully saved " + subcriptor.toString());
		return "form";
	}

}
