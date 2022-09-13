package com.fp.smartOven.thread;

import com.fp.smartOven.beans.*;
import com.fp.smartOven.repositories.ProbRepo;
import com.fp.smartOven.repositories.RecipeRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
@NoArgsConstructor
//@AllArgsConstructor
public class StartCooking extends Thread {
//    @Autowired
//    private ProbRepo probRepo;
//    @Autowired
//    private RecipeRepo recipeRepo;
//
//
//    private Recipe recipe;
//    private Light light = new Light(false);
//    private Blower blower = new Blower(false);
//    private SprayNozzle sprayNozzle = new SprayNozzle();
//    private Alarm alarm = new Alarm(false);
//    @Autowired
//    private Prob prob1 = probRepo.findById("1").get();
//    @Autowired
//    private Prob prob2 = probRepo.findById("2").get();
//    @Autowired
//    private Prob prob3 = probRepo.findById("3").get();
//    @Autowired
//    private Prob prob4 = probRepo.findById("4").get();
//    @Autowired
//    private Prob prob5 = probRepo.findById("11").get();
//    @Autowired
//    private Prob prob6 = probRepo.findById("12").get();
//    //private volatile Thread cooking;
//    double startTime = System.currentTimeMillis();
//
//    @SneakyThrows
//    @Override
//    public void run() {
//        //todo: check thread is ok: when to stop.
//        //Thread myThread = Thread.currentThread();
//        double endTime = startTime + (recipe.getCookTime() * 1000);
//        while (endTime != startTime) {
//            //in oven control panel light should turn on
//            light.setOn(true);
//            //in oven control panel blower should start working.
//            // todo: definition of way of work programmed in PI? (isOn/isOf depends on ambient temp)
//            blower.setOn(true);
//
//            prob1.setFinalTemperature(recipe.getInternalMeatTemperature());
//            prob2.setFinalTemperature(recipe.getInternalMeatTemperature());
//            prob3.setFinalTemperature(recipe.getInternalMeatTemperature());
//            prob4.setFinalTemperature(recipe.getInternalMeatTemperature());
//            //how to get currentTemperature to check when final temperature is reached.
//            //prob1.setCurrentTemperature(prob1.getCurrentTemperature());
//            if (prob1.getCurrentTemperature() == prob1.finalTemperature &&
//                    prob2.getCurrentTemperature() == prob2.finalTemperature &&
//                    prob3.getCurrentTemperature() == prob3.finalTemperature &&
//                    prob4.getCurrentTemperature() == prob4.finalTemperature) {
//                alarm.setOn(true);
//            }
//            prob5.setFinalTemperature(recipe.getInternalMeatTemperature());
//            prob6.setFinalTemperature(recipe.getInternalMeatTemperature());
//
//            if (prob5.getCurrentTemperature() == prob5.finalTemperature &&
//                    prob6.getCurrentTemperature() == prob6.finalTemperature) {
//                alarm.setOn(true);
//            }
//            sprayNozzle.setSprayQuantity((int) ((recipe.getCookTime() * 1000) / recipe.getSprayNozzleInterval()));
//            int sprayCounter = 0;
//            //every time interval repeat itself the nozzle will spray marinade until counter of times gets to the spray quantity
//            //do this every interval
//            do {
//                sprayNozzle.isOpen();
//                sprayCounter++;
//                wait(sprayNozzle.getInterval());
//            } while (sprayCounter != sprayNozzle.getSprayQuantity());
//        }
//        //endTask();
//    }
//
//    public void endTask() {
//        //cooking = null;
//    }


}
