package Lab4;

import java.awt.geom.Rectangle2D;

public class BurningShip extends FractalGenerator{

    public static final int MAX_ITERATIONS = 2000;

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.setRect(-2, -2,3.5,3.5);
    }

    @Override
    public int numIterations(double x, double y) {
        int i = 0;
        ComplexNumber z = new ComplexNumber(0, 0);
        ComplexNumber c = new ComplexNumber(x, y);
        while (z.getModulusSquared() < 4){
            z = z.getSquareModulusNumbers().add(c);
            i += 1;
            if (i == MAX_ITERATIONS){return -1;}
        }
        return i;
    }

    @Override
    public String toString() {
        return "BurningShip";
    }
}
