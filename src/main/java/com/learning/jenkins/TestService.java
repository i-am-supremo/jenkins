package com.learning.jenkins;

import org.springframework.stereotype.Service;

@Service
public class TestService {


    public String returnTestData() {
        return "Hello User Getting Data From Services";
    }
}
