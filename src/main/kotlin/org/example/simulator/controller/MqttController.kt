package org.example.simulator.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mqtt")
class MqttController {

    @PostMapping("/send")
    fun sendMessage(@RequestBody message: String) {
    }
}