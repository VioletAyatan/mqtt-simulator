package org.example.simulator.parser

import cn.hutool.core.io.FileUtil

class Test

fun main(args: Array<String>) {
    val entity = ConfigEntity().apply {
        this.configurations = listOf(
            ConfigEntity.MqttConfiguration().apply {
                this.title = "123123"
                this.desc = "Description..."
            },
            ConfigEntity.MqttConfiguration()
        )
    }

    XmlUtil.writerXml(entity, System.out)

    val configEntity =
        XmlUtil.readXml(
            FileUtil.getInputStream("C:\\Users\\lichengkun.CSRD\\Desktop\\mqtt-simulator\\config\\mqtt\\mqtt-configuration.xml"),
            ConfigEntity::class.java
        )
    println("entity = $entity")
}