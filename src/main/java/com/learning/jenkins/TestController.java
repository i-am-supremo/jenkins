package com.learning.jenkins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/getData")
    public ResponseEntity<String> testMethod()
    {
        return new ResponseEntity<>(testService.returnTestData(), HttpStatus.OK);
    }

}
