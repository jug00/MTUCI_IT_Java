package Lab2;

/** двумерный класс точки **/
public class Point2d{
    /** координата Х **/
    private double xCoord;

    /** координата Y **/
    private double yCoord;

    /** Конструктор инициализации **/
    public Point2d(double x, double y){
        xCoord = x;
        yCoord = y;
    }

    /** Конструктор по умолчанию **/
    public Point2d(){
        //Вызовите конструктор с двумя параматрами и определите источник.
        this(0, 0);
    }

    /** Возвращение координаты Х **/
    public double getX(){
        return xCoord;
    }

    /** Возвращение координаты Y **/
    public double getY(){
        return yCoord;
    }

    /** Установка значения координаты Х **/
    public void setX(double val){
        xCoord = val;
    }

    /** Установка значения координаты Y **/
    public void setY(double val){
        yCoord = val;
    }
}