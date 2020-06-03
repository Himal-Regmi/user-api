package com.regmi.userApi.dao;

import com.regmi.userApi.util.UserEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
@Repository
public class UserDaoImpl implements UserDao{
    EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public UserEntity getUserById(int id) {
        Session session= entityManager.unwrap(Session.class);
        return session.get(UserEntity.class,id);
    }

    @Override
    public void saveUser(UserEntity user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public void  deleteUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(session.get(UserEntity.class,id));
    }

    @Override
    public UserEntity getUserByName(String name) {
        Session session= entityManager.unwrap(Session.class);
        UserEntity userEntity= session.get(UserEntity.class,name);
        System.out.println(userEntity.getUsername());
        return userEntity;

        //return (UserEntity) session.createQuery("from UserEntity where name = \""+name+"\"") ;
    }
}
