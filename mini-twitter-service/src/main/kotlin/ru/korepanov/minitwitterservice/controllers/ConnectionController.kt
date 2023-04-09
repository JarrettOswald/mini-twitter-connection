package ru.korepanov.minitwitterservice.controllers


import org.openapitools.api.ConnectionsApi
import org.openapitools.model.ConnectionRead
import org.openapitools.model.ConnectionWrite
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import ru.korepanov.minitwitterservice.repositories.ConnectionsRepository
import ru.korepanov.minitwitterservice.tables.pojos.Connections
import java.util.*

@Controller
class ConnectionController(val connectionsRepository: ConnectionsRepository) : ConnectionsApi {

    override fun getConnectionByUserName(userId: UUID): ResponseEntity<List<ConnectionRead>> {
        connectionsRepository.fetchById(userId)
        return super.getConnectionByUserName(userId)
    }

    override fun getConnections(): ResponseEntity<List<ConnectionRead>> {
        val list: List<ConnectionRead> = connectionsRepository.findAll()
            .map { ConnectionRead(it.id, it.follower, it.followed) }
        return ResponseEntity(list, HttpStatusCode.valueOf(200))
    }

    override fun saveConnection(connectionWrite: ConnectionWrite): ResponseEntity<String> {
        connectionsRepository.insert(Connections(UUID.randomUUID(), connectionWrite.follower, connectionWrite.followed))
        return ResponseEntity("connection added", HttpStatusCode.valueOf(200))
    }
}