import java.util.Arrays;

class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return birdsPerDay;
    }

    public int getToday() {
        return getLastWeek()[getLastWeek().length - 1];
    }

    public void incrementTodaysCount() {
        getLastWeek()[getLastWeek().length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        return Arrays.stream(getLastWeek()).anyMatch(i -> i == 0);
    }

    public int getCountForFirstDays(int numberOfDays) {
        return Arrays.stream(getLastWeek()).limit(numberOfDays).sum();
    }

    public int getBusyDays() {
        return (int) Arrays.stream(getLastWeek()).filter(i -> i >= 5).count();
    }
}
