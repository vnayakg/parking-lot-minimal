package repository

import exception.ParkingLotCapacityExceededException
import model.ParkingSpot
import model.VehicleType

class ParkingSpotList(private val spots: ArrayList<ParkingSpot>) {
    fun getNextAvailableSpot(vehicleType: VehicleType): ParkingSpot {
        try {
            return spots.first { spot -> spot.getVehicleType() == vehicleType }
        } catch (exception: NoSuchElementException) {
            throw ParkingLotCapacityExceededException("No available slot for $vehicleType")
        }
    }

    fun vacateSpot(spot: ParkingSpot) {
        spots.add(spot)
    }
}