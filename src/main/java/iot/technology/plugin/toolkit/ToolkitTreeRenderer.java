package iot.technology.plugin.toolkit;

import com.intellij.icons.AllIcons;
import com.intellij.ui.ColoredTreeCellRenderer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * @author mushuwei
 */
public class ToolkitTreeRenderer extends ColoredTreeCellRenderer {

    @Override
    public void customizeCellRenderer(@NotNull JTree tree, Object value,
                                      boolean selected, boolean expanded,
                                      boolean leaf, int row, boolean hasFocus) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        TreeNode[] path = node.getPath();
        // 节点名
        this.append(node.toString());
        // 节点图标
        if (path.length == 2) {
            this.setIcon(AllIcons.Debugger.Db_db_object);
        } else {
            this.setIcon(AllIcons.Debugger.Db_array);
        }

    }
}
