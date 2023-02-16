package repository

import exception.InvalidVehicleNumberException
import exception.ParkingLotCapacityExceededException
import model.ParkingSpot
import model.VehicleType

class ParkingSpotRepository(parkingSpotCapacity: Map<VehicleType, Int>) {
    private val spots = mutableMapOf<VehicleType, ArrayList<ParkingSpot>>()

    init {
        for (entry in parkingSpotCapacity.entries.iterator()) {
            spots[entry.key] = arrayListOf()

            for (i in 1..entry.value) {
                spots[entry.key]?.add(ParkingSpot(i))
            }
        }
    }

    fun getNextAvailableSpot(vehicleType: VehicleType): ParkingSpot {
        for (spot in spots[vehicleType]!!) {
            if (spot.isEmpty())
                return spot
        }
        throw ParkingLotCapacityExceededException("No available slot for $vehicleType")
    }

    fun getSpotByVehicleNumber(vehicleType: VehicleType, vehicleNumber: String): ParkingSpot {
        for (spot in spots[vehicleType]!!) {
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