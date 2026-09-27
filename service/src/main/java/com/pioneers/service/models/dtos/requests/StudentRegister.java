package com.pioneers.service.models.dtos.requests;

import com.pioneers.service.utils.validators.ValidationRules;
import com.pioneers.service.utils.validators.ValidationRulesService;

import java.util.LinkedHashMap;
import java.util.Map;

public record StudentRegister(
//        @NotBlank(message = "{validation.first-name.blank}")
//        @Size(min = 2, max = 15, message = "{validation.first-name.error.message}")
        String firstName,
//        @NotBlank(message = "{validation.second-name.blank}")
//        @Size(min = 2, max = 15, message = "{validation.second-name.size}")
        String secondName,
//        @Min(value = 18, message = "{validation.age.min}")
//        @Max(value = 25, message = "{validation.age.max}")
//        @Age(min = 15, max = 25)
        int age,
//        @Email(message = "{validation.email.pattern}")
        String email,
//        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9\\s])\\S{9,31}$",
//                message = "{validation.password.pattern}")
        String password
) {
    public void validate() {
        final Map<String, String> errors = new LinkedHashMap<>();

        catchRuleExceptions(errors,ValidationRules.FIRST_NAME, firstName);
        catchRuleExceptions(errors,ValidationRules.SECOND_NAME, secondName);
        catchRuleExceptions(errors,ValidationRules.AGE, String.valueOf(age));
        catchRuleExceptions(errors,ValidationRules.EMAIL, email);
        catchRuleExceptions(errors,ValidationRules.PASSWORD, password);

        if (!errors.isEmpty()) {
            throw new ValidationRulesService.ValidationException(errors);
        }
    }

    private static void catchRuleExceptions (
            final Map<String, String> errors
            ,ValidationRules validationRule
            ,String rule
    ) {
        try {
            ValidationRulesService.validate(validationRule, rule);
        } catch (final ValidationRulesService.RuleException e) {
            errors.putIfAbsent(e.getMessage(), e.getDescription());
        }
    }
}
