package ru.korepanov.minitwitterservice.controllers


import org.openapitools.api.ConnectionsApi
import org.openapitools.model.Connection
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import ru.korepanov.minitwitterservice.repositories.ConnectionsRepository
import ru.korepanov.minitwitterservice.tables.pojos.Connections
import java.util.*


@Controller
class ConnectionController(val connectionsRepository: ConnectionsRepository) : ConnectionsApi {

    private val logger = LoggerFactory.getLogger(javaClass)
    override fun getFollowedConnectionByUserName(userId: UUID): ResponseEntity<List<Connection>> {
        logger.info("get user by uuid:$userId")
        val connections = connectionsRepository.fetchByFollowed(userId)
        val listFollowed = connections.map { Connection(it.id, it.follower, it.followed) }
        return ResponseEntity(listFollowed, HttpStatusCode.valueOf(200))
    }

    override fun getFollowerConnectionByUserName(userId: UUID): ResponseEntity<List<Connection>> {
        logger.info("get user by follower uuid:$userId")
        val connections = connectionsRepository.fetchByFollower(userId)
        val listFollower = connections.map { Connection(it.id, it.follower, it.followed) }
        return ResponseEntity(listFollower, HttpStatusCode.valueOf(200))
    }

    override fun getConnections(): ResponseEntity<List<Connection>> {
        logger.info("get all connections")
        val list: List<Connection> = connectionsRepository.findAll().map { Connection(it.id, it.follower, it.followed) }
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