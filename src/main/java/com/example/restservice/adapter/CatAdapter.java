/* package com.example.restservice.adapter;

import com.example.restservice.model.Cat;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CatAdapter {

    public List<Cat> callCatApi(){
        String url = "http://cat-fact.herokuapp.com/facts/";
        RestTemplate restTemplate = new RestTemplate();
        Cat cat = restTemplate.getForObject(url, Cat.class);
        System.out.println(cat);
        return cat;
    }
}
*/