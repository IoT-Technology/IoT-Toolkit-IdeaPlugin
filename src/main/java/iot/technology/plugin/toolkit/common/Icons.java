package iot.technology.plugin.toolkit.common;

import com.intellij.openapi.util.ScalableIcon;
import com.intellij.ui.RowIcon;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.util.IconLoader.findIcon;

/**
 * @author mushuwei
 */
@Slf4j
@UtilityClass
public class Icons {
    private static final Map<String, Icon> REGISTERED_ICONS = new HashMap<>();

    public static final Icon PROTOCOL_MQTT = load("/img/protocol/mqtt.png");
    public static final Icon PROTOCOL_COAP = load("/img/protocol/coap.png");
    public static final Icon PROTOCOL_LWM2M = load("/img/protocol/lwm2m.png");
    public static final Icon PROTOCOL_AEP = load("/img/protocol/aep.png");
    public static final Icon PROTOCOL_ONENET = load("/img/protocol/onenet.png");

    private static Icon load(String path) {
        ClassLoader classLoader = Icons.class.getClassLoader();
        String svgPath = path.replace(".png", ".svg");

        try {
            Icon icon = findIcon(svgPath, classLoader);
            if (icon != null && icon.getIconWidth() > 1) return icon;
        } catch (Throwable t) {
            log.error("Failed to load icon {}", svgPath, t);
        }

        return findIcon(path, classLoader);
    }

    public static Icon scaleToWidth(Icon icon, float newWidth) {
        if (icon instanceof ScalableIcon) {
            ScalableIcon scalableIcon = (ScalableIcon) icon;

            int iconWidth = scalableIcon.getIconWidth();
            if (newWidth != iconWidth) {
                return scalableIcon.scale(newWidth / iconWidth);
            }
        }
        return icon;
    }

    private static Icon load(String key, String path) {
        Icon icon = load(path);
        REGISTERED_ICONS.put(key, icon);
        return icon;
    }

    public static Icon getIcon(String key) {
        return REGISTERED_ICONS.get(key);
    }

    private static Icon createRowIcon(Icon left, Icon right) {
        RowIcon rowIcon = new RowIcon(2);
        rowIcon.setIcon(left, 0);
        rowIcon.setIcon(right, 1);
        return rowIcon;
    }

}
