package com.ferafln.finance.message;

public enum Message {
    FORBIDDEN(Constants.FORBIDDEN),
    FIRSTNAME_REQUIRED(Constants.FIRSTNAME_REQUIRED),
    LASTNAME_REQUIRED(Constants.LASTNAME_REQUIRED),
    USERNAME_REQUIRED(Constants.USERNAME_REQUIRED),
    PASSWORD_REQUIRED(Constants.PASSWORD_REQUIRED),
    EMAIL_REQUIRED(Constants.EMAIL_REQUIRED),
    LANGUAGE_REQUIRED(Constants.LANGUAGE_REQUIRED),
    ROLE_REQUIRED(Constants.ROLE_REQUIRED),
    ACCOUNT_REQUIRED(Constants.ACCOUNT_REQUIRED),
    INVALID_PASSWORD(Constants.INVALID_PASSWORD),
    ACCESS_DENIED(Constants.ACCESS_DENIED),
    USER_OR_PASSWORD_INVALID(Constants.USER_OR_PASSWORD_INVALID),
    UNIQUE_USERNAME(Constants.UNIQUE_USERNAME);

    private final String code;

    Message(String code) {
        this.code = code;
    }

    public final String getCode() {
        return code;
    }

    public static class Constants {
        public static final String FORBIDDEN = "error.forbidden.userorpassword.invalid";
        public static final String FIRSTNAME_REQUIRED = "error.firstname.mandatory";
        public static final String LASTNAME_REQUIRED = "error.lastname.mandatory";
        public static final String USERNAME_REQUIRED = "error.username.mandatory";
        public static final String PASSWORD_REQUIRED = "error.password.mandatory";
        public static final String EMAIL_REQUIRED = "error.email.mandatory";
        public static final String LANGUAGE_REQUIRED = "error.language.mandatory";
        public static final String ROLE_REQUIRED = "error.role.mandatory";
        public static final String ACCOUNT_REQUIRED = "error.expenseaccaountname.mandatory";
        public static final String INVALID_PASSWORD = "error.password.invalidpattern";
        public static final String ACCESS_DENIED = "error.forbidden.accessdenied";
        public static final String USER_OR_PASSWORD_INVALID = "error.forbidden.userorpassword.invalid";
        public static final String UNIQUE_USERNAME = "error.unique.username";

    }
}
