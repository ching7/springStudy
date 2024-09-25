package service;

import utils.Circle;

import javax.annotation.Resource;

/**
 * @ClassName UtilsSercvice
 * @Description
 * @Author ynchen
 * @Date 2024/9/25 17:20
 * @Version V1.0.0
 */
public class UtilsService {
    @Resource
    Circle circle;

    public double getCircle(double radius) {
        circle.setRadius(radius);
        return circle.getArea();
    }
}
