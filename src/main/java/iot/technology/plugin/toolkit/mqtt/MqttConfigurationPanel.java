package iot.technology.plugin.toolkit.mqtt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.util.Ref;
import iot.technology.plugin.toolkit.common.util.AuthenticationEnum;
import iot.technology.plugin.toolkit.common.util.ConfigurationException;
import iot.technology.plugin.toolkit.common.util.GenerateUtils;
import iot.technology.plugin.toolkit.common.util.MqttVersionEnum;
import iot.technology.plugin.toolkit.mqtt.model.MqttServerConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

/**
 * @author mushuwei
 */
@SuppressWarnings("unchecked")
public class MqttConfigurationPanel extends JPanel {

    public static final Icon SUCCESS = AllIcons.General.SuccessDialog;
    public static final Icon FAIL = AllIcons.General.ErrorDialog;
    public static final Icon ReGenerateClientId = AllIcons.Actions.Refresh;

    private JPanel rootPanel;
    private JLabel feedbackLabel;

    /**
     * mqtt config name textField
     */
    private JTextField mqttConfigName;

    private JTabbedPane settingTabbedPane;

    /**
     * mqtt config general configuration
     */
    private JTextField clientIdField;
    private JLabel reGeClientId;
    private JTextField hostField;
    private JTextField portField;
    private JComboBox authenticationComboBox;
    private JLabel userlabel;
    private JLabel passlabel;
    private JTextField usernameField;
    private JTextField passwordField;

    /**
     * mqtt config advanced configuration
     */
    private JComboBox mqttVersionComboBox;
    private JSpinner connectTimeout;
    private JSpinner keepAlive;
    private JCheckBox autoReconnectCheckBox;
    private JSpinner autoReconnectTime;
    private JLabel autoReconnectUnit;
    private JCheckBox cleanSessionCheckBox;

    /**
     * mqtt config ssl/tls configuration
     */
    private JCheckBox SSLSecureCheckBox;
    private JRadioButton CASignedServerRadioButton;
    private JRadioButton selfSignedRadioButton;
    private JLabel caFileField;
    private JLabel clientFileField;
    private JLabel clientKeyFileField;
    private TextFieldWithBrowseButton caFile;
    private TextFieldWithBrowseButton clientCertFile;
    private TextFieldWithBrowseButton clientKeyFile;

    /**
     * mqtt config last-will-and-testament
     */
    private JTextField lastWillTopicField;
    private JRadioButton qos0Field;
    private JRadioButton qos1Field;
    private JRadioButton qos2Field;
    private JCheckBox lastWillRetain;
    private JTextArea lastWillPayload;
    private JRadioButton payloadJson;
    private JRadioButton payloadPlain;

    /**
     * test mqtt server
     */
    private JButton testConnectionButton;

    private final Project project;

