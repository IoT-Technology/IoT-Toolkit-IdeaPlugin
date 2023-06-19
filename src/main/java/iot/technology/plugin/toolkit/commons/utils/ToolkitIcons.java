package iot.technology.plugin.toolkit.commons.utils;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

/**
 * @author mushuwei
 */
public class ToolkitIcons {

    public static final class Tool {

        public static final Icon add = AllIcons.General.Add;

        public static final Icon refresh = AllIcons.Actions.Refresh;

        public static final Icon copy = AllIcons.Actions.Copy;

        public static final Icon settings = AllIcons.General.Settings;
    }

    public static final class Vendor {

        public static final Icon mqtt = IconLoader.getIcon("/icons/mqtt.png", ToolkitIcons.class);

        public static final Icon mqtt32 = IconLoader.getIcon("/icons/mqtt-32.png", ToolkitIcons.class);

        public static final Icon mqtt64 = IconLoader.getIcon("/icons/mqtt-64.png", ToolkitIcons.class);

        public static final Icon coap = IconLoader.getIcon("/icons/coap.png", ToolkitIcons.class);

        public static final Icon coap32 = IconLoader.getIcon("/icons/coap-32.png", ToolkitIcons.class);

        public static final Icon coap64 = IconLoader.getIcon("/icons/coap-64.png", ToolkitIcons.class);
    }
}
