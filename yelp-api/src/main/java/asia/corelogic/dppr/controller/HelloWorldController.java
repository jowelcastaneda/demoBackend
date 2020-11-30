package asia.corelogic.dppr.controller;

import asia.corelogic.dppr.domain.model.request.HelloWorldRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/helloWorld")
public class HelloWorldController {

    @ApiOperation(value = "This will return a Hello World Text", notes = "This call doesn't requires any parameter")
    @GetMapping("")
    public String getHelloWorldApi() {
        return "Hello World!";
    }

    @ApiOperation(value = "This will return a greeting", notes = "This call requires request body")
    @PostMapping("/custom")
    public String getHelloName(@RequestBody @Valid HelloWorldRequest helloWorldRequest) {
        return "Hello ".concat(helloWorldRequest.getFirstName()).concat(" ".concat(helloWorldRequest.getLastName()));
    }

}