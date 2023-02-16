import model.VehicleType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ParkingSpotRepositoryTest {
    @Test
    fun `should initialize parking spots`() {
        val vehicleSpotCapacity = mapOf(VehicleType.CAR to 100)
        val parkingSpotRepository = ParkingSpotRepository()

        val spots = parkingSpotRepository.initialize(vehicleSpotCapacity)

        assertEquals(spots[VehicleType.CAR]?.size, 100)
    }

    @Test
    fun `should be able to find next available spot`() {
        val vehicleSpotCapacity = mapOf(VehicleType.CAR to 100)
        val parkingSpotRepository = ParkingSpotRepository()
        parkingSpotRepository.initialize(vehicleSpotCapacity)

        val nextAvailableSpot = parkingSpotRepository.getNextAvailableSpot(VehicleType.CAR)

        assertEquals(1, nextAvailableSpot.getSpotNumber())
    }
}