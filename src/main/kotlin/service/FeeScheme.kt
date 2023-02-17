package service

import model.VehicleType
import java.util.*

interface FeeScheme {
    fun calculateFee(startEndTime: Date, exitDateTime: Date, vehicleType: VehicleType): Float
}