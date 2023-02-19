import java.util.*

class IDGenerator {

    fun generateTicketID(): String {
        return UUID.randomUUID().toString()
    }

    fun generateReceiptID(): String {
        return UUID.randomUUID().toString()
    }
}