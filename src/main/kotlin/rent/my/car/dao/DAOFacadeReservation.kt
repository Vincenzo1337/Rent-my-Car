package rent.my.car.dao

import Reservation

interface DAOFacadeReservation {
    suspend fun allReservations(): List<Reservation>
    suspend fun createReservation(reservation: Reservation): Reservation

}
