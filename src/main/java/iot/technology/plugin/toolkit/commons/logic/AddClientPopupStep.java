package iot.technology.plugin.toolkit.commons.logic;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.PopupStep;
import com.intellij.openapi.ui.popup.util.BaseListPopupStep;
import iot.technology.plugin.toolkit.DemoKtBasicsKt;
import iot.technology.plugin.toolkit.commons.utils.ToolkitProtocolVendor;
import iot.technology.plugin.toolkit.mqtt.model.MqttServerConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;


/**
 * @author mushuwei
 */
public class AddClientPopupStep extends BaseListPopupStep<String> {

    public static String selectedOption = ToolkitProtocolVendor.MQTT.getCode();
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
        if (selectedOption.equals(ToolkitProtocolVendor.MQTT.getCode())) {
            MqttServerConfiguration serverConfiguration = MqttServerConfiguration.byDefault();
            MqttConfigurationDialog mqttConfigDialog = new MqttConfigurationDialog(project, serverConfiguration);
            mqttConfigDialog.show();
        }
        if (selectedOption.equals(ToolkitProtocolVendor.COAP.getCode())) {
            CoapConfigurationDialog coapConfigDialog = new CoapConfigurationDialog(project);
            coapConfigDialog.show();
        }
        return super.getFinalRunnable();
    }

    @Override
    public Icon getIconFor(String value) {
        if (value.equals(ToolkitProtocolVendor.MQTT.getCode())) {
            return ToolkitProtocolVendor.MQTT.getIcon();
        }
        if (value.equals(ToolkitProtocolVendor.COAP.getCode())) {
            return ToolkitProtocolVendor.COAP.getIcon();
        }
        return ToolkitProtocolVendor.DEFAULT.getIcon();
    }

    @Override
    public @NotNull String getTextFor(String value) {
        if (value.equals(ToolkitProtocolVendor.MQTT.getCode())) {
            return ToolkitProtocolVendor.MQTT.getDesc();
        }
        if (value.equals(ToolkitProtocolVendor.COAP.getCode())) {
            return ToolkitProtocolVendor.COAP.getDesc();
        }
        return ToolkitProtocolVendor.DEFAULT.getDesc();
    }

}
