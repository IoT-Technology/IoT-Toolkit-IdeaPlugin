package iot.technology.plugin.toolkit.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAware;
import iot.technology.plugin.toolkit.ToolkitExplorerWindowFactory;
import iot.technology.plugin.toolkit.commons.ToolkitIcons;
import org.jetbrains.annotations.NotNull;

/**
 * @author mushuwei
 */
public class UpdateClientSettingsAction extends AnAction implements DumbAware {

    private final ToolkitExplorerWindowFactory toolkitExplorerWindowFactory;

    public UpdateClientSettingsAction(ToolkitExplorerWindowFactory toolkitExplorerWindowFactory) {
        super("Update", "Update IoT Toolkit Client Settings", ToolkitIcons.Tool.settings);
        this.toolkitExplorerWindowFactory = toolkitExplorerWindowFactory;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

    }
}
