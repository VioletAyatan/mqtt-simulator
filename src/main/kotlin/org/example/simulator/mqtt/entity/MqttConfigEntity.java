package org.example.simulator.mqtt.entity;

import lombok.Data;

import java.util.List;

@Data
public class MqttConfigEntity {

    private String name;
    private List<ConfigurationsDTO> configurations;

    @Data
    public static class ConfigurationsDTO {
        private String title;
        private String desc;
        private String topic;
        private Object content;
    }
}
