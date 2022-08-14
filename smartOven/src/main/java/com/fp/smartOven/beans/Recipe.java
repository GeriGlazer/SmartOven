package com.fp.smartOven.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe implements Serializable {
    private int id;
    private   String name;
    private double cookTime;
    private int sprayNozzleInterval;
    private double internalMeatTemperature;
    private double ambientTemperature;



    //set recipe

    public Recipe(String name, double cookTime, int sprayNozzleInterval, double internalMeatTemperature, double ambientTemperature) {
        this.id = id++;
        this.name = name;
        setCookTime(cookTime);
        setSprayNozzleInterval(sprayNozzleInterval);
        this.internalMeatTemperature = internalMeatTemperature;
        this.ambientTemperature = ambientTemperature;
    }

    //set cook Time
    private void setCookTime (double cookTime){
        cookTime=cookTime*60*60;
        this.cookTime=cookTime;
    }
    //set spray Nozzle Interval
    private void setSprayNozzleInterval(int sprayNozzleInterval) {
        sprayNozzleInterval=sprayNozzleInterval*60*60;
        this.sprayNozzleInterval = sprayNozzleInterval;
    }

}
