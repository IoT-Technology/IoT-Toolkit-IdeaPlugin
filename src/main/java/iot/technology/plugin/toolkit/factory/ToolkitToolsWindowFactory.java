package iot.technology.plugin.toolkit.factory;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.*;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import iot.technology.plugin.toolkit.view.ToolkitExplorerWindow;
import org.jetbrains.annotations.NotNull;


/**
 * @author mushuwei
 */
public class ToolkitToolsWindowFactory implements ToolWindowFactory, DumbAware {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ToolkitExplorerWindow window = new ToolkitExplorerWindow(project);
        ContentFactory contentFactory = ApplicationManager.getApplication().getService(ContentFactory.class);
        Content content = contentFactory.createContent(window.getContent(), "", false);
        toolWindow.getContentManager().addContent(content);

    }
}
