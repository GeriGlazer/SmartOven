package com.fp.smartOven.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("prob")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prob implements Serializable {
    public String id;
    public String name;
    public double minTemperature;
    public double maxTemperature;
    public double currentTemperature;

}
