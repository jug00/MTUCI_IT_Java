package Lab2;

public class Point3d extends Point2d{
    private double zCoord;

    public Point3d(double x, double y, double z){
        super(x, y);
        zCoord = z;
    }

    public Point3d(){
        this(0,0,0);
    }

    public double getZ() {
        return zCoord;
    }

    public void setZ(double val) {
        zCoord = val;
    }
    public double distanceTo(Point3d point){
        return Double.parseDouble(String.format("%.2f",Math.sqrt(Math.pow(this.getX() - point.getX(), 2)
                + Math.pow(this.getY() - point.getY(), 2)
                + Math.pow(this.getZ() - point.getZ(), 2))).replace(",","."));
    }
    public boolean equalS(Point3d point){
        if ((this.getX() == point.getX() && this.getY() == point.getY() && this.getZ() == point.getZ())){
            return true;
        }
        return false;
    }
}
