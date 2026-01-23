public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        int cars_per_hour = 221;
        double total = 0;
        if(speed >= 1 && speed <= 4) {
            total = speed * cars_per_hour;
        } else if (speed >= 5 && speed <= 8) {
            total = speed * cars_per_hour * 0.9;
        } else if (speed == 9) {
            total = speed * cars_per_hour * 0.8;
        } else if (speed == 10) {
            total = speed * cars_per_hour * 0.77;
        }
        return total;
    }

    public int workingItemsPerMinute(int speed) {
        double rate = productionRatePerHour(speed);
        return (int) (rate / 60);
    }
}
