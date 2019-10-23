package tddmicroexercises.tirepressuremonitoringsystem.somedependencies;

import tddmicroexercises.tirepressuremonitoringsystem.RandomPressureSensor;

public class ASensorClient
{
    // A class with the only goal of simulating a dependency on Sensor
    // that has impact on the refactoring.

    public ASensorClient()
    {
        RandomPressureSensor sensor = new RandomPressureSensor();

        double value = sensor.popNextPressurePsiValue();
        value = sensor.popNextPressurePsiValue();
        value = sensor.popNextPressurePsiValue();
        value = sensor.popNextPressurePsiValue();
    }
}
