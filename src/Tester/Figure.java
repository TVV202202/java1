package Tester;

class Figure {

    public String type() {
        return "фигура";
    }
}

class Square extends Figure {
    @Override
    public String type() {
        return "квадрат";
    }

    public static void main(String[] args) {
        System.out.println(new Square().type());
    }
}

class Point2D {
    int x;
    int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString(){
        return x + "," + y;
    }
}

class Point3D extends Point2D {
    int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return super.toString() + "," + z;
    }
}