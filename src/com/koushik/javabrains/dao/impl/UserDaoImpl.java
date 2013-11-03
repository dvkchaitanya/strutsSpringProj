package com.koushik.javabrains.dao.impl;

import com.koushik.javabrains.dao.UserDao;
import com.koushik.javabrains.entity.UserEntity;
import com.koushik.javabrains.model.UserModel;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * UserName: venkatakrishnachaita
 * Date: 9/29/13
 * Time: 4:44 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("userDao")
//@Transactional
public class UserDaoImpl implements UserDao{
//    @Autowired
//    private HibernateTemplate hibernateTemplate;
//    @Autowired
//    private UserEntity userEntity;
    private SessionFactory sessionFactory;
    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
        logger.info("In setSessionFactory method");
//        hibernateTemplate =new HibernateTemplate(sessionFactory);
        this.sessionFactory = sessionFactory;

    }

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void insert(UserModel userModel) {
/*        userModel.getUserName();
        hibernateTemplate.save(userModel);*/
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userModel.getUserId());
        userEntity.setUserName(userModel.getUserName());
        logger.info(userEntity.toString() + "sexy shakeela");
        getCurrentSession().save(userEntity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UserEntity> listUsers() {
        logger.info("sexy too");
        return (List<UserEntity>) getCurrentSession().createQuery("from  userEntity").list();
    }
    
    @Override
//    @Transactional(readOnly = false)
    public void deleteUser(UserModel userModel ) {

//        Object userEntity = hibernateTemplate.load(UserEntity.class,userModel.getUserId());
/*        Object userEntity = hibernateTemplate.get(UserEntity.class,userModel.getUserId());
        hibernateTemplate.delete(userEntity);*/

        UserEntity userEntity= (UserEntity)getCurrentSession().get(UserEntity.class,userModel.getUserId());

        getCurrentSession().delete(userEntity);
    }

    @Override
//    @Transactional(readOnly = false)
    public void updateUser(UserEntity userEntity) {
//        hibernateTemplate.update(userModel);
        getCurrentSession().update(userEntity);
    }

    @Override
    public UserEntity getUser(int userId) {
        UserEntity userEntity= (UserEntity)getCurrentSession().get(UserEntity.class,userId);
        return userEntity;  //To change body of implemented methods use File | Settings | File Templates.
    }


}
