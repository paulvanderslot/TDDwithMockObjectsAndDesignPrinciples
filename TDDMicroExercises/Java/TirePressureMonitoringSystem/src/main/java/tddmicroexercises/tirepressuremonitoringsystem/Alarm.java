package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private PressureSensor pressureSensor;
    private PressureThreshold pressureThreshold;

    /**
     * Set default implementations
     */
    public Alarm() {
        this(new RandomPressureSensor(), new PressureThreshold(17, 21));
    }

    public Alarm(PressureSensor pressureSensor, PressureThreshold pressureThreshold) {
        this.pressureSensor = pressureSensor;
        this.pressureThreshold = pressureThreshold;
    }

    public boolean isAlarmOn() {
        double currentPressure = pressureSensor.popNextPressurePsiValue();
        return pressureThreshold.isOutOfBounds(currentPressure);
    }
}
