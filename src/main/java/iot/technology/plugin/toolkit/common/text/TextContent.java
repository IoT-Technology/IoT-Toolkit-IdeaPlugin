package iot.technology.plugin.toolkit.common.text;

import lombok.Data;

@Data
public class TextContent {
    public static TextContent EMPTY_PLAIN_TEXT = TextContent.plain("");

    private final String text;
    private final MimeType type;

    public String getTypeId() {
        return type.id();
    }

    public static TextContent plain(String text) {
        return new TextContent(text, MimeType.TEXT_PLAIN);
    }

    public static TextContent html(String text) {
        return new TextContent(text, MimeType.TEXT_HTML);
    }

    public static TextContent xml(String text) {
        return new TextContent(text, MimeType.TEXT_XML);
    }

    public static TextContent css(String text) {
        return new TextContent(text, MimeType.TEXT_CSS);
    }
}
