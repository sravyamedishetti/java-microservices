package com.example.springboot.restwebservice.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static{
        users.add(new User(++usersCount, "Sravya", LocalDate.now().minusYears(27)));
        users.add(new User(++usersCount, "KG", LocalDate.now().plusYears(30)));
        users.add(new User(++usersCount, "Shameem", LocalDate.now().plusYears(32)));
    }
    public List<User> findAll(){
        return users;
    }

    public User findById(int id){
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public String addUser(User user){
        user.setId(++usersCount);
        users.add(user);
        return "Success";
    }

    public String deleteById(int id) {
        User user = null;
        user = findById(id);
       if(user!=null){
           users.remove(user);
           return "Removed User";
       } else {
           return "User not found to remove";
       }

    }
}
