package org.example.simulator.mqtt

import org.slf4j.LoggerFactory
import org.springframework.messaging.Message
import org.springframework.messaging.MessageHandler
import org.springframework.stereotype.Component

@Component
class MqttSubscriptionConsumer : MessageHandler {

    private val log = LoggerFactory.getLogger(MqttSubscriptionConsumer::class.java)

    override fun handleMessage(message: Message<*>) {
        log.info("收到MQTT消息{}", message.toString())
    }
}
