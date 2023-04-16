package ru.korepanov.minitwitterservice.controllers


import org.openapitools.api.ConnectionsApi
import org.openapitools.model.Connection
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import ru.korepanov.minitwitterservice.repositories.ConnectionsRepository
import ru.korepanov.minitwitterservice.tables.pojos.Connections
import ru.korepanov.minitwitterservice.tables.pojos.Users
import java.util.*


@Controller
class ConnectionController(val connectionsRepository: ConnectionsRepository) : ConnectionsApi {

    private val logger = LoggerFactory.getLogger(javaClass)
    override fun getConnectionByUserName(userId: UUID): ResponseEntity<Connection> {
        logger.info("get user by uuid:$userId")
        val connections = connectionsRepository.fetchById(userId)
        if (connections.size > 1) {
            throw IllegalStateException("userId not unique")
        }
        val connection = connections[0]
        val connectionModel = Connection(connection.id, connection.follower, connection.follower)
        return ResponseEntity(connectionModel, HttpStatusCode.valueOf(200))
    }

    override fun getConnections(): ResponseEntity<List<Connection>> {
        logger.info("get all connections")

        val list: List<Connection> = connectionsRepository.findAll()
            .map { Connection(it.id, it.follower, it.followed) }
        return ResponseEntity(list, HttpStatusCode.valueOf(200))
    }

    override fun saveConnection(connection: Connection): ResponseEntity<String> {
        logger.info("save connections $connection")

        connectionsRepository.insert(Connections(UUID.randomUUID(), connection.follower, connection.followed))
        return ResponseEntity("connection added", HttpStatusCode.valueOf(200))
    }

    override fun updateConnectionByUserId(userId: UUID, connection: Connection): ResponseEntity<String> {
        logger.info("update connection:$connection")
        connectionsRepository.update(Connections(connection.uuid, connection.follower, connection.followed))
        return ResponseEntity("update connection:$connection", HttpStatusCode.valueOf(200))
    }
}