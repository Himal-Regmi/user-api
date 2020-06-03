package com.regmi.userApi.dao;

import com.regmi.userApi.util.UserEntity;

public interface UserDao {
    public UserEntity getUserById(int id);

    public void saveUser(UserEntity user);

    public void deleteUser(int id);

    public UserEntity getUserByName(String name);
}
