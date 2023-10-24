package iot.technology.plugin.toolkit.protocol;

import iot.technology.plugin.toolkit.common.Icons;
import iot.technology.plugin.toolkit.common.constant.Constant;
import iot.technology.plugin.toolkit.common.ui.Presentable;
import lombok.Getter;

import javax.swing.*;

/**
 * @author mushuwei
 */
@Getter
public enum ProtocolType implements Constant<ProtocolType>, Presentable {

    MQTT("MQTT", Icons.PROTOCOL_MQTT),
    COAP("CoAP", Icons.PROTOCOL_COAP),
    LWM2M("LwM2M", Icons.PROTOCOL_LWM2M),
    AEP("China Telecom", Icons.PROTOCOL_AEP),
    ONENET("China Mobile", Icons.PROTOCOL_ONENET)
    ;

    private final String name;
    private final Icon icon;

    ProtocolType(String name, Icon icon) {
        this.name = name;
        this.icon = icon;
    }

    private static ProtocolType strongMatch(String identifier) {
        identifier = identifier == null ? "" : identifier.toUpperCase();
        if (identifier.contains("MQTT")) {
            return ProtocolType.MQTT;
        } else if (identifier.contains("COAP")) {
            return ProtocolType.COAP;
        } else if (identifier.contains("LwM2M")) {
            return ProtocolType.LWM2M;
        } else if (identifier.contains("AEP")) {
            return ProtocolType.AEP;
        } else if (identifier.contains("ONENET")) {

        }
        return MQTT;
    }
}
