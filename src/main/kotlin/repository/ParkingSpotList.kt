package repository

import exception.ParkingLotCapacityExceededException
import model.ParkingSpot
import model.VehicleType

class ParkingSpotList(private val spots: ArrayList<ParkingSpot>) {
    fun getNextAvailableSpot(vehicleType: VehicleType): ParkingSpot {

        for (spot in spots) {
            if (spot.getVehicleType() == vehicleType) {
                spots.remove(spot)
                return spot
            }
        }
        throw ParkingLotCapacityExceededException("No available slot for $vehicleType")
    }

    fun vacateSpot(spot: ParkingSpot) {
        spots.add(spot)
    }
}