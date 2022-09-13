package com.fp.smartOven.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.*;

import java.io.Serializable;
import java.lang.annotation.Documented;

@RedisHash("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @Indexed
    @JsonIgnore
    private String id;
    private String name;
    @Indexed
    private String email;
    private String password;
}
