package service

import exception.InvalidTimeDurationException
import model.VehicleType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FeeCalculatorTest {
    @Test
    fun `it should calculate fee`() {
        val feeCalculator = FeeCalculator()

        val actualFee = feeCalculator.calculateFee(2.5F, VehicleType.CAR)

        assertEquals(25F, actualFee)
    }

    @Test
    fun `it should give throw exception for non-positive park duration`() {
        val feeCalculator = FeeCalculator()

        assertThrows(
            InvalidTimeDurationException::class.java
        ) {
            feeCalculator.calculateFee(-2.5F, VehicleType.CAR)
        }
    }
}