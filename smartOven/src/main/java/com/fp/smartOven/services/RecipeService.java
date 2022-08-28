package com.fp.smartOven.services;

import com.fp.smartOven.beans.Recipe;
import com.fp.smartOven.beans.User;
import com.fp.smartOven.exceptions.CustomExceptions;
import com.fp.smartOven.repositories.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepo recipeRepo;

    public void createNewRecipe(Recipe recipe) throws CustomExceptions {
        if (recipeRepo.existByName(recipe.getName())){
            throw new CustomExceptions("This recipe name already exist");
        }
        recipeRepo.save(recipe);
        System.out.println("New recipe added");
    }

    public Recipe getRecipe(String name) throws CustomExceptions {
        if (!recipeRepo.existByName(name)){
            throw new CustomExceptions("No recipe found by this name");
        }
        return recipeRepo.findByName(name);
    }

    public Object getAllRecipes() {
        return recipeRepo.findAll();
    }

    public void updateRecipe(Recipe recipe) throws CustomExceptions {
        if (!recipeRepo.existByName(recipe.getName())){
            throw new CustomExceptions("No recipe found by this name");
        }
        recipeRepo.save(recipe);
    }

    public void deleteRecipe(String name) throws CustomExceptions {
        if(!recipeRepo.existByName(name)){
            throw new CustomExceptions("No recipe found by this name");
        }
        recipeRepo.deleteByName(name);
    }

    //todo: is this methods Reacts job?
//    public void startCooking(int id) {
//        // start thread
//    }
//
//    public void stopCooking() {
//        //kill thread
//    }
}
