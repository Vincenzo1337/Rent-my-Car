package rent.my.car.routes

import Reservation
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import rent.my.car.dao.DAOInMemoryReservation
import rent.my.car.dao.DaoInMemoryCar
import java.time.LocalDate

fun Route.reservationRouting() {

    get("/reservations") {
        call.respond(DAOInMemoryReservation.allReservations())
    }

    get("reservations/{car_id}/availability") {
        val carId = call.parameters["car_id"]?.toIntOrNull()
        if (carId == null) {
            call.respondText("Invalid car id")
            return@get
        }
        val car = DaoInMemoryCar.getCarById(carId)
        if (car == null) {
            call.respond(HttpStatusCode.NotFound)
            return@get
        }
        if (!car.availability)
            call.respond(false)
        val now = LocalDate.now().toEpochDay()
        val reservations = DAOInMemoryReservation.allReservations().filter { it.carId == carId }
        call.respond(reservations.none { reservation -> reservation.timeBlock.startTime <= now && reservation.timeBlock.endTime >= now })
    }

    post("/reservations") {
        System.out.println("Received reservation")
        val receivedReservation = call.receive<Reservation>()
        DAOInMemoryReservation.createReservation(receivedReservation)
        call.respondText("Reservering toegevoegd!")
    }
}