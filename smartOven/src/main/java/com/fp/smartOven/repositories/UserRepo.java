package com.fp.smartOven.repositories;

import com.fp.smartOven.beans.Recipe;
import com.fp.smartOven.beans.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, String> {
    //todo: this query is not working
    boolean existByEmail(String email);

    User findByEmail(String email);

}
