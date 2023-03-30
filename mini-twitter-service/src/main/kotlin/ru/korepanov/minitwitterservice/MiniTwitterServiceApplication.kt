package ru.korepanov.minitwitterservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MiniTwitterServiceApplication

fun main(args: Array<String>) {
	runApplication<MiniTwitterServiceApplication>(*args)
}
