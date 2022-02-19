/* package com.example.restservice.api;

import com.example.restservice.model.Cat;
import com.example.restservice.service.CatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatController {

    @GetMapping("/cat")
    public ResponseEntity<List<Cat>> getRandomCat(){
        CatService catService = new CatService();
        return new ResponseEntity<>(catService.getCat(), HttpStatus.OK);
    }
}
*/