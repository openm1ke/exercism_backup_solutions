import java.util.List;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> cars) {
        cars.sort((car1, car2) -> car2.getNumberOfVictories() - car1.getNumberOfVictories());
        return cars;
    }
}
