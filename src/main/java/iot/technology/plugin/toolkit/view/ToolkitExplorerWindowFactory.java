package iot.technology.plugin.toolkit.view;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import iot.technology.plugin.toolkit.action.DuplicateClientAction;
import iot.technology.plugin.toolkit.action.NewClientAction;
import iot.technology.plugin.toolkit.action.RefreshClientAction;

import javax.swing.*;
import java.awt.*;


/**
 * @author mushuwei
 */
public class ToolkitExplorerWindowFactory implements Disposable {

    private JPanel mainPanel;
    private JPanel toolBarPanel;
    private JPanel containerPanel;

    private final Project project;

    public ToolkitExplorerWindowFactory(Project project, ToolWindow toolWindow) {
        this.project = project;

        toolBarPanel.setLayout(new BorderLayout());
        containerPanel.setLayout(new BorderLayout());

        toolBarPanel.add(initToolBarActions(toolBarPanel).getComponent(), BorderLayout.NORTH);
    }

    public JPanel getContent() {
        return mainPanel;
    }


    private ActionToolbar initToolBarActions(JComponent toolBarPanel) {
        DefaultActionGroup actionsGroup = new DefaultActionGroup("ToolkitExplorerGroup", false);
        RefreshClientAction refreshClientAction = new RefreshClientAction(this);
        NewClientAction newClientAction = new NewClientAction(this);
        DuplicateClientAction duplicateClientAction = new DuplicateClientAction(this);
        actionsGroup.add(newClientAction);
        actionsGroup.add(duplicateClientAction);
        actionsGroup.addSeparator();
        actionsGroup.add(refreshClientAction);

        ActionToolbar actionToolbar = ActionManager.getInstance()
                .createActionToolbar("ToolkitExplorerActions", actionsGroup, true);
        actionToolbar.setTargetComponent(toolBarPanel);
        actionToolbar.adjustTheSameSize(true);
        return actionToolbar;
    }


    @Override
    public void dispose() {

    }
}
