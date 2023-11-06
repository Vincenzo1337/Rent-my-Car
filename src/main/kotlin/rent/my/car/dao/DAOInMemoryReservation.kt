package rent.my.car.dao

import Reservations
import rent.my.car.dto.ReservationDTO


object DAOInMemoryReservation : DAOFacadeReservation {
    private val reservations = mutableListOf<Reservations>()

    override suspend fun createReservation(reservation: Reservations): Reservations {
        reservations.add(reservation)
        return reservation
    }

    override suspend fun allReservations(): List<ReservationDTO> {
        return allReservations()
    }
}


//    val exampleReservation = Reservations(
//    reservationId = 1,
//    userId = User(name = "John Doe", email = "john@example.com", password = "geheim", role = "ROLE", id = 1, drivingBehavior = "GOOD"),
//    carId = Car(brand = "BMW", type = "Type", category = "ICE"),
//    timeBlockId = TimeBlock(startTime = 1636094400, endTime = 1636180800)
//)
