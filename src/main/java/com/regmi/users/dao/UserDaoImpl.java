package com.regmi.users.dao;

import com.regmi.users.util.UserEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
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

        Query<UserEntity> query= session.createQuery("select from UserEntity where username =:uname",UserEntity.class) ;
        query.setParameter("uname",name);
        UserEntity userEntity=new UserEntity();
        try{
            userEntity=query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return userEntity;
    }
}
