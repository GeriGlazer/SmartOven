package com.fp.smartOven.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@RedisHash("prob")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prob implements Serializable {
    @Id
    @Indexed
    private String id;
    @Indexed
    private String name;
    private double minTemperature;
    private double maxTemperature;
    private double currentTemperature;
    private double finalTemperature;

}
