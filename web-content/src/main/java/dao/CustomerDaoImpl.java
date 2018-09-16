package dao;

import po.Customer;

import java.sql.*;

/**
 * @author qiubaisen
 * @date 2018/9/16
 */
public class CustomerDaoImpl implements CustomerDao {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private int line;

    @Override
    public Integer insert(Customer customer) {
        try {
            // 1. 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ssm";
            String username = "abosen";
            String password = "abosen";
            // 2. 获取连接
            this.connection = DriverManager.getConnection(url, username, password);
            // 3. 获取预编译对象
            // preparedStatement对象要预编译的SQL语句，可以使用?占位符
            String sql = "INSERT INTO customer (name ,principle_name) VALUES (?,?)";
            statement = connection.prepareStatement(sql);
            // 设置参数，替换?占位符
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getPrincipalName());
            // 4. 执行SQL语句
            line = statement.executeUpdate();
            // 5. 处理结果集
            // 返回值表示影响了几行
            System.out.println(line);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return line;
    }
}
