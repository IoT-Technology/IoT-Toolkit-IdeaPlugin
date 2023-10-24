package iot.technology.plugin.toolkit.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAware;
import iot.technology.plugin.toolkit.view.ToolkitExplorerWindow;
import iot.technology.plugin.toolkit.common.util.ToolkitIcons;
import org.jetbrains.annotations.NotNull;

/**
 * @author mushuwei
 */
public class UpdateClientSettingsAction extends AnAction implements DumbAware {

    private final ToolkitExplorerWindow toolkitExplorerWindow;

    public UpdateClientSettingsAction(ToolkitExplorerWindow toolkitExplorerWindow) {
        super("Update", "Update IoT Toolkit Client Settings", ToolkitIcons.Tool.settings);
        this.toolkitExplorerWindow = toolkitExplorerWindow;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

    }
}
