package calculator

import model.VehicleType
import java.util.*

interface FeeScheme {
    fun calculateFee(entryDateTime: Date, exitDateTime: Date, vehicleType: VehicleType): Float
}