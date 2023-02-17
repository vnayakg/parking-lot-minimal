package service

import exception.InvalidTimeDurationException
import exception.InvalidVehicleTypeException
import model.VehicleType
import java.util.*

class FeeCalculator : FeeScheme {
    private val perHourFee = 10
    override fun calculateFee(entryDateTime: Date, exitDateTime: Date, vehicleType: VehicleType): Float {
        val parkDurationInHours = calculateParkHours(entryDateTime, exitDateTime)
        if (parkDurationInHours <= 0) throw InvalidTimeDurationException("Park duration in hours should be positive")

        when (vehicleType) {
            VehicleType.CAR -> return perHourFee * parkDurationInHours
            else -> throw InvalidVehicleTypeException("Vehicle type is invalid")
        }
    }

    private fun calculateParkHours(issueDateTime: Date, exitDateTime: Date): Float {
        val timeDifferenceInMilliSeconds = exitDateTime.time - issueDateTime.time
        val milliSecondsPerHour = 1000f * 60f * 60f

        return timeDifferenceInMilliSeconds / milliSecondsPerHour
    }

}