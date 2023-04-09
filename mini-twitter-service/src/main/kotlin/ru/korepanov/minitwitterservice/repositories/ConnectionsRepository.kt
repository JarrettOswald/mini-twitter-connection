package ru.korepanov.minitwitterservice.repositories


import org.jooq.Configuration
import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import ru.korepanov.minitwitterservice.Tables
import ru.korepanov.minitwitterservice.tables.daos.ConnectionsDao
import ru.korepanov.minitwitterservice.tables.daos.UsersDao
import ru.korepanov.minitwitterservice.tables.pojos.Connections
import ru.korepanov.minitwitterservice.tables.records.ConnectionsRecord

@Repository
class ConnectionsRepository(private val dslContext: DSLContext, configuration: Configuration) : ConnectionsDao(configuration) {

}