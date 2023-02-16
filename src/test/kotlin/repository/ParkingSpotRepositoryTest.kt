package repository

import exception.ParkingLotCapacityExceededException
import model.VehicleType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ParkingSpotRepositoryTest {

    @Test
    fun `should be able to find next available spot`() {
        val vehicleSpotCapacity = mapOf(VehicleType.CAR to 100)
        val parkingSpotRepository = ParkingSpotRepository(vehicleSpotCapacity)

        val nextAvailableSpot = parkingSpotRepository.getNextAvailableSpot(VehicleType.CAR)

        assertEquals(1, nextAvailableSpot.getSpotNumber())
    }

    @Test
    fun `should throw exception if spot is not available`() {
        val vehicleSpotCapacity = mapOf(VehicleType.CAR to 0)
        val parkingSpotRepository = ParkingSpotRepository(vehicleSpotCapacity)

        assertThrows(
            ParkingLotCapacityExceededException::class.java
        ) {
            parkingSpotRepository.getNextAvailableSpot(VehicleType.CAR)

        }
    }
}