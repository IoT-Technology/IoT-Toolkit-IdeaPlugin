package iot.technology.plugin.toolkit.commons.logic;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
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

    public MqttConfigurationDialog(@Nullable Project project, MqttServerConfiguration serverConfiguration) {
        super(project, true);
        this.project = project;
        this.serverConfiguration = serverConfiguration;
        setTitle("MQTT Configuration");
        setResizable(false);
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        MqttConfigurationPanel panel = new MqttConfigurationPanel(project);
        panel.loadConfigurationData(serverConfiguration);
        return panel.getRootPanel();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
