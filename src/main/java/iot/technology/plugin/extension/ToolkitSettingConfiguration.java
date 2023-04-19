package iot.technology.plugin.extension;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author mushuwei
 */
public class ToolkitSettingConfiguration implements Configurable {

	@Override
	public @NlsContexts.ConfigurableName String getDisplayName() {
		return "IoT Toolkit";
	}

	@Override
	public @Nullable JComponent createComponent() {
		return null;
	}

	@Override
	public boolean isModified() {
		return true;
	}

	@Override
	public void apply() throws ConfigurationException {

	}
}
