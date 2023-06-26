package iot.technology.plugin.toolkit.commons.logic;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import iot.technology.plugin.toolkit.commons.utils.ConfigurationException;
import iot.technology.plugin.toolkit.mqtt.MqttConfigurationPanel;
import iot.technology.plugin.toolkit.mqtt.model.MqttServerConfiguration;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author mushuwei
 */
public class MqttConfigurationDialog extends DialogWrapper implements Disposable {

    public final Project project;
    private MqttServerConfiguration serverConfiguration;
    private MqttConfigurationPanel mqttConfigurationPanel;

    public MqttConfigurationDialog(@Nullable Project project, MqttServerConfiguration serverConfiguration) {
        super(project, true);
        this.project = project;
        this.serverConfiguration = serverConfiguration;

        mqttConfigurationPanel = new MqttConfigurationPanel(project);
        mqttConfigurationPanel.loadConfigurationData(serverConfiguration);
        setTitle("MQTT Configuration");
        setResizable(false);
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return mqttConfigurationPanel.getRootPanel();
    }

    @Override
    protected void doOKAction() {
        try {
            mqttConfigurationPanel.applyConfigurationData(serverConfiguration);
            super.doOKAction();
        } catch (ConfigurationException confEx) {
            mqttConfigurationPanel.setErrorMessage(confEx.getMessage());
        }
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
