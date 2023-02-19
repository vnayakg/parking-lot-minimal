package repository

import exception.ParkingLotCapacityExceededException
import model.ParkingSpot
import model.VehicleType

class ParkingSpotList(private val availableSpots: ArrayList<ParkingSpot>) {
    fun getNextAvailableSpot(vehicleType: VehicleType): ParkingSpot {
        try {
            return availableSpots.first { spot -> spot.getVehicleType() == vehicleType }
        } catch (exception: NoSuchElementException) {
            throw ParkingLotCapacityExceededException("No available slot for $vehicleType")
        }
    }

    fun vacateSpot(spot: ParkingSpot) {
        if(!availableSpots.contains(spot)){
            availableSpots.add(spot)
        }
    }
}