package com.fp.smartOven.thread;

import com.fp.smartOven.beans.*;
import com.fp.smartOven.repositories.ProbRepo;
import com.fp.smartOven.repositories.RecipeRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
@EnableAsync
public class StartCooking extends Thread {
    @Autowired
    private ProbRepo probRepo;
    @Autowired
    private RecipeRepo recipeRepo;
    private boolean isRunning;
    private Recipe recipe;
    private Light light;
    private Blower blower;
    private SprayNozzle sprayNozzle;
    private Alarm alarm;
    //private List<Prob> probList = new ArrayList<>();
    private Prob prob1;
    private Prob prob2;
    private Prob prob3;
    private Prob prob4;
    private Prob prob5;
    private Prob prob6;

    public StartCooking(Recipe recipe) {
        this.isRunning = true;
        this.light = new Light(false);
        this.recipe = recipeRepo.findByName(recipe.getName());
        this.blower = new Blower(false);
        this.sprayNozzle = new SprayNozzle();
        this.alarm = new Alarm(false);
        this.prob1=probRepo.findById("1").get();
        this.prob2 = probRepo.findById("2").get();
        this.prob3 = probRepo.findById("3").get();
        this.prob4 = probRepo.findById("4").get();
        this.prob5 = probRepo.findById("11").get();
        this.prob6 = probRepo.findById("12").get();
    }


    double startTime = System.currentTimeMillis();

    @Override
    public void run() {
        double endTime = startTime + (recipe.getCookTime() * 1000);
        while (isRunning) {
            while (endTime != startTime) {
                //in oven control panel light should turn on
                light.setOn(true);
                //in oven control panel blower should start working.
                blower.setOn(true);
                prob1.setFinalTemperature(recipe.getInternalMeatTemperature());
                prob2.setFinalTemperature(recipe.getInternalMeatTemperature());
                prob3.setFinalTemperature(recipe.getInternalMeatTemperature());
                prob4.setFinalTemperature(recipe.getInternalMeatTemperature());
                //how to get currentTemperature to check when final temperature is reached.
                //prob1.setCurrentTemperature(prob1.getCurrentTemperature());
                if (prob1.getCurrentTemperature() == prob1.getFinalTemperature() &&
                        prob2.getCurrentTemperature() == prob2.getFinalTemperature() &&
                        prob3.getCurrentTemperature() == prob3.getFinalTemperature() &&
                        prob4.getCurrentTemperature() == prob4.getFinalTemperature()) {
                    alarm.setOn(true);
                    blower.setOn(false);
                }
                prob5.setFinalTemperature(recipe.getInternalMeatTemperature());
                prob6.setFinalTemperature(recipe.getInternalMeatTemperature());

                if (prob5.getCurrentTemperature() == prob5.getFinalTemperature() &&
                        prob6.getCurrentTemperature() == prob6.getFinalTemperature()) {
                    alarm.setOn(true);
                    blower.setOn(false);
                }
                sprayNozzle.setSprayQuantity((int) ((recipe.getCookTime() * 1000) / recipe.getSprayNozzleInterval()));
                int sprayCounter = 0;
                //every time interval repeat itself the nozzle will spray marinade until counter of times gets to the spray quantity
                //do this every interval
                do {
                    sprayNozzle.isOpen();
                    sprayCounter++;
                    try {
                        wait(sprayNozzle.getInterval());
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                        ;
                    }
                } while (sprayCounter != sprayNozzle.getSprayQuantity());
            }
        }
    }

    public void isRunning() {
        this.isRunning = false;
    }

}
