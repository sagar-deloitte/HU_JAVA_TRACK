package JAVAassignment;

import java.awt.*;

public class areaOfShapes {
    public static void main(String[] args)
    {
        Circle shape1 = new Circle();
        shape1.Area(4);
        shape1.Area(7.2);
        Square shape2 = new Square();
        shape2.Area(6);
        shape2.Area(4.4);
        Rectangle shape3 = new Rectangle();
        shape3.Area(13,22);
        shape3.Area(5.5,6.5);
        Triangle shape4 = new Triangle();
        shape4.Area(4,7);
        shape4.Area(3.2,6);
    }
}
class Circle
{
    static final double Pi=Math.PI;
    void Area(double radius){
        System.out.println(Pi*(radius*radius));
    }
    void Area(float radius){
        System.out.println(Pi*(radius*radius));
    }
}
class Square
{
    void Area(double edge){
        System.out.println(edge*edge);
    }
    void Area(float edge){
        System.out.println(edge*edge);
    }
}
class Rectangle
{
    void Area(double length, double breath){
        System.out.println(length*breath);
    }
    void Area(float length, float breath){
        System.out.println(length*breath);
    }
}
class Triangle
{
    void Area(double base, double height){
        System.out.println(0.5*(base*height));
    }
    void Area(float base, float height){
        System.out.println(0.5*(base*height));
    }
}