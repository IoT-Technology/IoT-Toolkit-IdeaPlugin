package iot.technology.plugin.toolkit.mqtt.model;


import iot.technology.plugin.toolkit.commons.utils.GenerateUtils;

/**
 * @author mushuwei
 */
public class MqttServerConfiguration implements Cloneable {

    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 1883;

    private String configName;

    private String clientId;

    private String host;

    private Integer port;

    private String userName;

    private String password;

    private String mqttVersion;

    private Integer connectTime;

    private Integer keepAlive;

    private Boolean autoReconnect;

    private Integer autoReconnectTime;

    private Boolean cleanSession;

    private Boolean ssl;

    /**
     * 1: ca signed server
     * 2: self signed
     */
    private Integer certificate;

    private String caFile;

    private String clientCertFile;

    private String clientKeyFile;

    private String lastWillTopic;

    private Integer lastWillQos;

    private Boolean lastWillRetain;

    private String lastWillPayload;

    public static MqttServerConfiguration byDefault() {
        MqttServerConfiguration serverConfiguration = new MqttServerConfiguration();
        serverConfiguration.setClientId(GenerateUtils.generateMqttClientId());
        serverConfiguration.setHost(DEFAULT_HOST);
        serverConfiguration.setPort(DEFAULT_PORT);
        return serverConfiguration;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMqttVersion() {
        return mqttVersion;
    }

    public void setMqttVersion(String mqttVersion) {
        this.mqttVersion = mqttVersion;
    }

    public Integer getConnectTime() {
        return connectTime;
    }

    public void setConnectTime(Integer connectTime) {
        this.connectTime = connectTime;
    }

    public Integer getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Integer keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getAutoReconnect() {
        return autoReconnect;
    }

    public void setAutoReconnect(Boolean autoReconnect) {
        this.autoReconnect = autoReconnect;
    }

    public Integer getAutoReconnectTime() {
        return autoReconnectTime;
    }

    public void setAutoReconnectTime(Integer autoReconnectTime) {
        this.autoReconnectTime = autoReconnectTime;
    }

    public Boolean getCleanSession() {
        return cleanSession;
    }

    public void setCleanSession(Boolean cleanSession) {
        this.cleanSession = cleanSession;
    }

    public Boolean getSsl() {
        return ssl;
    }

    public void setSsl(Boolean ssl) {
        this.ssl = ssl;
    }

    public Integer getCertificate() {
        return certificate;
    }

    public void setCertificate(Integer certificate) {
        this.certificate = certificate;
    }

    public String getCaFile() {
        return caFile;
    }

    public void setCaFile(String caFile) {
        this.caFile = caFile;
    }

    public String getClientCertFile() {
        return clientCertFile;
    }

    public void setClientCertFile(String clientCertFile) {
        this.clientCertFile = clientCertFile;
    }

    public String getClientKeyFile() {
        return clientKeyFile;
    }

    public void setClientKeyFile(String clientKeyFile) {
        this.clientKeyFile = clientKeyFile;
    }

    public String getLastWillTopic() {
        return lastWillTopic;
    }

    public void setLastWillTopic(String lastWillTopic) {
        this.lastWillTopic = lastWillTopic;
    }

    public Integer getLastWillQos() {
        return lastWillQos;
    }

    public void setLastWillQos(Integer lastWillQos) {
        this.lastWillQos = lastWillQos;
    }

    public Boolean getLastWillRetain() {
        return lastWillRetain;
    }

    public void setLastWillRetain(Boolean lastWillRetain) {
        this.lastWillRetain = lastWillRetain;
    }

    public String getLastWillPayload() {
        return lastWillPayload;
    }

    public void setLastWillPayload(String lastWillPayload) {
        this.lastWillPayload = lastWillPayload;
    }
}
