package com.fp.smartOven.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SprayNozzle {
    private final int OPENING_TIME=10;
    public int interval;
}
