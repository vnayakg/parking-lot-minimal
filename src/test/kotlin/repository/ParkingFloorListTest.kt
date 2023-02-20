package repository

import exception.ParkingLotCapacityExceededException
import model.Floor
import model.ParkingSpot
import model.VehicleType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class ParkingFloorListTest {
    private val vehicleSpotCapacity = mapOf(VehicleType.CAR to 100)

    private fun getParkingFloorList(floorCount: Int): ArrayList<Floor> {
        val floorList = arrayListOf<Floor>()

        for (floorNumber in 1..floorCount) {
            val availableSpotList = getParkingSpotList(vehicleSpotCapacity, floorNumber)
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
    fun `should give floor with available spots`() {
        val floorList = getParkingFloorList(3)
        val parkingFloorList = ParkingFloorList(floorList)
        val floor = parkingFloorList.getAvailableFloor()

        assertEquals(1, floor.getFloorNumber())
    }

    @Test
    fun `should give error if no floor is available`() {
        val floorList = getParkingFloorList(0)
        val parkingFloorList = ParkingFloorList(floorList)

        assertThrows(ParkingLotCapacityExceededException::class.java) {
            parkingFloorList.getAvailableFloor()
        }
    }

    @Test
    fun `should give floor by floor number`() {
        val floorList = getParkingFloorList(5)
        val parkingFloorList = ParkingFloorList(floorList)

        val floor = parkingFloorList.getFloorByFloorNumber(4)

        assertEquals(4, floor.getFloorNumber())
    }

    @Test
    fun `should give error if floor number does not exist`() {
        val floorList = getParkingFloorList(2)
        val parkingFloorList = ParkingFloorList(floorList)

        assertThrows(Exception::class.java) {
            parkingFloorList.getFloorByFloorNumber(4)
        }
    }
}