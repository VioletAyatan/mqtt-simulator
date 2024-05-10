package org.example.simulator.parser

import jakarta.xml.bind.annotation.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "mqtt-configuration")
class ConfigEntity {
    @XmlElementWrapper
    var configurations: List<MqttConfiguration> = emptyList()

    @XmlAttribute
    var name: String = ""

    @XmlAccessorType(XmlAccessType.FIELD)
    class MqttConfiguration {
        @XmlAttribute
        var title: String = ""

        @XmlAttribute
        var desc: String = ""
        var topic: String = ""
        var content: String = ""
    }
}
