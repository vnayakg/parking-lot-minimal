import model.ParkingSpot
import service.FeeCalculator
import model.Vehicle
import model.VehicleType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import repository.ParkingSpotList
import java.util.*

class ParkingLotTest {
    private val vehicleSpotCapacity = mapOf(VehicleType.CAR to 100)
    private val spotList = getParkingSpotList()
    private val parkingSpotList = ParkingSpotList(spotList)
    private val feeCalculator = FeeCalculator()
    private val parkingLot = ParkingLot(parkingSpotList, feeCalculator)

    private fun getParkingSpotList(): List<ParkingSpot> {
        val spots = arrayListOf<ParkingSpot>()

        for (entry in vehicleSpotCapacity.entries.iterator()) {
            for (i in 1..entry.value) {
                spots.add(ParkingSpot(i))
            }
        }
        return spots
    }

    @Test
    fun `it should park vehicle`() {
        val vehicle = Vehicle(VehicleType.CAR, "MH 12 AB 1234")
        val issueDateTime = Date()
        val ticket = parkingLot.park(vehicle, issueDateTime)

        assertEquals("MH 12 AB 1234", ticket.getVehicleLicenseNumber())
        assertEquals(issueDateTime, ticket.getIssueDateTime())
    }

    @Test
    fun `it should un park vehicle`() {
        val vehicle = Vehicle(VehicleType.CAR, "MH 12 AB 1234")
        val entryDateTime = Date()
        val milliSecondsInHour = 3600000
        val exitDateTime = Date(entryDateTime.time + milliSecondsInHour)
        val ticket = parkingLot.park(vehicle, entryDateTime)

        val receipt = parkingLot.unPark(ticket, exitDateTime)

        assertEquals("MH 12 AB 1234", ticket.getVehicleLicenseNumber())
        assertEquals(entryDateTime, ticket.getIssueDateTime())
        assertEquals(10.0F, receipt.getFee())
    }
}