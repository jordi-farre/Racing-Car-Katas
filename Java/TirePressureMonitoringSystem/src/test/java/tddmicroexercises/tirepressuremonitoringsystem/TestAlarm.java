package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestAlarm {

    private Sensor sensor;
    private Alarm alarm;

    @BeforeEach
    public void initialize() {
        sensor = mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @ParameterizedTest
    @CsvSource({ "16.9, true",
            "21.1, true",
            "17, false",
            "21, false",
            "18, false",
            "19.2, false" })
    public void alarm_raises_when_pressure_outside_threshold(double pressure, boolean alarmOn) {
        when(sensor.popNextPressurePsiValue()).thenReturn(pressure);

        alarm.check();

        assertEquals(alarmOn, alarm.isAlarmOn());
    }

}
