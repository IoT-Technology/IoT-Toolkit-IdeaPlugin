package iot.technology.plugin.toolkit.common.logic;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author mushuwei
 */
public class CoapConfigurationDialog extends DialogWrapper {

    public final Project project;

    public CoapConfigurationDialog(@Nullable Project project) {
        super(project, true);
        this.project = project;

        setTitle("CoAP Configuration");
        setResizable(false);

        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return null;
    }
}
