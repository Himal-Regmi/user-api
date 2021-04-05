package com.regmi.users.service;

import com.regmi.users.dao.UserDao;
import com.regmi.users.util.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
    private PasswordEncoder passwordEncoder;
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao,PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    @Transactional
    public UserEntity getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void saveUser(UserEntity user) {
        UserEntity userEntity=new UserEntity(user.getUsername(),
                passwordEncoder.encode(user.getPassword()),user.getRole());
        userEntity.setId(user.getId());
        userDao.saveUser(userEntity);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public UserEntity getUserByName(String name) {
        return userDao.getUserByName(name);
    }
}
