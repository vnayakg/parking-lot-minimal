package model

import exception.ParkingLotCapacityExceededException
import java.util.ArrayList

class Floor(private val floorNumber: Int, private val availableSpots: ArrayList<ParkingSpot>) {
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

    fun getFloorNumber(): Int {
        return floorNumber
    }

    fun isSpotAvailable(): Boolean {
        return availableSpots.isNotEmpty()
    }
}