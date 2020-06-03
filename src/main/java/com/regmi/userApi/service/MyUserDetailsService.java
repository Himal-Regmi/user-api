package com.regmi.userApi.service;

import com.regmi.userApi.dao.UserDao;
import com.regmi.userApi.exception.UserNotFoundException;
import com.regmi.userApi.util.MyUserDetails;
import com.regmi.userApi.util.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private UserDao userDao;

    @Autowired
    public MyUserDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = userDao.getUserByName(s);
        if(userEntity==null){
            throw new UserNotFoundException("No such user found");
        }
        return new  MyUserDetails(userEntity);
    }
}
