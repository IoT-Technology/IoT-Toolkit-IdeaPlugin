package iot.technology.plugin.toolkit.mqtt;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;

import javax.swing.*;

/**
 * @author mushuwei
 */
public class MqttConfigurationPanel extends JPanel {

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
    private JTextField hostField;
    private JTextField portField;
    private JComboBox AuthenticationComboBox;
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
    private JCheckBox cleanSessionCheckBox;

    /**
     * mqtt config ssl/tls configuration
     */
    private JCheckBox SSLSecureCheckBox;
    private JRadioButton CASignedServerRadioButton;
    private JRadioButton selfSignedRadioButton;
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

    private JButton testConnectionButton;

    private final Project project;

    MqttConfigurationPanel(Project project) {
        this.project = project;
    }

    public void loadConfigurationData() {

    }


}
