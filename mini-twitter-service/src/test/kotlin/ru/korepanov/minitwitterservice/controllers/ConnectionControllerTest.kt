package ru.korepanov.minitwitterservice.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.checkerframework.checker.guieffect.qual.UI
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.openapitools.model.Connection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
class ConnectionControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun getFollowedConnectionByUserId() {
        mockMvc.perform(
            MockMvcRequestBuilders
                .get("/connections/cab10b1a-dedb-11ed-b5ea-0242ac120002/followed")
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
    }

    @Test
    fun getFollowerConnectionByUserId() {
        mockMvc.perform(
            MockMvcRequestBuilders
                .get("/connections/cab10b1a-dedb-11ed-b5ea-0242ac120002/follower")
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
    }

    @Test
    fun getConnections() {
        val connection = Connection(
            uuid = UUID.randomUUID(),
            followed = UUID.randomUUID(),
            follower = UUID.randomUUID()
        )
        mockMvc.perform(
            MockMvcRequestBuilders
                .get("/connections")
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
    }

    @Test
    fun saveConnection() {
        val connection = Connection(
            uuid = UUID.randomUUID(),
            followed = UUID.randomUUID(),
            follower = UUID.randomUUID()
        )
        mockMvc.perform(
            MockMvcRequestBuilders
                .post("/connections")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(connection))
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
    }

    @Test
    fun updateConnectionByUserId() {
        val connection = Connection(
            uuid = UUID.randomUUID(),
            followed = UUID.randomUUID(),
            follower = UUID.randomUUID()
        )
        mockMvc.perform(
            MockMvcRequestBuilders
                .put("/connections/cab10b1a-dedb-11ed-b5ea-0242ac120002")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(connection))
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())

    }

    companion object {
        private val objectMapper: ObjectMapper = ObjectMapper()

        @JvmStatic
        @BeforeAll
        fun before() {
            objectMapper.registerModule(JavaTimeModule())
        }

    }
}