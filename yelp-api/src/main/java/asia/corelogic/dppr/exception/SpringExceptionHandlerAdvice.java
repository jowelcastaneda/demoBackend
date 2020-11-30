package asia.corelogic.dppr.exception;

import asia.corelogic.dppr.web.api.error.ErrorMessage;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Map;


@ControllerAdvice
public class SpringExceptionHandlerAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringExceptionHandlerAdvice.class);

    @Autowired
    private MessageSource messageSource;

    static Map<String, List<ErrorMessage>> createErrorMessage(String msg) {
        LOGGER.info(msg);
        return createErrorsMap(ErrorMessage.of(msg));
    }

    static Map<String, List<ErrorMessage>> createErrorsMap(List<ErrorMessage> errors) {
        return ImmutableMap.of("errors", errors);
    }

    static Map<String, List<ErrorMessage>> createErrorsMap(ErrorMessage error) {
        return createErrorsMap(Lists.newArrayList(error));
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Map<String, List<ErrorMessage>> handleException(ErrorException exception) {
        return createErrorMessage(messageSource.getMessage(
                exception.getLocalizedMessage(),
                new Object[]{},
                LocaleContextHolder.getLocale()
        ));
    }
}
