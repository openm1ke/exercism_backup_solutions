class SpaceAge {

    private final double seconds;
    private static final double EARTH_YEAR_SECONDS = 31_557_600;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return seconds;
    }

    double getYears() {
        return getSeconds() / EARTH_YEAR_SECONDS;
    }

    double onEarth() {
        return getYears() / 1.0;
    }

    double onMercury() {
        return getYears() / 0.2408467;
    }

    double onVenus() {
        return getYears() / 0.61519726;
    }

    double onMars() {
        return getYears() / 1.8808158;
    }

    double onJupiter() {
        return getYears() / 11.862615;
    }

    double onSaturn() {
        return getYears() / 29.447498;
    }

    double onUranus() {
        return getYears() / 84.016846;
    }

    double onNeptune() {
        return getYears() / 164.79132;
    }

}
