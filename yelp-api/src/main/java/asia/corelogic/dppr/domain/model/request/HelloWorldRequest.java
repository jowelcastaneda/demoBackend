package asia.corelogic.dppr.domain.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class HelloWorldRequest {

    @ApiModelProperty(required = true, value = "First Name to greet")
    @NotBlank
    private String firstName;

    @ApiModelProperty(value = "First Name to greet")
    private String lastName;
}