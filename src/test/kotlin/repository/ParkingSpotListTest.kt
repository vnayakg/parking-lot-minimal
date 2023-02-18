package repository

import exception.ParkingLotCapacityExceededException
import model.ParkingSpot
import model.VehicleType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class ParkingSpotListTest {
    private fun getParkingSpotList(vehicleSpotCapacity: Map<VehicleType, Int>): List<ParkingSpot> {
        val spots = arrayListOf<ParkingSpot>()

        for (entry in vehicleSpotCapacity.entries.iterator()) {
            for (i in 1..entry.value) {
                spots.add(ParkingSpot(i))
            }
        }
        return spots
    }

    @Test
    fun `should be able to find next available spot`() {
        val vehicleSpotCapacity = mapOf(VehicleType.CAR to 100)
        val spotList = getParkingSpotList(vehicleSpotCapacity)
        val parkingSpotList = ParkingSpotList(spotList)

        val nextAvailableSpot = parkingSpotList.getNextAvailableSpot(VehicleType.CAR)

        assertEquals(1, nextAvailableSpot.getSpotNumber())
    }

    @Test
    fun `should throw exception if spot is not available`() {
        val vehicleSpotCapacity = mapOf(VehicleType.CAR to 0)
        val spotList = getParkingSpotList(vehicleSpotCapacity)
        val parkingSpotList = ParkingSpotList(spotList)

        assertThrows(
            ParkingLotCapacityExceededException::class.java
        ) {
            parkingSpotList.getNextAvailableSpot(VehicleType.CAR)

        }
    }
}