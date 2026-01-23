class Darts {
    int score(double xOfDart, double yOfDart) {
        double dx = xOfDart * xOfDart;
        double dy = yOfDart * yOfDart;
        double bullEye = 1;
        double middle = 25;
        double outer = 100;
        if (dx + dy <= bullEye) {
            return 10;
        } else if (dx + dy <= middle) {
            return 5;
        } else if (dx + dy <= outer) {
            return 1;
        } else {
            return 0;
        }
    }
}
