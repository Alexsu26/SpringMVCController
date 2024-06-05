package com.liyang.mvccontroller.controller;

import com.liyang.mvccontroller.entity.Role;
import com.liyang.mvccontroller.entity.RoleParams;
import com.liyang.mvccontroller.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

@Controller
@RequestMapping("/params")
public class ParamsController {

    @Autowired
    RoleService roleService = null;

//    接收普通HTTP参数，响应请求为./common，提交表单后，HTTP参数就会添加到URL上面，无需注释即可拿到
    @RequestMapping("/common")
    public ModelAndView commonParams(String roleName, String note) {
        System.out.println("roleName => " + roleName);
        System.out.println("note => " + note);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    // 通过POJO获取HTTP请求参数
    @RequestMapping("/common/pojo")
    public ModelAndView commonParamPojo(RoleParams roleParams) {
        System.out.println("roleName => " + roleParams.getRoleName());
        System.out.println("note => " + roleParams.getNote());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    // 修改表单roleName名称为role_name后，上面函数的参数列表就与HTTP请求参数不同，获取不到
    // 就需要使用 @RequestParam 获取
    // localhost:8080/params/request
    @RequestMapping("/request")
    public ModelAndView requestParam(
            @RequestParam("role_Name") String roleName, String note
    ) {
        System.out.println("roleName => " + roleName);
        System.out.println("note => " + note);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    // 接收 URL 参数，例如/params/role/1 ,1即为参数
    // {id}表示接收一个URL参数
    // 访问：localhost:8080/params/role/1
    @RequestMapping("/role/{id}")
    public ModelAndView pathVariable(@PathVariable("id") Long id) {
        Role role = roleService.getRole(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject(role);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public ModelAndView findRoles(@RequestBody RoleParams roleParams) {
        List<Role> roleList = roleService.findRoles(roleParams);

        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList", roleList);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    // 重定向，新增角色时打印角色信息
    @RequestMapping("/role/insert")
    public ModelAndView insertRole(ModelAndView mv, String roleName, String note) {
        Role role = new Role();
        role.setName(roleName);
        role.setNote(note);
        roleService.insertRole(role);

        mv.setViewName("redirect:./info");
        mv.addObject("roleName", roleName);
        mv.addObject("note", "note");
        mv.addObject("id", role.getId());
        return mv;
    }

    // localhost:8080/params/index
    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("role");
    }

    @RequestMapping("/role/info")
    public ModelAndView showRoleJsonInfo(Long id, String roleName, String note) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        mv.addObject("id", id);
        mv.addObject("roleName", roleName);
        mv.addObject("note", note);
        return mv;
    }
}
