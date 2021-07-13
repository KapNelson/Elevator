package com.sytoss.edu2021;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class AdminClient {

    @Autowired
    private RestTemplate restTemplate;
}
