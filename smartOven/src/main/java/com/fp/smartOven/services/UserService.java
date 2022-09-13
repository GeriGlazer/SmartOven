package com.fp.smartOven.services;

import com.fp.smartOven.beans.User;
import com.fp.smartOven.exceptions.CustomExceptions;
import com.fp.smartOven.repositories.UserRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class UserService {

    @Autowired
    private UserRepo userRepo;
    private String userEmail = "";

    public boolean login(User user) throws CustomExceptions {
//        boolean registered = userRepo.existByEmail(user.getEmail());
//        if(!registered){
//            throw new CustomExceptions("Please create new account");
//        }
        userEmail = user.getEmail();
        System.out.println("Logged in");
        return true;
    }

    public void createNewUser(User user) throws CustomExceptions {
        //if(userRepo.findByEmail(user.getEmail()).isEmpty()){
        userRepo.save(user);
        System.out.println("New user registered successfully");
//        }else {
//            throw new CustomExceptions("Email already exist");
//        }
    }

    public User updateDetails(User user) {
        userRepo.save(user);
        System.out.println("Details updated successfully");
        return user;
    }

    public void deleteUser(String email) throws CustomExceptions {
//        if(!userRepo.existByEmail(email)){
//            throw new CustomExceptions("User not founded");
//        }
        User user = userRepo.findByEmail(email);
        userRepo.delete(user);
        System.out.println("User deleted successfully");
    }

    public User getUserDetails() throws CustomExceptions {
        User user = userRepo.findByEmail(userEmail);
        if (userEmail.isEmpty()) {
            throw new CustomExceptions("User not found");
        }
        return user;
    }
}
