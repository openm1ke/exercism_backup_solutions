public class ExperimentalRemoteControlCar implements RemoteControlCar {

    private int distance = 0;
    private int speed = 0;

    public ExperimentalRemoteControlCar() {
        speed = 20;
    }

    @Override
    public void drive() {
        distance += speed;
    }

    @Override
    public int getDistanceTravelled() {
        return distance;
    }
}
