package iot.technology.plugin.toolkit;

import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.*;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import iot.technology.plugin.toolkit.view.ToolkitExplorerWindowFactory;
import org.jetbrains.annotations.NotNull;


/**
 * @author mushuwei
 */
public class ToolkitToolsWindowManager implements ToolWindowFactory, DumbAware {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ContentFactory contentFactory = ContentFactory.getInstance();
        ToolkitExplorerWindowFactory window = new ToolkitExplorerWindowFactory(project, toolWindow);
        Content content = contentFactory.createContent(window.getContent(), "", false);
        toolWindow.getContentManager().addContent(content);

    }
}
