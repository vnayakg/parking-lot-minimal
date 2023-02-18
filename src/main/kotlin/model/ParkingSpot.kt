package model

class ParkingSpot(
    private val spotNumber: Int,
    private val vehicleType: VehicleType,
) {
    fun getSpotNumber(): Int {
        return spotNumber
    }

    fun getVehicleType(): VehicleType {
        return vehicleType
    }
}