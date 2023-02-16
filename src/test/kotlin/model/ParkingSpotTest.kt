package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ParkingSpotTest {
    @Test
    fun `it should allocate parking spot`() {
        val vehicle = Vehicle(VehicleType.CAR, "MH 12 AB 1234")
        val parkingSpot = ParkingSpot(1)

        parkingSpot.allocateSlot(vehicle)

        assertEquals(vehicle, parkingSpot.getParkedVehicle())
        assertFalse(parkingSpot.isEmpty())
    }

    @Test
    fun `it should vacate the parking spot`() {
        val vehicle = Vehicle(VehicleType.CAR, "MH 12 AB 1234")
        val parkingSpot = ParkingSpot(1)
        parkingSpot.allocateSlot(vehicle)

        parkingSpot.vacateSlot()

        assertEquals(null, parkingSpot.getParkedVehicle())
        assertTrue(parkingSpot.isEmpty())

    }
}