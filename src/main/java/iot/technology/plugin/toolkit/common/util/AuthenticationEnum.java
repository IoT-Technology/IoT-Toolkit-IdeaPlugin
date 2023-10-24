package iot.technology.plugin.toolkit.common.util;

/**
 * @author mushuwei
 */
public enum AuthenticationEnum {

    USER_AND_PASSWORD("User & Password"),

    NO_AUTH("No Auth");

    private String label;


    public static String[] getLabels() {
        String[] labels = new String[AuthenticationEnum.values().length];
        AuthenticationEnum[] authentications = AuthenticationEnum.values();
        for (int i = 0; i < authentications.length; i++) {
            labels[i] = authentications[i].getLabel();
        }
        return labels;
    }

    AuthenticationEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
