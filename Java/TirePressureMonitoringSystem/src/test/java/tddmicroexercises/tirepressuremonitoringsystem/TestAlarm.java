package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TestAlarm {

    private Sensor mockedSensor;
    private Alarm alarm;

    @BeforeEach
    public void initialize() {
        mockedSensor = mock(Sensor.class);
        alarm = new Alarm(mockedSensor);
    }

    @ParameterizedTest
    @CsvSource({ "16.9, true",
            "21.1, true",
            "17, false",
            "21, false",
            "18, false",
            "19.2, false" })
    public void alarm_raises_when_pressure_outside_threshold(double pressure, boolean alarmOn) {
        when(mockedSensor.popNextPressurePsiValue()).thenReturn(pressure);

        alarm.check();

        assertEquals(alarmOn, alarm.isAlarmOn());
    }
}
