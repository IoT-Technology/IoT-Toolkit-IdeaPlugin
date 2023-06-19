package iot.technology.plugin.toolkit.commons.utils;

import javax.swing.*;

/**
 * @author mushuwei
 */
public enum ToolkitProtocolVendorEnum {

    MQTT("mqtt", "MQTT", ToolkitIcons.Vendor.mqtt32),

    COAP("coap", "CoAP", ToolkitIcons.Vendor.coap32),

    DEFAULT("mqtt", "MQTT", ToolkitIcons.Vendor.mqtt32);


    ToolkitProtocolVendorEnum(String code, String desc, Icon icon) {
        this.code = code;
        this.desc = desc;
        this.icon = icon;
    }

    private String code;

    private String desc;

    private Icon icon;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public Icon getIcon() {
        return icon;
    }
}
