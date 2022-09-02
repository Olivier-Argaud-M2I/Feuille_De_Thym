package fr.m2i.feuilledethym.services;


import fr.m2i.feuilledethym.models.Todo;
import fr.m2i.feuilledethym.repositories.TodoProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoProxy todoProxy;


    public Iterable<Todo>getTodos(){
        return todoProxy.getTodos();
    }

    public Todo createTodo(Todo todo){
        return todoProxy.createTodo(todo);
    }

    public void deleteTodo(Todo todo){
        todoProxy.deleteTodo(todo);
    }


}
