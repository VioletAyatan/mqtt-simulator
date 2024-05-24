package org.example.simulator.mqtt.config

import lombok.RequiredArgsConstructor
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.logging.JSR47Logger
import org.example.simulator.mqtt.MqttSubscriptionConsumer
import org.slf4j.LoggerFactory
import org.springframework.aot.hint.RuntimeHints
import org.springframework.aot.hint.RuntimeHintsRegistrar
import org.springframework.context.annotation.Bean
import org.springframework.integration.annotation.IntegrationComponentScan
import org.springframework.integration.annotation.ServiceActivator
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.core.MessageProducer
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory
import org.springframework.integration.mqtt.core.MqttPahoClientFactory
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.MessageHandler

//@Configuration
@RequiredArgsConstructor
@IntegrationComponentScan("org.example.simulator.mqtt")
class MqttConfig {

    private val log = LoggerFactory.getLogger(MqttConfig::class.java)

    @Bean
    fun mqttMessageProducer(clientFactory: MqttPahoClientFactory?): MessageProducer {
        val channelAdapter: MqttPahoMessageDrivenChannelAdapter = MqttPahoMessageDrivenChannelAdapter("", clientFactory)
        //添加订阅
        channelAdapter.addTopic("")
        channelAdapter.setCompletionTimeout(5000)
        //消息转换器
        channelAdapter.setConverter(DefaultPahoMessageConverter())
        channelAdapter.setOutputChannel(mqttInboundChannel())
        return channelAdapter
    }

    @Bean
    fun mqttPahoClientFactory(): MqttPahoClientFactory {
        val clientFactory: DefaultMqttPahoClientFactory = DefaultMqttPahoClientFactory()

        val options: MqttConnectOptions = MqttConnectOptions()
        options.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1_1)
        options.setServerURIs(arrayOf(""))

        clientFactory.setConnectionOptions(options)

        return clientFactory
    }

    @Bean
    fun mqttInboundChannel(): MessageChannel {
        return DirectChannel()
    }

    @Bean
    fun mqttOutboundChannel(): MessageChannel {
        return DirectChannel()
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInboundChannel")
    fun mqttInboundHandler(mqttSubscriptionConsumer: MqttSubscriptionConsumer): MessageHandler {
        return mqttSubscriptionConsumer
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    fun mqttOutboundHandler(): MessageHandler {
        val messageHandler = MqttPahoMessageHandler("testClient", mqttPahoClientFactory())
        messageHandler.setAsync(true)
        return messageHandler
    }

    class MqttNativeRuntimeConfig : RuntimeHintsRegistrar {

        override fun registerHints(hints: RuntimeHints, classLoader: ClassLoader?) {
            println("================================开始注册Native环境配置================================")
            hints.resources()
                .apply {
                    this.registerResourceBundle("org.eclipse.paho.client.mqttv3.internal.nls.logcat")
                    this.registerType(JSR47Logger::class.java)
                }
        }
    }
}
