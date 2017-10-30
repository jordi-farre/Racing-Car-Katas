package tddmicroexercises.tirepressuremonitoringsystem

class Alarm(val sensor: Sensor) {

    val  LowPressureThreshold : Double = 17
    val HighPressureThreshold : Double = 21
    var alarmOn = false

    def check() {
        val psiPressureValue = sensor.popNextPressurePsiValue()
        alarmOn = psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue
    }

    def isAlarmOn() = alarmOn

}