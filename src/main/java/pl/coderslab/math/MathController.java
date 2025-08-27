package pl.coderslab.math;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/multiply/{a}/{b}")
    public double multiplyNumbers(@PathVariable("a") double a,
                                  @PathVariable("b") double b) {
        return mathService.multiply(a, b);
    }


}
