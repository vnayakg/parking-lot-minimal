package model

class ParkingSpot(
    private val spotNumber: Int,
    private val vehicleType: VehicleType,
    private val floorNumber: Int
) {
    fun getSpotNumber(): Int {
        return spotNumber
    }

    fun getVehicleType(): VehicleType {
        return vehicleType
    }

    fun getFloorNumber(): Int {
        return floorNumber
    }
}