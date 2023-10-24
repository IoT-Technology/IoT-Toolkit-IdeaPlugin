package iot.technology.plugin.toolkit.common.action;

import com.intellij.openapi.actionSystem.AnAction;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author mushuwei
 */
public abstract class BasicAction extends AnAction {

    public BasicAction() {
    }

    public BasicAction(@Nullable Icon icon) {
        super(icon);
    }

    public BasicAction(@Nullable String text) {
        super(text);
    }

    public BasicAction(@Nullable String text, @Nullable String description, @Nullable Icon icon) {
        super(text, description, icon);
    }
}
