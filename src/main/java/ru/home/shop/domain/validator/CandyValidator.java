package ru.home.shop.domain.validator;

import org.springframework.util.StringUtils;
import ru.home.shop.domain.model.Candy;

import java.util.HashMap;
import java.util.Map;

public class CandyValidator {

    public static Map<String, String> validate(Candy candy) {
        if (candy == null) {
            throw new IllegalArgumentException("argument is null");
        }

        Map<String, String> errors = new HashMap<>();

        if (StringUtils.isEmpty(candy.getName())) {
            errors.put("name", "empty");
        } else if (candy.getName().length() > 50) {
            errors.put("name", "length exceeded (50)");
        }

        if (StringUtils.isEmpty(candy.getFirm())) {
            errors.put("firm", "empty");
        } else if (candy.getFirm().length() > 50) {
            errors.put("firm", "length exceeded (50)");
        }

        if (candy.getPrice() == null) {
            errors.put("price", "empty");
        } else if (candy.getPrice().doubleValue() <= 0 || candy.getPrice().scale() > 2) {
            errors.put("price", "incorrect");
        }

        if (candy.getOrder() < 0) {
            errors.put("order", "incorrect");
        }

        return errors;
    }
}
