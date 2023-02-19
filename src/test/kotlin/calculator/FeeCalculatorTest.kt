package calculator

import exception.InvalidTimeDurationException
import model.VehicleType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

class FeeCalculatorTest {
    @Test
    fun `it should calculate fee`() {
        val entryDateTime = Date()
        val milliSecondsInHour = 3600000
        val exitDateTime = Date(entryDateTime.time + milliSecondsInHour)
        val feeCalculator = FeeCalculator()

        val actualFee = feeCalculator.calculateFee(entryDateTime, exitDateTime, VehicleType.CAR)

        assertEquals(10F, actualFee)
    }

    @Test
    fun `it should give throw exception for non-positive park duration`() {
        val entryDateTime = Date()
        val milliSecondsInHour = 3600000
        val exitDateTime = Date(entryDateTime.time + milliSecondsInHour)
        val feeCalculator = FeeCalculator()

        assertThrows(
            InvalidTimeDurationException::class.java
        ) {
            feeCalculator.calculateFee(exitDateTime, entryDateTime, VehicleType.CAR)
        }
    }

    @Test
    fun `should calculate fee for fraction hour time`() {
        val entryDateTime = Date()
        val milliSecondsInHalfHour = 5400000
        val exitDateTime = Date(entryDateTime.time + milliSecondsInHalfHour)
        val feeCalculator = FeeCalculator()

        val actualFee = feeCalculator.calculateFee(entryDateTime, exitDateTime, VehicleType.CAR)

        assertEquals(15.0F, actualFee)
    }
}