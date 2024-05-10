package org.example.simulator.controller

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/config")
class ConfigController {

    @GetMapping("/import")
    fun importConfig(request: HttpServletRequest, response: HttpServletResponse) {

    }

    @GetMapping("/export")
    fun exportConfig(request: HttpServletRequest, response: HttpServletResponse) {

    }
}