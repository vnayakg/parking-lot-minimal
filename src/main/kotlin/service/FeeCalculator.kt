package service

import exception.InvalidTimeDurationException
import exception.InvalidVehicleTypeException
import model.FeeScheme
import model.VehicleType

class FeeCalculator : FeeScheme {
    private val perHourFee = 10
    override fun calculateFee(parkDurationInHours: Float, vehicleType: VehicleType): Float {
        if (parkDurationInHours <= 0) throw InvalidTimeDurationException("Park duration in hours should be positive")
        when (vehicleType) {
            VehicleType.CAR -> return perHourFee * parkDurationInHours
            else -> throw InvalidVehicleTypeException("Vehicle type is invalid")
        }
    }

}