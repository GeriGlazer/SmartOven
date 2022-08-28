package com.fp.smartOven.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("recipe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe implements Serializable {
    private String id;
    private String name;
    private double cookTime;
    private int sprayNozzleInterval;
    private double internalMeatTemperature;
    private double ambientTemperature;



    //set recipe

    public Recipe(String name, double cookTime, int sprayNozzleInterval, double internalMeatTemperature, double ambientTemperature) {
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
