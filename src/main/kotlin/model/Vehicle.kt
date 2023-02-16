package model

class Vehicle(
    private val type: VehicleType,
    private val licenseNumber: String
) {
    fun getVehicleType(): VehicleType {
        return type
    }

    fun getVehicleLicenseNumber(): String {
        return licenseNumber
    }
}