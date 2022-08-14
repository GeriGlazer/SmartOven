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
//        Prob prob1 = new Prob("1", "meatProb1", 60, 100, 0);
//        Prob prob2 = new Prob("2", "meatProb2", 60, 100, 0);
//        Prob prob3 = new Prob("3", "meatProb3", 60, 100, 0);
//        Prob prob4 = new Prob("4", "meatProb4", 60, 100, 0);
//        probRepo.saveAll(List.of(prob1, prob2, prob3, prob4));
//        System.out.println("Meat probs saved");

        Prob prob5 = new Prob("11", "ambientProb1", 25, 180, 0);
        Prob prob6 = new Prob("12", "ambientProb2", 25, 180, 0);
        probRepo.saveAll(List.of(prob5, prob6));
        System.out.println("ambient probs saved");

        SprayNozzle sprayNozzle = new SprayNozzle();
        System.out.println("Nozzle initialized");

        Alarm alarm = new Alarm(false);
        System.out.println("Alarm initialized, off");

        Blower blower = new Blower(false);
        System.out.println("Blower initialized, off");

        Light light = new Light(false);
        System.out.println("Light initialized, off");

        Recipe pastrami = new Recipe("Pastrami", 6, 1, 65, 150);



    }
}