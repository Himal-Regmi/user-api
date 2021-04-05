package com.regmi.users.dao;

import com.regmi.users.util.UserEntity;

public interface UserDao {
    public UserEntity getUserById(int id);

    public void saveUser(UserEntity user);

    public void deleteUser(int id);

    public UserEntity getUserByName(String name);
}
