package utils;

import org.springframework.context.annotation.Bean;

/**
 * @ClassName Circle
 * @Description
 * @Author ynchen
 * @Date 2024/9/25 16:12
 * @Version V1.0.0
 */
public final class Circle {
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private double radius;

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
