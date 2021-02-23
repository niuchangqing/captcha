package org.ncq.captcha.enums;

public enum LanguageEnum implements ILanguage {
    /**
     * 中文
     */
    ZH,
    /**
     * 英语
     */
    EN,
    /**
     * 日语
     */
    JA,
    /**
     * 俄语
     */
    RU,
    ;

    @Override
    public String getName() {
        return this.name();
    }
}
