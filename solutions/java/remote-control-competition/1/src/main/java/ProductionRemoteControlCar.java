class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    private int speed = 0;
    private int distance = 0;
    private int numberOfVictories = 0;

    public ProductionRemoteControlCar() {
        speed = 10;
    }

    @Override
    public void drive() {
        distance += speed;
    }

    @Override
    public int getDistanceTravelled() {
        return distance;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar other) {
        return Integer.compare(this.numberOfVictories, other.numberOfVictories);
    }
}
