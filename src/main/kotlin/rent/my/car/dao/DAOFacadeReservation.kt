package rent.my.car.dao

import Reservations
import rent.my.car.dto.ReservationDTO
import rent.my.car.models.*

interface DAOFacadeReservation {
    suspend fun allReservations(): List<Reservations>
    suspend fun createReservation(reservation: Reservations): Reservations

}
