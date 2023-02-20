import calculator.FeeCalculator
import model.Floor
import model.ParkingSpot
import model.Vehicle
import model.VehicleType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import repository.ParkingFloorList
import java.util.*

class ParkingLotTest {
    private val vehicleSpotCapacity = mapOf(VehicleType.CAR to 100)
    private val floorList = getParkingFloorList(3)
    private val parkingFloorList = ParkingFloorList(floorList)
    private val feeCalculator = FeeCalculator()
    private val idGenerator = IDGenerator()
    private val parkingLot = ParkingLot(parkingFloorList, feeCalculator, idGenerator)

    private fun getParkingFloorList(floorCount: Int): ArrayList<Floor> {
        val floorList = arrayListOf<Floor>()

        for (floorNumber in 1..floorCount) {
            val availableSpotList = getParkingSpotList(vehicleSpotCapacity, floorNumber)
            val floor = Floor(floorNumber, availableSpotList)

            floorList.add(floor)
        }
        return floorList
    }

    private fun getParkingSpotList(
        vehicleSpotCapacity: Map<VehicleType, Int>,
        floorNumber: Int
    ): ArrayList<ParkingSpot> {
        val spots = arrayListOf<ParkingSpot>()

        for (entry in vehicleSpotCapacity.entries.iterator()) {
            for (i in 1..entry.value) {
                spots.add(ParkingSpot(i, entry.key, floorNumber))
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