package com.memorynotfound.ldap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void setup(){
        log.info("Spring Boot + Spring LDAP Advanced LDAP Queries Example");

        List<Person> names = personRepository.getPersonNamesByLastName("John");
        log.info("names: " + names);

        names = personRepository.getPersonNamesByLastName2("Jihn");
        log.info("names: " + names);

        names = personRepository.getPersonNamesByLastName3("Jahn");
        log.info("names: " + names);

        System.exit(-1);
    }

}
