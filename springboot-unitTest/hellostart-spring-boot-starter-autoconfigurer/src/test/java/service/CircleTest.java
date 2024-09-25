package service;

import java.util.*;
import java.math.*;

import org.junit.Before;
import org.junit.Test;
import utils.Circle;

import static org.junit.Assert.assertEquals;

public class CircleTest {

    private Circle circle;

    @Before
    public void setUp() {
        circle = new Circle();
    }

    @Test
    public void testGetRadius_SetRadius() {
        circle.setRadius(5);
        assertEquals(5, circle.getRadius(), 0.001);
    }

    @Test
    public void testGetArea() {
        circle.setRadius(7);
        assertEquals(153.93804002589985, circle.getArea(), 0.001);
    }

    @Test
    public void testGetArea_ZeroRadius() {
        circle.setRadius(0);
        assertEquals(0, circle.getArea(), 0.001);
    }

    @Test
    public void testGetArea_NegativeRadius() {
        circle.setRadius(-5);
        assertEquals(78.53981633974483, circle.getArea(), 0.001);
    }
}