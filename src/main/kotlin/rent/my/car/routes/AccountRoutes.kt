package rent.my.car.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import rent.my.car.dao.DaoInMemoryAccount
import rent.my.car.models.Account

fun Route.accountRouting() {

    post("/login") {
        val receivedAccount = call.receive<Account>()
        if (DaoInMemoryAccount.login(receivedAccount.userName, receivedAccount.password)) {
            call.respondText("Ingelogd!")
        } else {
            call.respond(HttpStatusCode.Unauthorized, "Foutieve gebruikersnaam of wachtwoord")
        }
    }
}
