package com.dpelluzi.dynamicform.util;


import com.dpelluzi.dynamicform.models.Cell;

import java.util.regex.Pattern;

public abstract class FieldValidator {

    public static FieldValidator getInstance(@Cell.FieldType int fieldType) {
        FieldValidator validator;

        switch (fieldType) {
            case Cell.FieldType.TEXT:
                validator = new TextFieldValidator();
                break;
            case Cell.FieldType.EMAIL:
                validator = new EmailFieldValidator();
                break;
            case Cell.FieldType.TEL_NUMBER:
                validator = new PhoneFieldValidator();
                break;
            default:
                validator = null;
        }

        return validator;
    }

    public abstract boolean validate(String input);

    private static class TextFieldValidator extends FieldValidator {

        @Override
        public boolean validate(String input) {
            return input != null && input.trim().length() > 0;
        }
    }

    private static class EmailFieldValidator extends FieldValidator {

        private static final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        @Override
        public boolean validate(String input) {
            return  Pattern.compile(EMAIL_PATTERN).matcher(input).matches();
        }
    }

    private static class PhoneFieldValidator extends FieldValidator {

        private static final String PHONE_PATTERN = "\\(\\d{2}\\)\\s\\d{4,5}\\-\\d{4}";

        @Override
        public boolean validate(String input) {
            return Pattern.compile(PHONE_PATTERN).matcher(input).matches();
        }
    }
}
