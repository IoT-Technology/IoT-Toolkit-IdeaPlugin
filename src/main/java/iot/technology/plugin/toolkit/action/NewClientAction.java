package iot.technology.plugin.toolkit.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAware;
import iot.technology.plugin.toolkit.commons.ToolkitIcons;
import iot.technology.plugin.toolkit.view.ToolkitExplorerWindowFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @author mushuwei
 */
public class NewClientAction extends AnAction implements DumbAware {

    private final ToolkitExplorerWindowFactory toolkitExplorerWindowFactory;

    public NewClientAction(ToolkitExplorerWindowFactory toolkitExplorerWindowFactory) {
        super("New", "Add a IoT Protocol Client", ToolkitIcons.Tool.add);
        this.toolkitExplorerWindowFactory = toolkitExplorerWindowFactory;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

    }
}
