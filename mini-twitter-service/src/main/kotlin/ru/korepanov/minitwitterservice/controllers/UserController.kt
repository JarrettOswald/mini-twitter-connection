package ru.korepanov.minitwitterservice.controllers

import org.openapitools.api.UsersApi
import org.openapitools.model.User
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import ru.korepanov.minitwitterservice.repositories.UsersRepository
import ru.korepanov.minitwitterservice.tables.pojos.Users
import java.util.*

@Controller
class UserController(val usersRepository: UsersRepository) : UsersApi {

    private val logger = LoggerFactory.getLogger(javaClass)
    override fun findAllUsers(): ResponseEntity<List<User>> {
        logger.info("find all users")
        val list = usersRepository.findAll().map { User(it.id, it.name, it.surname) }
        return ResponseEntity(list, HttpStatus.OK)
    }

    override fun getUserByUserId(userId: UUID): ResponseEntity<List<User>> {
        logger.info("get user by uuid:$userId")
        val users = usersRepository.fetchById(userId)
        val listUser = users.map { User(it.id, it.name, it.surname) }
        return ResponseEntity(listUser, HttpStatus.OK)
    }

    override fun saveUser(user: User): ResponseEntity<String> {
        logger.info("save user:$user")
        usersRepository.insert(Users(user.uuid, user.name, user.surname))
        return ResponseEntity("save user:$user", HttpStatus.OK)
    }

    override fun updateUserByUserId(userId: UUID, user: User): ResponseEntity<String> {
        logger.info("update user:$user")
        usersRepository.update(Users(user.uuid, user.name, user.surname))
        return ResponseEntity("update user:$user", HttpStatus.OK)
    }

}