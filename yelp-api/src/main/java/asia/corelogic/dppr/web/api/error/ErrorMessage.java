package asia.corelogic.dppr.web.api.error;

import lombok.Value;

@Value(staticConstructor = "of")
public class ErrorMessage {

    private final String msg;

}
