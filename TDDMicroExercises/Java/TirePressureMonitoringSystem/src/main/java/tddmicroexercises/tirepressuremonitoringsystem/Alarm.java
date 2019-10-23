package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {

    private static final PressureThreshold DEFAULT_THRESHOLD = new PressureThreshold(17, 21);
    private static final PressureSensor DEFAULT_PRESSURE_SENSOR = new TirePressureSensor();

    private boolean alarmOn = false;

    private PressureSensor pressureSensor;
    private PressureThreshold pressureThreshold;

    public Alarm() {
        this(DEFAULT_PRESSURE_SENSOR, DEFAULT_THRESHOLD);
    }

    public Alarm(PressureSensor pressureSensor, PressureThreshold pressureThreshold) {
        this.pressureSensor = pressureSensor;
        this.pressureThreshold = pressureThreshold;
    }

    public void check() {
        alarmOn = pressureThreshold.isOutOfBounds(pressureSensor.popNextPressurePsiValue());
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}
