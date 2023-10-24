package iot.technology.plugin.toolkit.common.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Nullable;

/**
 * @author mushuwei
 */
@UtilityClass
public class Lookups {

    @Nullable
    public static Project getProject(AnActionEvent e) {
        return e.getData(PlatformDataKeys.PROJECT);
    }
}
