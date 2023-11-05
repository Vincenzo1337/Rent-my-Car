package rent.my.car.dao

import Reservations
import rent.my.car.dto.ReservationDTO

interface DAOFacadeReservation {
    suspend fun allReservations(): List<ReservationDTO>
    suspend fun createReservation(reservation: Reservations): Reservations

}
