package rent.my.car.dao

import java.time.LocalDate
import Reservation

import rent.my.car.models.TimeBlock


object DAOInMemoryReservation : DAOFacadeReservation {
    private val reservation = mutableListOf<Reservation>()


    // Dummy Reservations voor API testen.
    /*init {
        val startDate1 = LocalDate.of(2024, 5, 1)
        val endDate1 = LocalDate.of(2024, 5, 5)

        val startDate2 = LocalDate.of(2024, 5, 6)
        val endDate2 = LocalDate.of(2024, 5, 5)

        val startDate3 = LocalDate.of(2024, 5, 11)
        val endDate3 = LocalDate.of(2024, 5, 15)

        val timeBlock1 = TimeBlock(startDate1.toEpochDay(), endDate1.toEpochDay())
        val timeBlock2 = TimeBlock(startDate2.toEpochDay(), endDate2.toEpochDay())
        val timeBlock3 = TimeBlock(startDate3.toEpochDay(), endDate3.toEpochDay())

        reservation.add(Reservation(1, 1, timeBlock1, price = 4))
        reservation.add(Reservation(2, 2, timeBlock2, price = 7))
        reservation.add(Reservation(3, 3, timeBlock3, price = 6))
    }*/

    override suspend fun createReservation(reservation: Reservation): Reservation {
        this.reservation.add(reservation)
        return reservation
    }

    override suspend fun allReservations(): List<Reservation> {
        return reservation.toList()
    }
}
