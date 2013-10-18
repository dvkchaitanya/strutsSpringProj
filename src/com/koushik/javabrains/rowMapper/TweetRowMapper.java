package com.koushik.javabrains.rowMapper;

import com.koushik.javabrains.model.TweetModel;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 10/8/13
 * Time: 1:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class TweetRowMapper implements RowMapper {
    private static final Logger logger = Logger.getLogger(TweetRowMapper.class);
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        TweetModel tweetModel = new TweetModel();
        tweetModel.setTweetId(resultSet.getInt("tweetId"));
        tweetModel.setTweet(resultSet.getString("tweet"));

        return tweetModel;
    }
}
