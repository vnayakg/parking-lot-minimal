package model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class VehicleTest {

    @Test
    fun `should get the vehicle license number`() {
        val licenseNumber = "MH 12 AB 1234"
        val type = VehicleType.CAR
        val vehicle = Vehicle(type, licenseNumber)

        val expectedLicenseNumber = vehicle.getVehicleLicenseNumber()

        assertEquals("MH 12 AB 1234", expectedLicenseNumber)
    }

    @Test
    fun `should get the vehicle type`() {
        val licenseNumber = "MH 12 AB 1234"
        val type = VehicleType.CAR
        val vehicle = Vehicle(type, licenseNumber)

        val expectedVehicleType = vehicle.getVehicleType()

        assertEquals(VehicleType.CAR, expectedVehicleType)
    }
}