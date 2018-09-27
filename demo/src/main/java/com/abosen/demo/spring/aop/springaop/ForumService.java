package com.abosen.demo.spring.aop.springaop;

import java.sql.SQLException;

/**
 * @author qiubaisen
 * @date 2018/9/27
 */
public interface ForumService {
    void updateIndex();

    void removeAllUser() throws SQLException;
}
