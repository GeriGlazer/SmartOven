package com.fp.smartOven.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@Component
public class SprayNozzle {
    private final int OPEN_NOZZLE_IN_MILLISECONDS = 1000;
    public long interval;
    public int sprayQuantity;
    private boolean isOpen;

    public SprayNozzle(long interval, int sprayQuantity, boolean isOpen) {
        this.interval = interval;
        this.sprayQuantity = sprayQuantity;
        this.isOpen = isOpen();
    }

    public boolean isOpen() {
        this.isOpen = false;
        long stopSpray = System.currentTimeMillis() + OPEN_NOZZLE_IN_MILLISECONDS;
        do {
            isOpen = true;
        }
        while (stopSpray != System.currentTimeMillis());
        return isOpen;
    }
}
