package com.memorynotfound.ldap;

import com.memorynotfound.ldap.jpa.User;
import com.memorynotfound.ldap.jpa.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@EnableLdapRepositories(basePackages = "com.memorynotfound.ldap.**")
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void setup(){
        String phone = "fakephone";
        String email = "fakemail";
        log.info("Spring Boot + Spring LDAP Advanced LDAP Queries Example");

        log.info("looking for LDAP users with phone = {} using LdapTemplate:", phone);
        List<Person> persons = personRepository.getPersonNamesByPhone(phone);
        log.info("LDAP users with phone = {}: {} ", phone,  persons);

        log.info("looking for LDAP users with email = {} using Ldap Jpa Repository", email);
        List<User> users = userRepository.findByEmail(email);
        log.info("LDAP users with phone = {}: {} ", email,  users);

        System.exit(-1);
    }

}
