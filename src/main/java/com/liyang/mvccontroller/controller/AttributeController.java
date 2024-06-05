package com.liyang.mvccontroller.controller;

import com.liyang.mvccontroller.entity.Role;
import com.liyang.mvccontroller.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
@RequestMapping("/attribute")
//@SessionAttributes(names = {"id"}, types = {Role.class})
public class AttributeController {

    @Autowired
    RoleService roleService = null;

    @RequestMapping("/session/{id}")
    public ModelAndView sessionAttrs(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.getRole(id);
        mv.addObject("role", role);
        mv.addObject("id", id);
        mv.setViewName("session_show");
        return mv;
    }

    @RequestMapping("/session/page")
    public ModelAndView sessionPage() {
        return new ModelAndView("session_attribute");
    }

    @RequestMapping("/session/param")
    public ModelAndView sessionParam(@SessionAttribute("id") Long id) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.getRole(id);
        mv.addObject("role", role);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }
}
