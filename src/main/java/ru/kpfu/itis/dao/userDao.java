package ru.kpfu.itis.dao;

import ru.kpfu.itis.entity.User;

import java.util.List;

public interface userDao {

    User getId(Integer id);

    List<User> getAll();

    void addUser(User user);
}
