package Lab2;

import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] array = new double[3];
        System.out.println("Введите три коорднинаты первой точки: ");
        for (int i = 0; i < 3; i++) {
            array[i] = input.nextDouble();
        }
        Point3d point1 = new Point3d(array[0],array[1],array[2]);
        System.out.println("Введите три коорднинаты второй точки: ");
        for (int i = 0; i < 3; i++) {
            array[i] = input.nextDouble();
        }
        Point3d point2 = new Point3d(array[0],array[1],array[2]);
        System.out.println("Введите три коорднинаты третьей точки: ");
        for (int i = 0; i < 3; i++) {
            array[i] = input.nextDouble();
        }
        Point3d point3 = new Point3d(array[0],array[1],array[2]);
        if (point1.equalS(point2) || point1.equalS(point3) || point2.equalS(point3)){
            System.out.println("Введены одинаковые точки");
        }
        else {
            System.out.println("Длина стороны a - " + point1.distanceTo(point2));
            System.out.println("Длина стороны b - " + point2.distanceTo(point3));
            System.out.println("Длина стороны c - " + point3.distanceTo(point1));
            System.out.println("Площадь треугольника - " + computeArea(point1, point2, point3));
        }
    }
    public static double computeArea(Point3d point1, Point3d point2, Point3d point3){
        double a = point1.distanceTo(point2);
        double b = point2.distanceTo(point3);
        double c = point3.distanceTo(point1);
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
