package me.bactoria.layered

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Resilience4jApplication

fun main(args: Array<String>) {
	runApplication<Resilience4jApplication>(*args)
}
