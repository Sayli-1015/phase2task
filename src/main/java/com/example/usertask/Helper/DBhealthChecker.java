package com.example.usertask.Helper;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;

@Controller
public class DBhealthChecker implements HealthIndicator {

    public static final String DB_SERVICE="Database Service";


    public boolean isHealthGood(){
        return true;
    }


    @Override
    public Health health(){
       if(isHealthGood()){
           return Health.up().withDetail(DB_SERVICE,"Database service is running").build();
       }

       return Health.down().withDetail(DB_SERVICE,"Database Service is not running").build();
    }


}
