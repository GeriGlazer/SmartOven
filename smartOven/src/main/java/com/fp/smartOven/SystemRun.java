package com.fp.smartOven;

import com.fp.smartOven.beans.*;
import com.fp.smartOven.repositories.ProbRepo;
import com.fp.smartOven.repositories.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SystemRun implements CommandLineRunner {

    @Autowired
    ProbRepo probRepo;
    @Autowired
    RecipeRepo recipeRepo;

    @Override
    public void run(String... args) throws Exception {
        List<Prob> probList = (List<Prob>) probRepo.findAll();
        if (probList.isEmpty()) {
            Prob prob1 = new Prob("1", "meatProb1", 60, 100, 0, 0);
            Prob prob2 = new Prob("2", "meatProb2", 60, 100, 0, 0);
            Prob prob3 = new Prob("3", "meatProb3", 60, 100, 0, 0);
            Prob prob4 = new Prob("4", "meatProb4", 60, 100, 0, 0);
            probRepo.saveAll(List.of(prob1, prob2, prob3, prob4));
            System.out.println("Meat probs saved");

            Prob prob5 = new Prob("11", "ambientProb1", 25, 180, 0, 0);
            Prob prob6 = new Prob("12", "ambientProb2", 25, 180, 0, 0);
            probRepo.saveAll(List.of(prob5, prob6));
            System.out.println("ambient probs saved");

        }
        //programed recipes
        Recipe pastrami = new Recipe("Pastrami", 6, 1, 65, 150);
        Recipe smokedHolidayHam = new Recipe("Smoked Holiday Ham", 8, 3,  68, 93);
        Recipe smokedBacon = new Recipe("Smoked Bacon", 3, 1, 65, 120);
        Recipe smokedJalapeños = new Recipe("Smoked Jalapeños", 5, 0, 32, 37);
        Recipe turkeyBreast = new Recipe("Turkey Breast", 4, 3, 71, 93);
        Recipe smokedSalmon = new Recipe("Smoked Salmon", 12, 0, 12, 25);

        recipeRepo.saveAll(List.of(pastrami, smokedHolidayHam, smokedBacon, smokedJalapeños, turkeyBreast, smokedSalmon));
    }
}
