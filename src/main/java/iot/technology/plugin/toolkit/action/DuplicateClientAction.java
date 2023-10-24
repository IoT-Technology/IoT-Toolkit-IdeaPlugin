package iot.technology.plugin.toolkit.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAware;
import iot.technology.plugin.toolkit.common.util.ToolkitIcons;
import iot.technology.plugin.toolkit.view.ToolkitExplorerWindow;
import org.jetbrains.annotations.NotNull;

/**
 * @author mushuwei
 */
public class DuplicateClientAction extends AnAction implements DumbAware {

    private final ToolkitExplorerWindow toolkitExplorerWindow;

    public DuplicateClientAction(ToolkitExplorerWindow toolkitExplorerWindow) {
        super("Duplicate", "Duplicate Client Configuration", ToolkitIcons.Tool.copy);
        this.toolkitExplorerWindow = toolkitExplorerWindow;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

    }
}
