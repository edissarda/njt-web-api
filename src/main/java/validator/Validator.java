/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.io.Serializable;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;

/**
 *
 * @author edis
 */
public class Validator {

    public static <T extends Serializable> void validate(T o) throws Exception {
        Set<ConstraintViolation<T>> errors = Validation.buildDefaultValidatorFactory()
                .getValidator()
                .validate(o);

        if (errors != null && !errors.isEmpty()) {
            throw new Exception(errors.iterator().next().getMessage());
        }
    }
}
