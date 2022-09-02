package fr.m2i.feuilledethym.controllers;


import fr.m2i.feuilledethym.models.Todo;
import fr.m2i.feuilledethym.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private Todo tododTemp = new Todo();
    @Autowired
    TodoService todoService;


    @GetMapping(path = {"/home","/"})
    public String home(ModelMap model){

        return "home";
    }


}
