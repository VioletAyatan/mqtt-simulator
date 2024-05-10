package org.example.simulator.mqtt;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * Mqtt消息模板
 * <p>
 * 通过这个类实现消息发送
 *
 * @author ankol
 */
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttTemplate {
    /**
     * 发送MQTT消息
     *
     * @param topic topic
     * @param data  data
     */
    void sendMqttMessage(@Header(MqttHeaders.TOPIC) String topic, String data);

    /**
     * 发送MQTT消息
     *
     * @param topic topic
     * @param data  data
     */
    void sendMqttMessage(@Header(MqttHeaders.TOPIC) String topic, byte[] data);

    /**
     * 发送MQTT消息
     *
     * @param topic topic
     * @param data  data
     * @param qos   qos
     */
    void sendMqttMessage(@Header(MqttHeaders.TOPIC) String topic, String data, @Header(MqttHeaders.QOS) int qos);

    /**
     * 发送MQTT消息
     *
     * @param topic topic
     * @param data  data
     * @param qos   qos
     */
    void sendMqttMessage(@Header(MqttHeaders.TOPIC) String topic, byte[] data, @Header(MqttHeaders.QOS) int qos);
}
