package com.fp.smartOven.repositories;

import com.fp.smartOven.beans.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepo extends CrudRepository<Recipe, String> {

    boolean existByName(String name);

    Recipe findByName(String name);

    Recipe getByName(String name);

    Recipe deleteByName(String name);
}
