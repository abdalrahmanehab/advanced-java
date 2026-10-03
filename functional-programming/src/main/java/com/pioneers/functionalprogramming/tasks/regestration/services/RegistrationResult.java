package com.pioneers.functionalprogramming.tasks.regestration.services;

import java.util.function.Consumer;

public sealed interface RegistrationResult permits RegistrationResult.Success, RegistrationResult.Failure {

    void onSuccess(Consumer<String> action);

    void onFailure(Consumer<String> action);

    record Success(String message) implements RegistrationResult {

        @Override
        public void onSuccess(final Consumer<String> action) {
            action.accept(message);
        }

        @Override
        public void onFailure(final Consumer<String> action) {

        }
    }

    record Failure(String message) implements RegistrationResult {

        @Override
        public void onSuccess(final Consumer<String> action) {

        }

        @Override
        public void onFailure(final Consumer<String> action) {
            action.accept(message);
        }
    }
}
