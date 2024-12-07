//package ru.kpfu.itis.dao.impl;
//
//import ru.kpfu.itis.dao.userDao;
//import ru.kpfu.itis.entity.User;
//import ru.kpfu.itis.util.DatabaseConnectionUtil;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoImpl implements userDao {
//    private final Connection connection = DatabaseConnectionUtil.getConnection();
//
//    public User get(Integer id) {
//        return null;
//    }
//
//    @Override
//    public User getId(Integer id) {
//        return null;
//    }
//
//    @Override
//    public List<User> getAll() {
//        List<User> users;
//        try {
//            Statement statement = connection.createStatement();
//            // language=sql
//            String sql = "SELECT * FROM users";
//            ResultSet resultSet = statement.executeQuery(sql);
//            users = new ArrayList<>();
//            while (resultSet.next()) {
//                users.add(new User(
//                        resultSet.getInt("id"),
//                        resultSet.getString("name"),
//                        resultSet.getString("lastname"),
//                        resultSet.getString("login"),
//                        resultSet.getString("password")
//                ));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return users;
//    }
//
//    @Override
//    public void addUser(User user) {
//
//    }
//
//    @Override
//    public void save(User user) {
//        // language=sql
//        String url = "INSERT INTO users (name, lastname, login, password) values (?, ?, ?, ?)";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(url);
//            preparedStatement.setString(1, user.getName());
//            preparedStatement.setString(2, user.getLastname());
//            preparedStatement.setString(3, user.getLogin());
//            preparedStatement.setString(4, user.getPassword());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
