public class ElonsToyCar {

    public Integer battery = 100;
    public Integer distance = 0;

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + distance + " meters";
    }

    public String batteryDisplay() {
        if(battery == 0) {
            return "Battery empty";
        }
        return "Battery at " + battery + "%";
    }

    public void drive() {
        if(battery <= 0) {
            batteryDisplay();
            return;
        }
        distance += 20;
        battery -= 1;
    }
}
