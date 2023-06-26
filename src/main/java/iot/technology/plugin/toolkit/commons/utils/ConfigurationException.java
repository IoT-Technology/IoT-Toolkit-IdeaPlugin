package iot.technology.plugin.toolkit.commons.utils;

/**
 * @author mushuwei
 */
public class ConfigurationException extends RuntimeException {

    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(Exception ex) {
        super(ex);
    }
}
