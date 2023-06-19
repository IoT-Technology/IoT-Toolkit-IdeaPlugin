package iot.technology.plugin.toolkit.commons.logic;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author mushuwei
 */
public class MqttConfigurationDialog extends DialogWrapper {

    public final Project project;

    public MqttConfigurationDialog(@Nullable Project project) {
        super(project, true);
        this.project = project;

        setTitle("MQTT Configuration");
        setResizable(false);

        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return null;
    }
}
