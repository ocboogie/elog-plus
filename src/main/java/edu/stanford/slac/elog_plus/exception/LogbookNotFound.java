package edu.stanford.slac.elog_plus.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "ItemNotFound")
public class LogbookNotFound extends ControllerLogicException {
    @Builder(builderMethodName = "logbookNotFoundBuilder")
    public LogbookNotFound(Integer errorCode, String errorDomain) {
        super(errorCode, "The Entry has not been found", errorDomain);
    }
}
