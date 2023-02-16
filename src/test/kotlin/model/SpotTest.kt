package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SpotTest {
    @Test
    fun `it should allocate parking spot`() {
        val vehicle = Vehicle(VehicleType.CAR, "MH 12 AB 1234")
        val spot = Spot(1)

        spot.allocateSlot(vehicle)

        assertEquals(vehicle, spot.getParkedVehicle())
        assertFalse(spot.isEmpty())
    }

    @Test
    fun `it should vacate the parking spot`() {
        val vehicle = Vehicle(VehicleType.CAR, "MH 12 AB 1234")
        val spot = Spot(1)
        spot.allocateSlot(vehicle)

        spot.vacateSlot()

        assertEquals(null, spot.getParkedVehicle())
        assertTrue(spot.isEmpty())

    }
}