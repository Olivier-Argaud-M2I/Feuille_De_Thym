package fr.m2i.feuilledethym.controllers;


import fr.m2i.feuilledethym.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping(path = "/home")
    public String home(ModelMap model){
        model.put("todos",todoService.getTodos());
        model.put("message","youpi ca marche");
        return "home";
    }

    @GetMapping(path = "/home2")
    public String home2(ModelMap model){
//        model.put("todos",todoService.getTodos());
//        return new ModelAndView("home","todos",model);
        model.put("message","youpi ca marche");
        return "home";
    }


}
