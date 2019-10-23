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
        Alarm alarm = new Alarm(() -> LOW_PRESSURE_BOUNDARY - 1, threshold);

        alarm.check();
        assertThat(alarm.isAlarmOn()).isTrue();
    }

    @Test
    public void whenPressureTooHigh_alarmIsOn() throws Exception {
        Alarm alarm = new Alarm(() -> HIGH_PRESSURE_BOUNDARY + 1, threshold);

        alarm.check();
        assertThat(alarm.isAlarmOn()).isTrue();
    }

    @Test
    public void whenPressureIsLowerLimit_alarmIsOff() throws Exception {
        Alarm alarm = new Alarm(() -> LOW_PRESSURE_BOUNDARY, threshold);

        alarm.check();
        assertThat(alarm.isAlarmOn()).isFalse();
    }

    @Test
    public void whenPressureIsUpperLimit_alarmIsOff() throws Exception {
        Alarm alarm = new Alarm(() -> HIGH_PRESSURE_BOUNDARY, threshold);

        alarm.check();
        assertThat(alarm.isAlarmOn()).isFalse();
    }

    @Test
    public void whenPressureIsInBetween_alarmIsOff() throws Exception {
        Alarm alarm = new Alarm(() -> HIGH_PRESSURE_BOUNDARY - 1, threshold);

        alarm.check();
        assertThat(alarm.isAlarmOn()).isFalse();
    }

}
