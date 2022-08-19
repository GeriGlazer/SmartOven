package com.fp.smartOven.services;

import com.fp.smartOven.beans.Recipe;
import com.fp.smartOven.beans.User;
import com.fp.smartOven.repositories.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepo recipeRepo;

    public void createNewRecipe() {

    }

    public Recipe getRecipe() {
        return null;
    }

    public List<Recipe> getAllRecipes() {
        return null;
    }

    public Recipe updateRecipe(Recipe recipe) {
        return null;
    }

    public void deleteRecipe(int id) {

    }

    public void startCooking(int id) {
        // start thread
    }
    
    public void stopCooking() {
        //kill thread
    }
}
