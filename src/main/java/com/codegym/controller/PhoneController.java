package com.codegym.controller;

import com.codegym.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("/phone-number")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("phoneNumber", new PhoneNumber());
        return modelAndView;
    }

    @PostMapping("/validate-number")
    public ModelAndView showResult(@Valid @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, BindingResult bindingResult) {
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("index");
        } else {
            ModelAndView modelAndView = new ModelAndView("result");
            modelAndView.addObject("phoneNumber", phoneNumber);
            return modelAndView;
        }
    }
}
