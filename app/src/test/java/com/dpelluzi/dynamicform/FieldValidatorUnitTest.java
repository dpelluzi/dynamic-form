package com.dpelluzi.dynamicform;

import com.dpelluzi.dynamicform.models.Cell;
import com.dpelluzi.dynamicform.util.FieldValidator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FieldValidatorUnitTest {

    @Test
    public void validateText_isValid() throws Exception {
        FieldValidator validator = FieldValidator.getInstance(Cell.FieldType.TEXT);

        String validText = "Anything";

        assertTrue(validator.validate(validText));
    }

    @Test
    public void validateText_isInvalid() throws Exception {
        FieldValidator validator = FieldValidator.getInstance(Cell.FieldType.TEXT);

        String invalidText = "";

        assertFalse(validator.validate(invalidText));
    }

    @Test
    public void validateEmail_isValid() throws Exception {
        FieldValidator validator = FieldValidator.getInstance(Cell.FieldType.EMAIL);

        String validEmail = "name@host.com";

        assertTrue(validator.validate(validEmail));
    }

    @Test
    public void validateEmail_isInvalid() throws Exception {
        FieldValidator validator = FieldValidator.getInstance(Cell.FieldType.EMAIL);

        String invalidEmail = "name@host";

        assertFalse(validator.validate(invalidEmail));
    }

    @Test
    public void validatePhone_isValid() throws Exception {
        FieldValidator validator = FieldValidator.getInstance(Cell.FieldType.TEL_NUMBER);

        String validPhoneNumber9digits = "11 98734-1234";
        String validPhoneNumber8digits = "11 9873-1234";

        assertTrue(validator.validate(validPhoneNumber9digits));
        assertTrue(validator.validate(validPhoneNumber8digits));
    }

    @Test
    public void validatePhone_isInvalid() throws Exception {
        FieldValidator validator = FieldValidator.getInstance(Cell.FieldType.TEL_NUMBER);

        String invalidPhoneNumber1 = "1 98734-1234";
        String invalidPhoneNumber2 = "11 9873-123445";

        assertFalse(validator.validate(invalidPhoneNumber1));
        assertFalse(validator.validate(invalidPhoneNumber2));
    }
}