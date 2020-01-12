package com.example.hibernate.service;

import com.example.hibernate.dao.UserDao;
import com.example.hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    UserDao userDao;

    public List<User> getUser() {
        // TODO Auto-generated method stub
        return userDao.getUser();
    }

    public User findById(int id) {
        // TODO Auto-generated method stub
        return userDao.findById(id);
    }

    public void createUser(User user) {
        // TODO Auto-generated method stub
        userDao.addUser(user);
    }

    public void deleteUserById(int id) {
        // TODO Auto-generated method stub
        userDao.delete(id);
    }
    @Override
    public User updatePartially(User user, int id) {
        userDao.updateCountry(user,id);
        return userDao.findById(id);
    }

    @Override
    public User update(User user,int id) {
        // TODO Auto-generated method stub
        return userDao.update(user, id);
    }

}