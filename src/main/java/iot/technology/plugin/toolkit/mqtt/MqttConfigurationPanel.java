package iot.technology.plugin.toolkit.mqtt;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import iot.technology.plugin.toolkit.commons.utils.AuthenticationEnum;
import iot.technology.plugin.toolkit.commons.utils.MqttVersionEnum;

import javax.swing.*;
import java.awt.event.ItemEvent;

/**
 * @author mushuwei
 */
@SuppressWarnings("unchecked")
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

    private JButton testConnectionButton;

    private final Project project;

    public MqttConfigurationPanel(Project project) {
        this.project = project;

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

    }

    public void loadConfigurationData() {

    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JLabel getFeedbackLabel() {
        return feedbackLabel;
    }

    public JTextField getMqttConfigName() {
        return mqttConfigName;
    }

    public JTabbedPane getSettingTabbedPane() {
        return settingTabbedPane;
    }

    public JTextField getClientIdField() {
        return clientIdField;
    }

    public JTextField getHostField() {
        return hostField;
    }

    public JTextField getPortField() {
        return portField;
    }

    public JComboBox getAuthenticationComboBox() {
        return authenticationComboBox;
    }

    public JLabel getUserlabel() {
        return userlabel;
    }

    public JLabel getPasslabel() {
        return passlabel;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public JComboBox getMqttVersionComboBox() {
        return mqttVersionComboBox;
    }

    public JSpinner getConnectTimeout() {
        return connectTimeout;
    }

    public JSpinner getKeepAlive() {
        return keepAlive;
    }

    public JCheckBox getAutoReconnectCheckBox() {
        return autoReconnectCheckBox;
    }

    public JSpinner getAutoReconnectTime() {
        return autoReconnectTime;
    }

    public JCheckBox getCleanSessionCheckBox() {
        return cleanSessionCheckBox;
    }

    public JCheckBox getSSLSecureCheckBox() {
        return SSLSecureCheckBox;
    }

    public JRadioButton getCASignedServerRadioButton() {
        return CASignedServerRadioButton;
    }

    public JRadioButton getSelfSignedRadioButton() {
        return selfSignedRadioButton;
    }

    public TextFieldWithBrowseButton getCaFile() {
        return caFile;
    }

    public TextFieldWithBrowseButton getClientCertFile() {
        return clientCertFile;
    }

    public TextFieldWithBrowseButton getClientKeyFile() {
        return clientKeyFile;
    }

    public JTextField getLastWillTopicField() {
        return lastWillTopicField;
    }

    public JRadioButton getQos0Field() {
        return qos0Field;
    }

    public JRadioButton getQos1Field() {
        return qos1Field;
    }

    public JRadioButton getQos2Field() {
        return qos2Field;
    }

    public JCheckBox getLastWillRetain() {
        return lastWillRetain;
    }

    public JTextArea getLastWillPayload() {
        return lastWillPayload;
    }

    public JRadioButton getPayloadJson() {
        return payloadJson;
    }

    public JRadioButton getPayloadPlain() {
        return payloadPlain;
    }

    public JButton getTestConnectionButton() {
        return testConnectionButton;
    }

    public JLabel getAutoReconnectUnit() {
        return autoReconnectUnit;
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
