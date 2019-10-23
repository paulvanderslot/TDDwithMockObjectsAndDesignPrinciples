package tddmicroexercises.tirepressuremonitoringsystem.somedependencies;

import tddmicroexercises.tirepressuremonitoringsystem.TirePressureSensor;

public class ASensorClient
{
    // A class with the only goal of simulating a dependency on Sensor
    // that has impact on the refactoring.

    public ASensorClient()
    {
        TirePressureSensor sensor = new TirePressureSensor();

        double value = sensor.popNextPressurePsiValue();
        value = sensor.popNextPressurePsiValue();
        value = sensor.popNextPressurePsiValue();
        value = sensor.popNextPressurePsiValue();
    }
}
