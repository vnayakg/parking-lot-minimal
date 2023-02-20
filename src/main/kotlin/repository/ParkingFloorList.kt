package repository

import exception.ParkingLotCapacityExceededException
import model.Floor
import model.ParkingSpot
import model.VehicleType

class ParkingFloorList(private val parkingFloorList: ArrayList<Floor>) {

    fun getNextAvailableSpot(vehicleType: VehicleType): ParkingSpot {
        for(parkingFloor in parkingFloorList){
            try {
                return parkingFloor.getNextAvailableSpot(vehicleType)
            }
            catch (exception: ParkingLotCapacityExceededException){
                println(exception)
            }
        }
        throw ParkingLotCapacityExceededException("Parking capacity exceeded")
    }

    fun vacateSpot(spot: ParkingSpot) {
        val spotFloor = parkingFloorList.first{parkingFloor -> parkingFloor.getFloorNumber() == spot.getFloorNumber()}
        spotFloor.vacateSpot(spot)
    }
}