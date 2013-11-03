package com.koushik.javabrains.dao.impl;

import com.koushik.javabrains.dao.TweetDao;
import com.koushik.javabrains.entity.TweetEntity;
import com.koushik.javabrains.model.TweetModel;
import com.koushik.javabrains.service.UserService;
import com.koushik.javabrains.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 9/29/13
 * Time: 4:44 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("tweetDao")
//@Transactional
public class TweetDaoImpl implements TweetDao{
//    @Autowired
//    private HibernateTemplate hibernateTemplate;
//    @Autowired
//    private TweetEntity tweetEntity;
    @Autowired
    private UserService userService;
    private SessionFactory sessionFactory;
    private static final Logger logger = Logger.getLogger(TweetDaoImpl.class);
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
        logger.debug("In setSessionFactory method");
//        hibernateTemplate =new HibernateTemplate(sessionFactory);
        this.sessionFactory = sessionFactory;

    }

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void insert(TweetModel tweetModel) {
/*        tweetModel.getTweet();
        hibernateTemplate.save(tweetModel);*/
        TweetEntity tweetEntity = new TweetEntity();
        tweetEntity.setTweetId(tweetModel.getTweetId());
        tweetEntity.setTweet(tweetModel.getTweet());
        logger.info(tweetModel.getUserSel());
        tweetEntity.setUserEntity(getUserService().getUserDao().getUser(tweetModel.getUserSel()));
        getCurrentSession().save(tweetEntity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TweetEntity> listTweets() {
        logger.debug("sexy too");
        return (List<TweetEntity>) getCurrentSession().createQuery("from  tweetEntity").list();
    }
    
    @Override
//    @Transactional(readOnly = false)
    public void deleteTweet(TweetModel tweetModel ) {

//        Object tweetEntity = hibernateTemplate.load(TweetEntity.class,tweetModel.getTweetId());
/*        Object tweetEntity = hibernateTemplate.get(TweetEntity.class,tweetModel.getTweetId());
        hibernateTemplate.delete(tweetEntity);*/

        TweetEntity tweetEntity= (TweetEntity)getCurrentSession().get(TweetEntity.class,tweetModel.getTweetId());

        getCurrentSession().delete(tweetEntity);
    }

    @Override
//    @Transactional(readOnly = false)
    public void updateTweet(TweetEntity tweetEntity) {
        //To change body of implemented methods use File | Settings | File Templates.
//        hibernateTemplate.update(tweetModel);
        getCurrentSession().update(tweetEntity);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
