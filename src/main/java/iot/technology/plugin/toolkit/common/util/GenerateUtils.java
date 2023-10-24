package iot.technology.plugin.toolkit.common.util;

import java.util.Random;

/**
 * @author mushuwei
 */
public class GenerateUtils {

    public static String generateMqttClientId () {
        String id = "toolkit_mqtt_";
        String[] options = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".split("");
        for (int i = 0; i < 8; i++) {
            id += options[new Random().nextInt(options.length)];
        }
        return id;
    }
}
