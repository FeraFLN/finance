package com.ferafln.finance.util;

import java.util.Locale;

public enum LangEnum {
    BR (new Locale("pt_BR")),
    US (Locale.US);

    private final Locale locale;

    LangEnum(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return locale;
    }
}
