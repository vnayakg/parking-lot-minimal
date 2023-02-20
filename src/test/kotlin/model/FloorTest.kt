package model

import exception.ParkingLotCapacityExceededException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import repository.ParkingFloorList

class FloorTest {

    private fun getParkingFloorList(floorCount: Int): ArrayList<Floor> {
        val floorList = arrayListOf<Floor>()

        for (floorNumber in 1..floorCount) {
            val availableSpotList = getParkingSpotList(mapOf(VehicleType.CAR to 50), floorNumber)
            val floor = Floor(floorNumber, availableSpotList)

            floorList.add(floor)
        }
        return floorList
    }

    private fun getParkingSpotList(
        vehicleSpotCapacity: Map<VehicleType, Int>,
        floorNumber: Int
    ): ArrayList<ParkingSpot> {
        val spots = arrayListOf<ParkingSpot>()

        for (entry in vehicleSpotCapacity.entries.iterator()) {
            for (i in 1..entry.value) {
                spots.add(ParkingSpot(i, entry.key, floorNumber))
            }
        }
        return spots
    }

    @Test
    fun `should be able to find next available spot`() {
        val floorList = getParkingFloorList(3)
        val parkingFloorList = ParkingFloorList(floorList)

        val nextAvailableSpot = parkingFloorList.getNextAvailableSpot(VehicleType.CAR)

        assertEquals(1, nextAvailableSpot.getSpotNumber())
    }

    @Test
    fun `should throw exception if spot is not available`() {
        val floorList = getParkingFloorList(0)
        val parkingFloorList = ParkingFloorList(floorList)

        assertThrows(
            ParkingLotCapacityExceededException::class.java
        ) {
            parkingFloorList.getNextAvailableSpot(VehicleType.CAR)

        }
    }
}