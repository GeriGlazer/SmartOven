package com.fp.smartOven.services;


import com.fp.smartOven.beans.User;
import com.fp.smartOven.exceptions.CustomExceptions;
import com.fp.smartOven.repositories.RecipeRepo;
import com.fp.smartOven.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService{

    @Autowired
    UserRepo userRepo;

    public boolean login(String email) throws CustomExceptions {
        boolean registered = userRepo.existByEmail(email);
        if(!registered){
            throw new CustomExceptions("Please create new account");
        }
        System.out.println("Logged in");
        return true;
    }

    public void createNewUser(User user) throws CustomExceptions {
        if(user.getEmail().equalsIgnoreCase(userRepo.findByEmail(user.getEmail()).toString())){
            throw new CustomExceptions("Email already exist");
        }
        userRepo.save(user);
        System.out.println("New user registered successfully");
    }

    public User updateDetails(User user) {
       userRepo.save(user);
        System.out.println("Details updated successfully");
        return user;
    }

    public void deleteUser(String email) {
        User user = userRepo.findByEmail(email);
        userRepo.delete(user);
        System.out.println("User deleted successfully");
    }
}
