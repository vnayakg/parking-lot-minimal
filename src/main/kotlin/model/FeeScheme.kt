package model

interface FeeScheme {
    fun calculateFee(parkDurationInHours: Float, vehicleType: VehicleType): Float
}