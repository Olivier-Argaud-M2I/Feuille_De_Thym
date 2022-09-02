package fr.m2i.feuilledethym.repositories;


import fr.m2i.feuilledethym.models.Employee;
import fr.m2i.feuilledethym.models.Todo;
import fr.m2i.feuilledethym.utils.ProxyProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Component
public class TodoProxy {


    @Autowired
    ProxyProperty proxyProperty;

    @Value("${monUrlaMoi}")
    private String url;



    public Iterable<Todo> getTodos(){

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Iterable<Todo>> response = restTemplate.exchange(
//                proxyProperty.getApiUrl() + "/todos/all",
                url + "/todos/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Todo>>() {}
        );

        return response.getBody();

    }

    public Todo createTodo(Todo todo){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Todo> todoHttpEntity = new HttpEntity<Todo>(todo);

        ResponseEntity<Todo> response = restTemplate.exchange(
                proxyProperty.getApiUrl() + "/todos/save",
                HttpMethod.POST,
                todoHttpEntity,
                Todo.class
        );

        return response.getBody();
    }


    public void deleteTodo(Todo todo){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Todo> todoHttpEntity = new HttpEntity<Todo>(todo);

        ResponseEntity<Todo> response = restTemplate.exchange(
                proxyProperty.getApiUrl() + "/todos/delete",
                HttpMethod.DELETE,
                todoHttpEntity,
                Todo.class
        );

        response.getBody();
    }



}
