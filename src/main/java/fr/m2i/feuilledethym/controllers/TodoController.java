package fr.m2i.feuilledethym.controllers;


import fr.m2i.feuilledethym.models.Todo;
import fr.m2i.feuilledethym.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

@Controller
public class TodoController {

    private Todo tododTemp = new Todo();
    @Autowired
    TodoService todoService;


    @GetMapping(path = "/todo")
    public String home(ModelMap model, @ModelAttribute Todo todo){
        model.put("todos",todoService.getTodos());
        model.put("message","Youpi ca marche");
        if(tododTemp!=null){
            todo.setId(tododTemp.getId());
            todo.setName(tododTemp.getName());
            todo.setDescription(tododTemp.getDescription());
        }
        return "todo";
    }


    @GetMapping(path = "/form")
    public String initForm(@ModelAttribute Todo todo){

        return "todo";
    }


    @PostMapping("/form")
//    @RolesAllowed({"ADMIN","USER"})
    public String postTodo(@ModelAttribute Todo todo){

        System.out.println(todo);
        todoService.createTodo(todo);

        tododTemp = null;
        return "redirect:/todo";
    }


    @PostMapping("/delete")
//    @RolesAllowed({"ADMIN","USER"})
    public String delTodo(@ModelAttribute Todo todo){

        todoService.deleteTodo(todo);

        return "redirect:/todo";
    }

    @PostMapping("/editer")
//    @RolesAllowed({"ADMIN","USER"})
    public String editerlTodo(@ModelAttribute Todo todo){
        tododTemp = todo;

        return "redirect:/todo";
    }


}
