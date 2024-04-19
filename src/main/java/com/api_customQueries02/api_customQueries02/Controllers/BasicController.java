package com.api_customQueries02.api_customQueries02.Controllers;

import com.api_customQueries02.api_customQueries02.Services.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class BasicController {
    @Autowired
    private BasicService basicService;

    @GetMapping("/saluto")
    public ResponseEntity<String> getDateTime(){
        return ResponseEntity.ok().body(basicService.hello());
    }
}