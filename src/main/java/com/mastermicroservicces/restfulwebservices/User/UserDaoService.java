package com.mastermicroservicces.restfulwebservices.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDaoService {
    //JPA/Hibernate > Database
    //UserDaoServic > Static List

    private static List<User> users=new ArrayList<>();
    static {
        users.add(new User(1,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(2,"Eve", LocalDate.now().minusYears(25)));
        users.add(new User(3,"Jim", LocalDate.now().minusYears(20)));
    }
    public List<User>findAll(){
        return users;
    }
}
