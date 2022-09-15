package com.fp.smartOven.services;

import com.fp.smartOven.beans.Recipe;
import com.fp.smartOven.exceptions.CustomExceptions;
import com.fp.smartOven.repositories.RecipeRepo;
import com.fp.smartOven.thread.StartCooking;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class RecipeService {

    @Autowired
    private RecipeRepo recipeRepo;
    private StartCooking start;

    public void createNewRecipe(Recipe recipe) throws CustomExceptions {
//        if (recipeRepo.existByName(recipe.getName())) {
//            throw new CustomExceptions("This recipe name already exist");
//        }
        recipe.setName(recipe.getName() + "-myRecipe");
        recipeRepo.save(recipe);
        System.out.println("New recipe added");
    }

    public Recipe getRecipe(String name) throws CustomExceptions {
//        if (!recipeRepo.existByName(name)) {
//            throw new CustomExceptions("No recipe found by this name");
//        }
        return recipeRepo.findByName(name);
    }

    public Object getAllRecipes() {
        return recipeRepo.findAll();
    }

    public void updateRecipe(Recipe recipe) throws CustomExceptions {
//        if (!recipeRepo.existByName(recipe.getName())) {
//            throw new CustomExceptions("No recipe found by this name");
//        }
        recipeRepo.save(recipe);
    }

    public void deleteRecipe(String name) throws CustomExceptions {
//        if (!recipeRepo.existByName(name)) {
//            throw new CustomExceptions("No recipe found by this name");
//        }
        recipeRepo.deleteByName(name);
    }

    public void startCooking(Recipe recipe) throws CustomExceptions {
        if (!recipeRepo.existByName(recipe.getName())) {
            throw new CustomExceptions("No recipe found by this name");
        }
        start = new StartCooking(recipe);
        start.start();
    }

    public void stopCooking() {
        start.isRunning();
    }
}
