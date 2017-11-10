package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {

    private final double LOW_PRESSURE_THRESHOLD = 17;
    private final double HIGH_PRESSURE_THRESHOLD = 21;

    private boolean alarmOn = false;
    private Sensor sensor;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
    }

    public Alarm() {
        this(new Sensor());
    }

    public void check() {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue) {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}
