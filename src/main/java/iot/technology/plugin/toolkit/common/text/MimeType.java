package iot.technology.plugin.toolkit.common.text;

import iot.technology.plugin.toolkit.common.constant.Constant;

public enum MimeType implements Constant<MimeType> {
    TEXT_PLAIN("text/plain"),
    TEXT_HTML("text/html"),
    TEXT_XML("text/xml"),
    TEXT_CSS("text/css")
    //...
    ;

    private final String id;

    MimeType(String id) {
        this.id = id;
    }

    @Override
    public String id() {
        return id;
    }
}
