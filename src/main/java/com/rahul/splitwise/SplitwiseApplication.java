package com.rahul.splitwise;

import com.rahul.splitwise.model.User;
import com.rahul.splitwise.repository.UserDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
@EnableSwagger2
public class SplitwiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }


//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.basePackage("com.*")).build();
//    }

//    @Bean
//    public CommandLineRunner saveUser(UserDao userDao) {
//        return args -> {
//            User user = new User();
//            user.setName("Rahul");
//            user.setEmailId("rahul@gmail.com");
//            user.setUserName("rahul");
//            user.setPassword("rahul123");
//            userDao.save(user);
//        };
//    }

    @Bean
    public CommandLineRunner getAllUsers(UserDao userDao) {
        return args -> {
            List<User> list = userDao.findAll();
            System.out.println(list);
        };
    }

}
