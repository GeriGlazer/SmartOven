package com.fp.smartOven.repositories;

import com.fp.smartOven.beans.Recipe;
import com.fp.smartOven.beans.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, String> {

    User findByEmail(String email);
    boolean existByEmail(String email);
}
