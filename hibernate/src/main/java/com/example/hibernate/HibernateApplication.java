package com.example.hibernate;

import com.example.hibernate.dao.UserDao;
import com.example.hibernate.model.User;
import com.example.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;
    @Override
    public void run(String...args) throws Exception {
        User u = new User();
        u.setCountry("HN");
        u.setName("Hiep");
        userService.createUser(u);
        User u1 = userDao.getUserById(1L);
        System.out.println(u1.getName());
    }


}
