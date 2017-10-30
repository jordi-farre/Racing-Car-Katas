package tddmicroexercises.tirepressuremonitoringsystem

import org.scalatest._
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._

class TestAlarm extends FlatSpec with Matchers with MockitoSugar {

  def fixture =
    new {
      val sensor: Sensor = mock[Sensor]
      val alarm = new ExtendedAlarm(sensor);
    }

  it should "raise alarm on low pressure" in {
    val f = fixture
    when(f.sensor.popNextPressurePsiValue()).thenReturn(16.99)

    f.alarm.check()

    f.alarm.isAlarmOn() shouldBe true
    verify(f.sensor).popNextPressurePsiValue()
  }

  it should "raise alarm on high pressure" in {
    val f = fixture
    when(f.sensor.popNextPressurePsiValue()).thenReturn(21.01)

    f.alarm.check()

    f.alarm.isAlarmOn() shouldBe true
    verify(f.sensor).popNextPressurePsiValue()
  }

  it should "not raise alarm on normal pressure" in {
    val f = fixture
    when(f.sensor.popNextPressurePsiValue()).thenReturn(21.00)

    f.alarm.check()

    f.alarm.isAlarmOn() shouldBe false
    verify(f.sensor).popNextPressurePsiValue()
  }

}