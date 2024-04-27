package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        List<User> userList = new ArrayList<>();

        userList.add(new User("John" , "Doe"     , (byte) 25));
        userList.add(new User("Jane" , "Smith"   , (byte) 30));
        userList.add(new User("David", "Johnson" , (byte) 35));
        userList.add(new User("Sarah", "Williams", (byte) 28));



        userList.forEach(user -> {
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.println("User с именем – " + user.getName() + " добавлен в базу данных");
        });

        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
