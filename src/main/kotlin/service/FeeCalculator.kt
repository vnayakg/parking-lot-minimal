package service

import Constant
import exception.InvalidTimeDurationException
import exception.InvalidVehicleTypeException
import model.VehicleType
import java.util.*

class FeeCalculator : FeeScheme {
    private val perHourFee = Constant.PARK_FEE_CAR
    override fun calculateFee(entryDateTime: Date, exitDateTime: Date, vehicleType: VehicleType): Float {
        val parkDurationInHours = calculateTimeDurationInHours(entryDateTime, exitDateTime)
        if (parkDurationInHours <= 0) throw InvalidTimeDurationException("Park duration in hours should be positive")

        when (vehicleType) {
            VehicleType.CAR -> return perHourFee * parkDurationInHours
            else -> throw InvalidVehicleTypeException("Vehicle type is invalid")
        }
    }

    private fun calculateTimeDurationInHours(startDateTime: Date, endDateTime: Date): Float {
        val timeDifferenceInMilliSeconds = endDateTime.time - startDateTime.time

        return timeDifferenceInMilliSeconds / Constant.MILLI_SECONDS_IN_HOUR
    }

}