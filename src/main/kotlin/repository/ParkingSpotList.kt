package repository

import exception.InvalidVehicleNumberException
import exception.ParkingLotCapacityExceededException
import model.ParkingSpot
import model.VehicleType

class ParkingSpotList(private val spots: List<ParkingSpot>) {
    fun getNextAvailableSpot(vehicleType: VehicleType): ParkingSpot {
        //return spots.first { spot -> spot.getVehicleType() == vehicleType }

        for (spot in spots) {
            if (spot.isEmpty())
                return spot
        }
        throw ParkingLotCapacityExceededException("No available slot for $vehicleType")
    }


    fun getSpotByVehicleNumber(vehicleNumber: String): ParkingSpot {
        for (spot in spots) {
            val parkedVehicle = spot.getParkedVehicle()

            if (parkedVehicle != null
                && parkedVehicle.getVehicleLicenseNumber() == vehicleNumber
            ) {
                return spot
            }
        }
        throw InvalidVehicleNumberException("$vehicleNumber is invalid")
    }
}