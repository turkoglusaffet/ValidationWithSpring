package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.person.Person;

@Controller
@RequestMapping("/")
public class HelloWorldController {
	/*
     * This method will serve as default GET handler.
     *
     */
    @RequestMapping(method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "save";
    }
 
    /*
     * This method will be called on form submission, handling POST request
     * It also validates the user input
     */
    @RequestMapping(method = RequestMethod.POST)
    public String saveRegistration(@Valid Person person, BindingResult result, ModelMap model){
 
        if(result.hasErrors()) {
                return "save";
        }
 
        model.addAttribute("success", "Dear "+ person.getFirstName()+" , your Registration completed successfully");
        return "success";
    }
 
    /*
     * Method used to populate the country list in view.
     * Note that here you can call external systems to provide real data.
     */
    @ModelAttribute("countries")
    public List<String> initializeCountries() {
 
        List<String> countries = new ArrayList<String>();
        countries.add("TURKEY");
        countries.add("USA");
        countries.add("RUSSIAN");
        countries.add("GERMANY");
        countries.add("ITALY");
        countries.add("OTHER");
        return countries;
    }
 
}
