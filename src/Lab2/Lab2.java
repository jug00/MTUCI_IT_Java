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
        if ((point1.getX() == point2.getX() && point1.getY() == point2.getY() && point1.getZ() == point2.getZ()) ||
                (point1.getX() == point3.getX() && point1.getY() == point3.getY() && point1.getZ() == point3.getZ()) ||
                (point2.getX() == point3.getX() && point2.getY() == point3.getY() && point2.getZ() == point3.getZ())) {
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
        double a = Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2)
                + Math.pow(point1.getZ() - point2.getZ(), 2));
        double b = Math.sqrt(Math.pow(point2.getX() - point3.getX(), 2) + Math.pow(point2.getY() - point3.getY(), 2)
                + Math.pow(point2.getZ() - point3.getZ(), 2));
        double c = Math.sqrt(Math.pow(point3.getX() - point1.getX(), 2) + Math.pow(point3.getY() - point1.getY(), 2)
                + Math.pow(point3.getZ() - point1.getZ(), 2));
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
