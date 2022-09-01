package com.fp.smartOven.controllers;

import com.fp.smartOven.beans.Recipe;
import com.fp.smartOven.exceptions.CustomExceptions;
import com.fp.smartOven.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/smartOven")
public class RecipeControllers {
    @Autowired
    private final RecipeService recipeService;

    @PostMapping("/newRecipe")
    public ResponseEntity<?> newRecipe (@RequestBody Recipe recipe) throws CustomExceptions {
        recipeService.createNewRecipe(recipe);
        return ResponseEntity.ok()
                .body(recipe);
    }

    @GetMapping("/getRecipe/{name}")
    public ResponseEntity<?> getRecipe (@PathVariable String name) throws CustomExceptions {
        return ResponseEntity.ok()
                .body(recipeService.getRecipe(name));
    }

    @GetMapping("/getAllRecipes")
    public ResponseEntity<?> getAllRecipes ()  {
        return ResponseEntity.ok()
                .body(recipeService.getAllRecipes());
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Recipe recipe) throws CustomExceptions {
        recipeService.updateRecipe(recipe);
        return ResponseEntity.ok()
               .body("Recipe deleted");
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<?> deleteRecipe (@PathVariable String name) throws CustomExceptions {
        recipeService.deleteRecipe(name);
        return ResponseEntity.ok()
                .body("Recipe deleted");
    }

    //todo: I want to return the thread process, is it possible?
    @PutMapping("/inProcess")
    public ResponseEntity<?> recipeInProcess (@RequestBody Recipe recipe) throws CustomExceptions {
        recipeService.startCooking(recipe);
        return ResponseEntity.ok()
                .body("Turning oven on and start cooking");
    }

    @PutMapping("/stopped")
    public ResponseEntity<?> stopOven (){
        recipeService.stopCooking();
        return ResponseEntity.ok()
                .body("Cooking stopped");
    }

}
