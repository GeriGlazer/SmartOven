package com.fp.smartOven.services;


import com.fp.smartOven.beans.User;
import com.fp.smartOven.repositories.RecipeRepo;
import com.fp.smartOven.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService{

    @Autowired
    UserRepo userRepo;

    public boolean login(User user) {
        if(user.getEmail().equalsIgnoreCase(userRepo.findByEmail(user.getEmail()).toString())){
            System.out.println("Logged in");
        }else {
            //custom exception or proceed to create new user
        }

        return false;
    }

    public void createNewUser() {
    }

    public User updateDetails() {
        return null;
    }

    public void deleteUser(int id) {

    }
}