    public MqttConfigurationPanel(Project project) {
        this.project = project;
        reGeClientId.setIcon(ReGenerateClientId);
        reGeClientId.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clientIdField.setText(GenerateUtils.generateMqttClientId());
            }
        });

        authenticationComboBox.setModel(new DefaultComboBoxModel<>(AuthenticationEnum.getLabels()));
        authenticationComboBox.setSelectedItem(AuthenticationEnum.USER_AND_PASSWORD.getLabel());
        authenticationComboBox.addItemListener(e -> {
            String authentication = (String) authenticationComboBox.getSelectedItem();
            boolean shouldDisplayUserAndPassword = false;
            if (authentication.equals(AuthenticationEnum.USER_AND_PASSWORD.getLabel())) {
                shouldDisplayUserAndPassword = true;
            }
            userlabel.setVisible(shouldDisplayUserAndPassword);
            usernameField.setVisible(shouldDisplayUserAndPassword);
            passlabel.setVisible(shouldDisplayUserAndPassword);
            passwordField.setVisible(shouldDisplayUserAndPassword);

        });


        mqttVersionComboBox.setModel(new DefaultComboBoxModel<>(MqttVersionEnum.getLabels()));
        mqttVersionComboBox.setSelectedItem(MqttVersionEnum.MQTT_311.getLabel());



        boolean isSelected = autoReconnectCheckBox.isSelected();
        autoReconnectTime.setVisible(isSelected);
        autoReconnectUnit.setVisible(isSelected);

        autoReconnectCheckBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                autoReconnectTime.setVisible(true);
                autoReconnectTime.setValue(4000);
                autoReconnectUnit.setVisible(true);
            } else {
                autoReconnectTime.setVisible(false);
                autoReconnectUnit.setVisible(false);
            }
        });

        ButtonGroup certGroup = new ButtonGroup();
        certGroup.add(CASignedServerRadioButton);
        certGroup.add(selfSignedRadioButton);


        boolean selectSelfSigned = selfSignedRadioButton.isSelected();
        caFileField.setVisible(selectSelfSigned);
        caFile.setVisible(selectSelfSigned);
        clientFileField.setVisible(selectSelfSigned);
        clientCertFile.setVisible(selectSelfSigned);
        clientKeyFileField.setVisible(selectSelfSigned);
        clientKeyFile.setVisible(selectSelfSigned);

        selfSignedRadioButton.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                caFileField.setVisible(true);
                caFile.setVisible(true);
                clientFileField.setVisible(true);
                clientCertFile.setVisible(true);
                clientKeyFileField.setVisible(true);
                clientKeyFile.setVisible(true);
            } else {
                caFileField.setVisible(false);
                caFile.setVisible(false);
                clientFileField.setVisible(false);
                clientCertFile.setVisible(false);
                clientKeyFileField.setVisible(false);
                clientKeyFile.setVisible(false);
            }
        });

        ButtonGroup qosGroup = new ButtonGroup();
        qosGroup.add(qos0Field);
        qosGroup.add(qos1Field);
        qosGroup.add(qos2Field);

        ButtonGroup lastWillGroup = new ButtonGroup();
        lastWillGroup.add(payloadJson);
        lastWillGroup.add(payloadPlain);


        payloadJson.addActionListener(e -> formatJSON());

        // Test whether the broker can be connected.
        initTestConnectListeners();
    }

    private void initTestConnectListeners() {
        testConnectionButton.addActionListener(actionEvent -> {
            MqttServerConfiguration configuration = createServerConfigurationForTesting();

            final Ref<Exception> excRef = new Ref<>();
            final ProgressManager progressManager = ProgressManager.getInstance();
            progressManager.runProcessWithProgressSynchronously(() -> {

                final ProgressIndicator progressIndicator = progressManager.getProgressIndicator();
                if (progressIndicator != null) {
                    progressIndicator.setText("Connecting to MQTT server...");
                }
                try {
                } catch (Exception ex) {
                    excRef.set(ex);
                }
            }, "Testing Connection", true, MqttConfigurationPanel.this.project);

            if (!excRef.isNull()) {
                Messages.showErrorDialog(rootPanel, excRef.get().getMessage(), "Connection Test Failed");
            } else {
                Messages.showInfoMessage(rootPanel, "Connection test successful", "Connection Test Successful");
            }
        });
    }

    @NotNull
    private MqttServerConfiguration createServerConfigurationForTesting() {
        MqttServerConfiguration configuration = MqttServerConfiguration.byDefault();
        configuration.setHost(getHost());
        configuration.setPort(getPort());
        configuration.setUserName(getUsername());
        configuration.setPassword(getPassword());
        configuration.setMqttVersion(getMqttVersion());
        configuration.setConnectTime(getConnectTimeout());
        configuration.setSsl(getSslSecure());
        if (getCaSignedServer()) {
            configuration.setCertificate(1);
            return configuration;
        }
        if (getSelfSigned()) {
            configuration.setCertificate(2);
            configuration.setCaFile(getCaFile());
            configuration.setClientCertFile(getClientCertFile());
            configuration.setClientKeyFile(getClientCertFile());
            return configuration;
        }
        return configuration;
    }

    private void formatJSON() {
        String jsonString = lastWillPayload.getText();
        if (StringUtils.isNotBlank(jsonString)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Object json = objectMapper.readValue(jsonString, Object.class);
                String formattedJSON = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
                lastWillPayload.setText(formattedJSON);
                lastWillPayload.setForeground(Color.BLACK);
                lastWillPayload.setBorder(null);
            } catch (JsonProcessingException e) {
                lastWillPayload.setForeground(Color.BLACK);
                lastWillPayload.setBorder(new LineBorder(Color.RED));
            }
        }
    }

    public void loadConfigurationData(MqttServerConfiguration config) {
        mqttConfigName.setText(config.getConfigName());
        clientIdField.setText(config.getClientId());
        hostField.setText(config.getHost());
        portField.setText(config.getPort() + "");

    }

    public void applyConfigurationData(MqttServerConfiguration config) {
        validateConfigParam();

        config.setConfigName(getMqttConfigName());

    }

    private void validateConfigParam() {
        if (StringUtils.isBlank(getMqttConfigName())) {
            throw new ConfigurationException("config name should be set");
        }
        if (StringUtils.isBlank(getClientId())) {
            throw new ConfigurationException("client Id should be set");
        }
        if (StringUtils.isBlank(getHost())) {
            throw new ConfigurationException("host should be set");
        }
        Integer port = getPort();
        if (port < 0 || port > 65535) {
            throw new ConfigurationException(String.format("Port:%s is incorrect. It should between 0 and 65535", port));
        }
    }

    public void setErrorMessage(String message) {
        feedbackLabel.setIcon(FAIL);
        feedbackLabel.setText(message);

        // 3 seconds disappear
        Timer timer = new Timer(3000, e -> {
            feedbackLabel.setIcon(null);
            feedbackLabel.setText("");
        });
        timer.setRepeats(false);
        timer.start();
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public String getMqttConfigName() {
        String configName = mqttConfigName.getText();
        return StringUtils.isNotBlank(configName) ? configName : null;
    }

    public String getClientId() {
        String clientId = clientIdField.getText();
        return StringUtils.isNotBlank(clientId) ? clientId : null;
    }

    public String getHost() {
        String host = hostField.getText();
        return StringUtils.isNotBlank(host) ? host : null;
    }

    public Integer getPort() {
        String portString = portField.getText();
        Integer port = null;
        if (StringUtils.isBlank(portString)) {
            return port;
        }
        try {
            port = Integer.valueOf(portString);
        } catch (NumberFormatException e) {
            throw new ConfigurationException(String.format("Port:%s is incorrect. It should be a number", portString));
        }
        return port;
    }

    public String getUsername() {
        String username = usernameField.getText();
        return StringUtils.isNotBlank(username) ? username : null;
    }

    public String getPassword() {
        String password = passwordField.getText();
        return StringUtils.isNotBlank(password) ? password : null;
    }

    public String getMqttVersion() {
        Object mqttVersionObject = mqttVersionComboBox.getSelectedItem();
        return Objects.nonNull(mqttVersionObject) ? (String) mqttVersionObject : null;
    }

    public Integer getConnectTimeout() {
        Object connectTimeObject = connectTimeout.getValue();
        return Objects.nonNull(connectTimeObject) ? (Integer) connectTimeObject : null;
    }

    public Integer getKeepAlive() {
        Object keepAliveObject = keepAlive.getValue();
        return Objects.nonNull(keepAliveObject) ? (Integer) keepAliveObject : null;
    }

    public Boolean getAutoReconnect() {
        return autoReconnectCheckBox.isSelected();
    }

    public Integer getAutoReconnectTime() {
        Object autoReconnectTimeObject = autoReconnectTime.getValue();
        return Objects.nonNull(autoReconnectTimeObject) ? (Integer) autoReconnectTimeObject : null;
    }

    public Boolean getCleanSession() {
        return cleanSessionCheckBox.isSelected();
    }

    public Boolean getSslSecure() {
        return SSLSecureCheckBox.isSelected();
    }

    public Boolean getCaSignedServer() {
        return CASignedServerRadioButton.isSelected();
    }

    public Boolean getSelfSigned() {
        return selfSignedRadioButton.isSelected();
    }

    public String getCaFile() {
        String cafile = caFile.getText();
        return StringUtils.isNotBlank(cafile) ? cafile : "";
    }

    public String getClientCertFile() {
        String clientCert = clientCertFile.getText();
        return StringUtils.isNotBlank(clientCert) ? clientCert : "";
    }

    public String getClientKey() {
        String clientKey = clientKeyFile.getText();
        return StringUtils.isNotBlank(clientKey) ? clientKey : "";
    }

    public String lastWillTopic() {
        String lastWillTopic = lastWillTopicField.getText();
        return StringUtils.isNotBlank(lastWillTopic) ? lastWillTopic : "";
    }

    public Integer getLastWillQos() {
        if (qos0Field.isSelected()) {
            return 0;
        }
        if (qos1Field.isSelected()) {
            return 1;
        }
        if (qos2Field.isSelected()) {
            return 2;
        }
        return 0;
    }

    public Boolean getLastWillRetain() {
        return lastWillRetain.isSelected();
    }

    public String getLastWillPayload() {
        String lastWillPayloadData = lastWillPayload.getText();
        return StringUtils.isNotBlank(lastWillPayloadData) ? lastWillPayloadData : null;
    }

    private void createUIComponents() {
        SpinnerNumberModel connectTimeoutSpinnerModel = new SpinnerNumberModel(10, 0, Integer.MAX_VALUE, 1);
        connectTimeout = new JSpinner(connectTimeoutSpinnerModel);

        SpinnerNumberModel keepAliveSpinnerModel = new SpinnerNumberModel(60, 0, Integer.MAX_VALUE, 1);
        keepAlive = new JSpinner(keepAliveSpinnerModel);

        SpinnerNumberModel autoReconnectSpinnerModel = new SpinnerNumberModel(4000, 0, Integer.MAX_VALUE, 1);
        autoReconnectTime = new JSpinner(autoReconnectSpinnerModel);

    }
}
