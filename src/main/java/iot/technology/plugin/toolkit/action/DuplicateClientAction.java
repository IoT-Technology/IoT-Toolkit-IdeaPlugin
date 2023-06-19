package iot.technology.plugin.toolkit.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAware;
import iot.technology.plugin.toolkit.commons.utils.ToolkitIcons;
import iot.technology.plugin.toolkit.ToolkitExplorerWindowFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @author mushuwei
 */
public class DuplicateClientAction extends AnAction implements DumbAware {

    private final ToolkitExplorerWindowFactory toolkitExplorerWindowFactory;

    public DuplicateClientAction(ToolkitExplorerWindowFactory toolkitExplorerWindowFactory) {
        super("Duplicate", "Duplicate Client Configuration", ToolkitIcons.Tool.copy);
        this.toolkitExplorerWindowFactory = toolkitExplorerWindowFactory;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

    }
}
