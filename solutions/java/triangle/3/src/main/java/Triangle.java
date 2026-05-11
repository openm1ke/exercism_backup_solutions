class Triangle {

    private final double a, b, c;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) throw new TriangleException();
        if (side1 + side2 < side3 || side2 + side3 < side1 || side3 + side1 < side2) throw new TriangleException();
        this.a = side1;
        this.b = side2;
        this.c = side3;
    }

    boolean isEquilateral() {
        return (a == b && b == c && c == a);
    }

    boolean isIsosceles() {
        return (a == b || b == c || c == a);
    }

    boolean isScalene() {
        return (a != b &&  b != c && c != a);
    }

}
