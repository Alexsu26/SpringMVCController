package com.liyang.mvccontroller.controller;

import com.liyang.mvccontroller.entity.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/validate")
public class ValidateController {

    @RequestMapping("/form")
    public ModelAndView formPage() {
        return new ModelAndView("validation");
    }

    @RequestMapping("/annotation")
    public ModelAndView annotatioinValidate(
            @Valid Transaction trans, Errors errors
    ) {
        ModelAndView mv = new ModelAndView();
        if (errors.hasErrors()) {
            List<FieldError> errorList = errors.getFieldErrors();
            for (FieldError error : errorList) {
                mv.addObject(error.getField(), error.getDefaultMessage());
            }
        }
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }
}
