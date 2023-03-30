package ru.korepanov.minitwitterservice.controllers


import org.openapitools.api.ConnectionsApi
import org.openapitools.model.Connection
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller

@Controller
class ConnectionController : ConnectionsApi {

    override fun getConnectionByUserName(userId: Long): ResponseEntity<List<Connection>> {
        return super.getConnectionByUserName(userId)
    }

    override fun getConnections(): ResponseEntity<List<Connection>> {
        return super.getConnections()
    }
}