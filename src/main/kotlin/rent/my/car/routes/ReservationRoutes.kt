package rent.my.car.routes

import Reservations
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import rent.my.car.dao.DAOInMemoryReservation

fun Route.reservationRouting() {

    get("/reservations") {
        call.respond(DAOInMemoryReservation.allReservations())
    }

    post("/add/reservation") {
        val receivedReservation = call.receive<Reservations>()
        DAOInMemoryReservation.createReservation(receivedReservation)
        call.respondText("Reservering toegevoegd!")
    }
}
