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

    post("/register") {
        val newAccount = call.receive<Account>()
        if (DaoInMemoryAccount.register(newAccount)) {
            call.respondText("Registratie voltooid!")
        } else {
            call.respond(HttpStatusCode.Conflict, "Gebruikersnaam is al in gebruik")
        }
    }

    get("/accounts") {
        val accounts = DaoInMemoryAccount.getAccounts()
        call.respond(accounts)
    }

    get("/account/{username}") {
        val username = call.parameters["username"]
        if (username != null) {
            val account = DaoInMemoryAccount.getAccounts().find { it.userName == username }
            if (account != null) {
                call.respond(account)
            } else {
                call.respond(HttpStatusCode.NotFound, "Gebruiker niet gevonden")
            }
        } else {
            call.respond(HttpStatusCode.BadRequest, "Ongeldige gebruikersnaam")
        }
    }

    put("/account/{username}") {
        val username = call.parameters["username"]
        val updatedAccount = call.receive<Account>()
        if (username != null) {
            val originalAccount = DaoInMemoryAccount.getAccounts().find { it.userName == username }
            if (originalAccount != null) {
                if (updatedAccount.userName != originalAccount.userName ||
                    updatedAccount.userId != originalAccount.userId ||
                    updatedAccount.email != originalAccount.email) {
                    call.respond(HttpStatusCode.BadRequest, "Alleen phone en password mogen worden bijgewerkt")
                } else if (DaoInMemoryAccount.updateAccount(updatedAccount)) {
                    call.respond(HttpStatusCode.OK, "Profiel succesvol bijgewerkt")
                } else {
                    call.respond(HttpStatusCode.NotFound, "Update mislukt")
                }
            } else {
                call.respond(HttpStatusCode.NotFound, "Gebruiker niet gevonden")
            }
        } else {
            call.respond(HttpStatusCode.BadRequest, "Geen username opgegeven")
        }
    }
}


/*
put("/account/{username}") {
    val username = call.parameters["username"]
    val updatedAccount = call.receive<Account>()
    if (username != null && DaoInMemoryAccount.updateAccount(updatedAccount)) {
        call.respond(HttpStatusCode.OK, "Profiel succesvol bijgewerkt")
    } else {
        call.respond(HttpStatusCode.NotFound, "Gebruiker niet gevonden of update mislukt")
    }
}*/
