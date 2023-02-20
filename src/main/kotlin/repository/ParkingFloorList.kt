package repository

import exception.ParkingLotCapacityExceededException
import model.Floor

class ParkingFloorList(private val parkingFloorList: ArrayList<Floor>) {

    fun getAvailableFloor(): Floor {
        return parkingFloorList.find { it.isSpotAvailable() }
            ?: throw ParkingLotCapacityExceededException("Parking capacity exceeded")
    }

    fun getFloorByFloorNumber(floorNumber: Int): Floor {
        return parkingFloorList.find { it.getFloorNumber() == floorNumber }
            ?: throw Exception("Floor with floor number $floorNumber does not exits")
    }
}