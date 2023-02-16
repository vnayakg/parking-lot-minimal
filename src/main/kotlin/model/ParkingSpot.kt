package model

class ParkingSpot(private val spotNumber: Int, private var isEmpty: Boolean = true) {
    private var vehicle: Vehicle? = null
    fun getParkedVehicle(): Vehicle? {
        return vehicle
    }

    fun allocateSlot(vehicle: Vehicle) {
        this.vehicle = vehicle
        isEmpty = false
    }

    fun vacateSlot() {
        this.vehicle = null
        isEmpty = true
    }

    fun isEmpty(): Boolean {
        return isEmpty
    }

    fun getSpotNumber(): Int {
        return spotNumber
    }

}