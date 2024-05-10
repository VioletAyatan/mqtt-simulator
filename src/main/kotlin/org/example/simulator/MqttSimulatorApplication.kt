package org.example.simulator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MqttSimulatorApplication

fun main(args: Array<String>) {
    runApplication<MqttSimulatorApplication>(*args)
}
