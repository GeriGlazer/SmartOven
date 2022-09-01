package com.fp.smartOven.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@RedisHash("recipe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe implements Serializable {
    @Id
    @JsonIgnore
    private String id;
    @Indexed
    private String name;
    private double cookTime;
    private long sprayNozzleInterval;
    private double internalMeatTemperature;
    private double ambientTemperature;



    //set recipe

    public Recipe(String name, double cookTime, long sprayNozzleInterval, double internalMeatTemperature, double ambientTemperature) {
        this.name = name;
        setCookTime(cookTime);
        setSprayNozzleInterval(sprayNozzleInterval);
        this.internalMeatTemperature = internalMeatTemperature;
        this.ambientTemperature = ambientTemperature;
    }

    //set cook Time in seconds
    private void setCookTime (double cookTime){
        cookTime=cookTime*60*60;
        this.cookTime=cookTime;
    }
    //set spray Nozzle Interval in milliseconds
    private void setSprayNozzleInterval(long sprayNozzleInterval) {
        sprayNozzleInterval=sprayNozzleInterval*60000;
        this.sprayNozzleInterval = sprayNozzleInterval;
    }

}
