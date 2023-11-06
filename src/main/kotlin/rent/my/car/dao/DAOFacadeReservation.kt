package rent.my.car.dao

import Reservations

interface DAOFacadeReservation {
    suspend fun allReservations(): List<Reservations>
    suspend fun createReservation(reservation: Reservations): Reservations

}
