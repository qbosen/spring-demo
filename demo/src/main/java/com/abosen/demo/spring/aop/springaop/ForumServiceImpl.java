package com.abosen.demo.spring.aop.springaop;

import java.sql.SQLException;

/**
 * @author qiubaisen
 * @date 2018/9/27
 */
public class ForumServiceImpl implements ForumService {
    @Override
    public void updateIndex() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeAllUser() throws SQLException {
        throw new SQLException("数据库异常");
    }
}
