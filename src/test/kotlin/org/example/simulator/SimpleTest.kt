package org.example.simulator

import cn.hutool.core.io.FileUtil
import org.example.simulator.parser.GsonUtil
import org.example.simulator.parser.MqttConfig
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.charset.StandardCharsets

class SimpleTest {
    @Test
    fun test() {
        val entity = GsonUtil.fromJson(
            FileUtil.readString(File("config/mqtt/config.json"), StandardCharsets.UTF_8),
            MqttConfig::class.java
        )

        println("javaClass = $javaClass")
    }
}