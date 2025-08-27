package pl.coderslab.math;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public double substract(double a, double b) {
        return a - b;
    }

}
