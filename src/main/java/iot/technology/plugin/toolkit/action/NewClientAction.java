package iot.technology.plugin.toolkit.action;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.ui.popup.*;
import iot.technology.plugin.toolkit.view.ToolkitExplorerWindow;
import iot.technology.plugin.toolkit.common.util.ToolkitIcons;
import iot.technology.plugin.toolkit.common.logic.AddClientPopupStep;
import iot.technology.plugin.toolkit.common.util.ToolkitProtocolVendor;
import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.ui.popup.ListPopup;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;



/**
 * @author mushuwei
 */
public class NewClientAction extends AnAction implements DumbAware {

    private final ToolkitExplorerWindow toolkitExplorerWindow;

    public NewClientAction(ToolkitExplorerWindow toolkitExplorerWindow) {
        super("New", "Add a IoT protocol client", ToolkitIcons.Tool.add);
        this.toolkitExplorerWindow = toolkitExplorerWindow;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        List<String> vendors = new ArrayList<>();
        vendors.add(ToolkitProtocolVendor.MQTT.getCode());
        vendors.add(ToolkitProtocolVendor.COAP.getCode());

        // 创建列表弹出菜单步骤
        ListPopupStep<String> step = new AddClientPopupStep(e.getProject(), vendors);

        // 创建列表弹出菜单
        ListPopup popup = JBPopupFactory.getInstance().createListPopup(step);

        // 设置弹出窗口大小
        Dimension popupSize = new Dimension(100, 100);
        popup.setSize(popupSize);

        // 设置弹出位置
        popup.showUnderneathOf(e.getInputEvent().getComponent());

    }

}
