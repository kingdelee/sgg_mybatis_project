package com.queen.mybatis.test;

import com.queen.mybatis.bean.User;
import com.queen.mybatis.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestClient {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testGetUserByAssocication() throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = openSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(1);
            System.out.println(user);
            System.out.println(user.getRole());
        } finally {
            openSession.close();
        }
    }

}
