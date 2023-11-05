package rent.my.car.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import rent.my.car.dao.DAOInMemoryReserveringen as daoReserveringen
import rent.my.car.dto.ReserveringenDTO
import io.ktor.server.request.*


fun Route.reserveringenRouting() {
    get("/") {
        call.respondText("Rent my car API")
    }

    get("/reserveringen") {
        call.respond(daoReserveringen.allReserveringen())
    }}

//    get("/car/{id}") {
//        val carId = call.parameters["id"]?.toInt()
//
//        if (carId != null) {
//            val car = daoCar.getCarById(carId)
//            if (car != null) {
//                call.respond(car)
//            } else {
//                call.respondText("Car not found", status = HttpStatusCode.NotFound)
//            }
//        } else {
//            call.respondText("Invalid car ID", status = HttpStatusCode.BadRequest)
//        }
//    }
//}
