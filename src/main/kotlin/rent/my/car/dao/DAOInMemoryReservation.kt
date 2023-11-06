package rent.my.car.dao

import java.time.LocalDate
import Reservations

import rent.my.car.models.TimeBlock


object DAOInMemoryReservation : DAOFacadeReservation {
    private val reservations = mutableMapOf<Int, Reservations>()

    init {
        val startDate1 = LocalDate.of(2023, 10, 1)
        val endDate1 = LocalDate.of(2023, 10, 5)

        val startDate2 = LocalDate.of(2023, 10, 6)
        val endDate2 = LocalDate.of(2023, 10, 10)

        val startDate3 = LocalDate.of(2023, 10, 11)
        val endDate3 = LocalDate.of(2023, 10, 15)

        val timeBlock1 = TimeBlock(startDate1.toEpochDay(), endDate1.toEpochDay())
        val timeBlock2 = TimeBlock(startDate2.toEpochDay(), endDate2.toEpochDay())
        val timeBlock3 = TimeBlock(startDate3.toEpochDay(), endDate3.toEpochDay())

        reservations[1] = Reservations(1, "BMW", timeBlock1, price = 4)
        reservations[2] = Reservations(2, "Golf", timeBlock2, price = 7)
        reservations[3] = Reservations(3, "Merrie", timeBlock3, price = 6)
    }

    override suspend fun createReservation(reservation: Reservations): Reservations {
        reservations[reservation.userid] = reservation
        return reservation
    }

    override suspend fun allReservations(): List<Reservations> {
        return reservations.values.toList()
    }
}
