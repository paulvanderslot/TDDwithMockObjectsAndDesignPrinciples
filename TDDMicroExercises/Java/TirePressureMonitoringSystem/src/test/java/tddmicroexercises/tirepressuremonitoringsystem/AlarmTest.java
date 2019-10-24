package tddmicroexercises.tirepressuremonitoringsystem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlarmTest {

    private static final double LOW_PRESSURE_BOUNDARY = 10;
    private static final double HIGH_PRESSURE_BOUNDARY = 15;
    private PressureThreshold threshold;

    @BeforeEach
    void setup() {
        threshold = new PressureThreshold(LOW_PRESSURE_BOUNDARY, HIGH_PRESSURE_BOUNDARY);
    }

    @Test
    public void whenPressureTooLow_alarmIsOn() throws Exception {
        PressureSensor pressureTooLow = () -> LOW_PRESSURE_BOUNDARY - 1;
        Alarm alarm = new Alarm(pressureTooLow, threshold);

        assertThat(alarm.isAlarmOn()).isTrue();
    }

    @Test
    public void whenPressureTooHigh_alarmIsOn() throws Exception {
        PressureSensor pressureTooHigh = () -> HIGH_PRESSURE_BOUNDARY + 1;
        Alarm alarm = new Alarm(pressureTooHigh, threshold);

        assertThat(alarm.isAlarmOn()).isTrue();
    }

    @Test
    public void whenPressureIsLowerLimit_alarmIsOff() throws Exception {
        PressureSensor pressureLowerLimit = () -> LOW_PRESSURE_BOUNDARY;
        Alarm alarm = new Alarm(pressureLowerLimit, threshold);

        assertThat(alarm.isAlarmOn()).isFalse();
    }

    @Test
    public void whenPressureIsUpperLimit_alarmIsOff() throws Exception {
        PressureSensor pressureUpperLimit = () -> HIGH_PRESSURE_BOUNDARY;
        Alarm alarm = new Alarm(pressureUpperLimit, threshold);

        assertThat(alarm.isAlarmOn()).isFalse();
    }

    @Test
    public void whenPressureIsInBetween_alarmIsOff() throws Exception {
        PressureSensor pressureOk = () -> HIGH_PRESSURE_BOUNDARY - 1;
        Alarm alarm = new Alarm(pressureOk, threshold);

        assertThat(alarm.isAlarmOn()).isFalse();
    }

    /**
     * Behaviour is changed! Or is the alarm not supposed to get off?
     */
    @Test
    public void whenPressureVariates_alarmCanGetOff() throws Exception {
        Alarm alarm = new Alarm(sensorWithFirstInvalidThenValidPressure(), threshold);

        assertThat(alarm.isAlarmOn()).isTrue();
        assertThat(alarm.isAlarmOn()).isFalse();
    }

    private PressureSensor sensorWithFirstInvalidThenValidPressure() {
        return new PressureSensor() {
            private static final double PRESSURE_OK = HIGH_PRESSURE_BOUNDARY - 1;
            private static final double PRESSURE_NOT_OK = HIGH_PRESSURE_BOUNDARY + 1;

            boolean hasBeenCalled = false;

            @Override
            public double popNextPressurePsiValue() {
                if (hasBeenCalled) {
                    return PRESSURE_OK;
                }

                hasBeenCalled = true;
                return PRESSURE_NOT_OK;
            }
        };
    }

}
