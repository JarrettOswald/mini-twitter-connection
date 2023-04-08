package ru.korepanov.minitwitterservice.controllers


import org.openapitools.api.ConnectionsApi
import org.openapitools.model.Connection
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import ru.korepanov.minitwitterservice.repositories.UsersRepository

@Controller
class ConnectionController(val usersRepository: UsersRepository) : ConnectionsApi {

    override fun getConnectionByUserName(userId: Long): ResponseEntity<List<Connection>> {
        println("boooo")
        return super.getConnectionByUserName(userId)
    }

    override fun getConnections(): ResponseEntity<List<Connection>> {
        println("fooo")
        return super.getConnections()
    }
}