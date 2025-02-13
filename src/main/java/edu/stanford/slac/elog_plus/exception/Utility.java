package edu.stanford.slac.elog_plus.exception;

import java.util.concurrent.Callable;

public class Utility {
    /**
     * Wrap a method within a try/catch and generate, in case of
     * exception, a throw for @ControllerLogicException using input parameter
     *
     * @param callable     callable to execute
     * @param errorCode    the error code in case of exception
     * @param errorMessage the message in case of exception
     * @param errorDomain  the domain for the exception
     * @param <T>          The generic type
     * @return the result of callable
     */
    static public <T> T wrapCatch(
            Callable<T> callable,
            int errorCode,
            String errorMessage,
            String errorDomain) {
        try {
            return callable.call();
        } catch (ControllerLogicException e) {
            throw e;
        } catch (Exception e) {
            throw ControllerLogicException.builder()
                    .errorCode(errorCode)
                    .errorMessage(errorMessage)
                    .errorDomain(errorDomain)
                    .build(); // or return null, or whatever you want
        }
    }

    /**
     * Convert exception in @ControllerLogicException one
     *
     * @param callable    the callable that can throw an exception
     * @param errorCode   the error
     * @param errorDomain the domain
     * @param <T>         the type
     * @return the result of the callable
     */
    static public <T> T wrapCatch(
            Callable<T> callable,
            int errorCode,
            String errorDomain) {
        try {
            return callable.call();
        } catch (ControllerLogicException e) {
            throw e;
        } catch (Exception e) {
            throw ControllerLogicException.builder()
                    .errorCode(errorCode)
                    .errorMessage(e.getMessage())
                    .errorDomain(errorDomain)
                    .build(); // or return null, or whatever you want
        }
    }

    /**
     * Throw @ControllerLogicException on assertion fails
     *
     * @param callable     the callable that return a boolean
     * @param errorCode    the error
     * @param errorMessage the error
     * @param errorDomain  the domain
     */
    static public void assertion(Callable<Boolean> callable, int errorCode, String errorMessage, String errorDomain) {
        try {
            if (!callable.call())
                throw ControllerLogicException.builder()
                        .errorCode(errorCode)
                        .errorMessage(errorMessage)
                        .errorDomain(errorDomain)
                        .build(); // or return null, or whatever you want
        } catch (ControllerLogicException e) {
            throw e;
        } catch (Exception e) {
            throw ControllerLogicException.builder()
                    .errorCode(errorCode)
                    .errorMessage(errorMessage)
                    .errorDomain(errorDomain)
                    .build(); // or return null, or whatever you want
        }
    }

    static public void assertion(Callable<Boolean> callable, ControllerLogicException exception) {
        try {
            if (!callable.call())
                throw exception;
        } catch (ControllerLogicException e) {
            throw e;
        } catch (Exception e) {
            throw ControllerLogicException.builder()
                    .errorCode(exception.getErrorCode())
                    .errorMessage(e.getMessage())
                    .errorDomain(exception.getErrorDomain())
                    .build(); // or return null, or whatever you want
        }
    }
}
