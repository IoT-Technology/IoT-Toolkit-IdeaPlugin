package iot.technology.plugin.toolkit.commons.logic;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.PopupStep;
import com.intellij.openapi.ui.popup.util.BaseListPopupStep;
import iot.technology.plugin.toolkit.commons.utils.ToolkitProtocolVendorEnum;
import iot.technology.plugin.toolkit.mqtt.model.MqttServerConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;


/**
 * @author mushuwei
 */
public class AddClientPopupStep extends BaseListPopupStep<String> {

    public static String selectedOption = ToolkitProtocolVendorEnum.MQTT.getCode();
    public  final Project project;
    public final CoapConfigurationDialog coapConfigDialog;

    public AddClientPopupStep(Project project, List<String> labels) {
        super("Supported Protocol", labels);
        this.project = project;
        this.coapConfigDialog = new CoapConfigurationDialog(project);
    }

    @Override
    public PopupStep onChosen(String selectedValue, boolean finalChoice) {
        selectedOption = selectedValue;
        return FINAL_CHOICE;
    }


    @Override
    public @Nullable Runnable getFinalRunnable() {
        if (selectedOption.equals(ToolkitProtocolVendorEnum.MQTT.getCode())) {
            MqttServerConfiguration serverConfiguration = MqttServerConfiguration.byDefault();
            MqttConfigurationDialog mqttConfigDialog = new MqttConfigurationDialog(project, serverConfiguration);
            mqttConfigDialog.show();
        }
        if (selectedOption.equals(ToolkitProtocolVendorEnum.COAP.getCode())) {
            CoapConfigurationDialog coapConfigDialog = new CoapConfigurationDialog(project);
            coapConfigDialog.show();
        }
        return super.getFinalRunnable();
    }

    @Override
    public Icon getIconFor(String value) {
        if (value.equals(ToolkitProtocolVendorEnum.MQTT.getCode())) {
            return ToolkitProtocolVendorEnum.MQTT.getIcon();
        }
        if (value.equals(ToolkitProtocolVendorEnum.COAP.getCode())) {
            return ToolkitProtocolVendorEnum.COAP.getIcon();
        }
        return ToolkitProtocolVendorEnum.DEFAULT.getIcon();
    }

    @Override
    public @NotNull String getTextFor(String value) {
        if (value.equals(ToolkitProtocolVendorEnum.MQTT.getCode())) {
            return ToolkitProtocolVendorEnum.MQTT.getDesc();
        }
        if (value.equals(ToolkitProtocolVendorEnum.COAP.getCode())) {
            return ToolkitProtocolVendorEnum.COAP.getDesc();
        }
        return ToolkitProtocolVendorEnum.DEFAULT.getDesc();
    }

}
