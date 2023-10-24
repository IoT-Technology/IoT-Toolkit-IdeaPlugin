package iot.technology.plugin.toolkit.view;

import com.intellij.ide.CommonActionsManager;
import com.intellij.ide.TreeExpander;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.LoadingDecorator;
import com.intellij.openapi.util.Disposer;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.treeStructure.Tree;
import com.intellij.util.ui.tree.TreeUtil;
import iot.technology.plugin.toolkit.ToolkitTreeRenderer;
import iot.technology.plugin.toolkit.action.DuplicateClientAction;
import iot.technology.plugin.toolkit.action.NewClientAction;
import iot.technology.plugin.toolkit.action.RefreshClientAction;
import iot.technology.plugin.toolkit.action.UpdateClientSettingsAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * @author mushuwei
 */
public class ToolkitExplorerWindow implements Disposable {

    private Project project;

    private JPanel mainPanel;
    private JPanel toolBarPanel;

    private JPanel containerPanel;
    private Tree clientTree;



    public ToolkitExplorerWindow(Project project) {
        this.project = project;

        containerPanel.setLayout(new BorderLayout());
        toolBarPanel.setLayout(new BorderLayout());

        clientTree = createTree();
        toolBarPanel.add(initToolBarActions(toolBarPanel).getComponent(), BorderLayout.NORTH);

        ApplicationManager.getApplication().invokeLater(() -> reloadAllToolkitClientConfigurations());
    }

    public JPanel getContent() {
        return mainPanel;
    }

    private Tree createTree() {
        Tree clientTree = new Tree();
        LoadingDecorator connectionTreeLoadingDecorator = new LoadingDecorator(new JBScrollPane(clientTree), this, 0);
        containerPanel.add(connectionTreeLoadingDecorator.getComponent(), BorderLayout.CENTER);
        clientTree.setCellRenderer(new ToolkitTreeRenderer());
        clientTree.setAlignmentX(Component.LEFT_ALIGNMENT);

        clientTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        return clientTree;
    }

    private void reloadAllToolkitClientConfigurations() {
        clientTree.setRootVisible(false);
        clientTree.setModel(null);
    }

    private ActionToolbar initToolBarActions(JComponent toolBarPanel) {

        final TreeExpander treeExpander = new TreeExpander() {
            @Override
            public void expandAll() {
                ToolkitExplorerWindow.this.expandAll();
            }

            @Override
            public boolean canExpand() {
                return true;
            }

            @Override
            public void collapseAll() {
                ToolkitExplorerWindow.this.collapseAll();
            }

            @Override
            public boolean canCollapse() {
                return true;
            }
        };

        CommonActionsManager actionsManager = CommonActionsManager.getInstance();
        final AnAction expandAllAction = actionsManager.createExpandAllAction(treeExpander, mainPanel);
        final AnAction collapseAllAction = actionsManager.createCollapseAllAction(treeExpander, mainPanel);

        Disposer.register(this, () -> {
            collapseAllAction.unregisterCustomShortcutSet(mainPanel);
            expandAllAction.unregisterCustomShortcutSet(mainPanel);
        });

        DefaultActionGroup actionsGroup = new DefaultActionGroup("ToolkitExplorerGroup", false);
        RefreshClientAction refreshClientAction = new RefreshClientAction(this);
        NewClientAction newClientAction = new NewClientAction(this);
        DuplicateClientAction duplicateClientAction = new DuplicateClientAction(this);
        UpdateClientSettingsAction updateClientSettingsAction = new UpdateClientSettingsAction(this);
        actionsGroup.add(refreshClientAction);
        actionsGroup.addSeparator();

        actionsGroup.add(newClientAction);
        actionsGroup.add(updateClientSettingsAction);
        actionsGroup.add(duplicateClientAction);
        actionsGroup.addSeparator();

        actionsGroup.add(expandAllAction);
        actionsGroup.add(collapseAllAction);

        ActionToolbar actionToolbar = ActionManager.getInstance()
                .createActionToolbar("ToolkitExplorerActions", actionsGroup, true);
        actionToolbar.setTargetComponent(toolBarPanel);
        actionToolbar.adjustTheSameSize(true);
        return actionToolbar;
    }

    private void expandAll() {
        TreeUtil.expandAll(clientTree);
    }

    private void collapseAll() {
        TreeUtil.collapseAll(clientTree, 1);
    }

    @Override
    public void dispose() {

    }
}
