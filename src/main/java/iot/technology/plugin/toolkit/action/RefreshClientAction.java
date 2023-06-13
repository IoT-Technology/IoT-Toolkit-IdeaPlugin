package iot.technology.plugin.toolkit.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAware;
import iot.technology.plugin.toolkit.commons.ToolkitIcons;
import iot.technology.plugin.toolkit.ToolkitExplorerWindowFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @author mushuwei
 */
public class RefreshClientAction extends AnAction implements DumbAware {

    private static final String REFRESH_TEXT = "Refresh this client";

    private final ToolkitExplorerWindowFactory toolkitExplorerWindowFactory;

    public RefreshClientAction(ToolkitExplorerWindowFactory toolkitExplorerWindowFactory) {
        super("Refresh", REFRESH_TEXT, ToolkitIcons.Tool.refresh);
        this.toolkitExplorerWindowFactory = toolkitExplorerWindowFactory;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        super.update(e);
    }
}
