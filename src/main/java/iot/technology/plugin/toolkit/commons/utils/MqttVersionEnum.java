package iot.technology.plugin.toolkit.commons.utils;

/**
 * @author mushuwei
 */
public enum MqttVersionEnum {

    MQTT_31("3.1"),

    MQTT_311("3.1.1");

    private String label;

    public static String[] getLabels() {
        String[] labels = new String[MqttVersionEnum.values().length];
        MqttVersionEnum[] mqttVersion = MqttVersionEnum.values();
        for (int i = 0; i < mqttVersion.length; i++) {
            labels[i] = mqttVersion[i].getLabel();
        }
        return labels;
    }

    MqttVersionEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
