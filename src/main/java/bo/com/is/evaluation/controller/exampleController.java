package bo.com.is.evaluation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prueba")
public class exampleController {

    @GetMapping("/hola")
    public String prueba() {
        return "Hello Word!";
    }
}
