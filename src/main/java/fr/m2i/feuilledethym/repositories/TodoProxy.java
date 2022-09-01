package fr.m2i.feuilledethym.repositories;


import fr.m2i.feuilledethym.models.Employee;
import fr.m2i.feuilledethym.models.Todo;
import fr.m2i.feuilledethym.utils.ProxyProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Component
public class TodoProxy {


    @Autowired
    ProxyProperty proxyProperty;



    public Iterable<Todo> getTodos(){

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Iterable<Todo>> response = restTemplate.exchange(
                proxyProperty.getApiUrl() + "/todos/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Todo>>() {}
        );

        return response.getBody();

    }

}
