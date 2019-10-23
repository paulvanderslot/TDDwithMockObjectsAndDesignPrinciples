package tddmicroexercises.tirepressuremonitoringsystem;

import java.util.Random;

public class RandomPressureSensor implements PressureSensor {
    private static final Random RANDOM = new Random();
    private static final double OFFSET = 16;
    private static final int RANGE = 6;

    @Override
    public double popNextPressurePsiValue() {
        return OFFSET + (RANGE * RANDOM.nextDouble() * RANDOM.nextDouble());
    }

}
