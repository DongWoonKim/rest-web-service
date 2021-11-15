package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {

    private static List<User> users  = new ArrayList<>();
    private static int usersCnt = 3;

    static {
        users.add(new User(1, "kim1", new Date(), "pass1", "test2"));
        users.add(new User(2, "kim2", new Date(), "pass2", "test2"));
        users.add(new User(3, "kim3", new Date(), "pass3", "test2"));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if(user.getId() == null) {
            user.setId(++usersCnt);
        }
        users.add(user);
        return user;
    }

    public User update(int id, User user) {

        User getUser = findOne(id);
        if(getUser == null) {
            return null;
        }

        getUser.setName(user.getName());
        getUser.setDate(new Date());
        System.out.println(getUser.getName() + " : " + getUser.getDate());
        return getUser;
    }

    public User findOne(int id) {
        for( User user : users) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public User deleteUserById(int id) {
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()) {
            User user = iterator.next();

            if(user.getId() == id) {
                iterator.remove();
                return user;
            }

        }

        return null;
    }

}
