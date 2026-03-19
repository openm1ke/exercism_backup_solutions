import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SplitSecondStopwatch {

    private enum State {
        READY("ready"),
        RUNNING("running"),
        STOPPED("stopped");
        private final String state;
        State(String state) {
            this.state = state;
        }

        String getState() {
            return state;
        }
    }

    private State state = State.READY;
    private Duration currentLap = Duration.ZERO;
    private Duration totalElapsed = Duration.ZERO;
    private final List<Duration> previousLaps = new ArrayList<>();

    public void start() {
        if (state == State.RUNNING) {
            throw new IllegalStateException("cannot start an already running stopwatch");
        }
        state = State.RUNNING;
    }

    public void stop() {
        if (state != State.RUNNING) {
            throw new IllegalStateException("cannot stop a stopwatch that is not running");
        }
        state = State.STOPPED;
    }

    public void reset() {
        if (state != State.STOPPED) {
            throw new IllegalStateException("cannot reset a stopwatch that is not stopped");
        }
        state = State.READY;
        currentLap = Duration.ZERO;
        totalElapsed = Duration.ZERO;
        previousLaps.clear();
    }

    public void lap() {
        if (state != State.RUNNING) {
            throw new IllegalStateException("cannot lap a stopwatch that is not running");
        }
        previousLaps.add(currentLap);
        currentLap = Duration.ZERO;
    }

    public String state() {
        return state.getState();
    }

    public String currentLap() {
        return formatDuration(currentLap);
    }

    public String total() {
        return formatDuration(totalElapsed);
    }

    public java.util.List<String> previousLaps() {
        List<String> formatted = new ArrayList<>(previousLaps.size());
        for (Duration lap : previousLaps) {
            formatted.add(formatDuration(lap));
        }
        return formatted;
    }

    public void advanceTime(String timeString) {
        if (state != State.RUNNING) {
            return;
        }

        String[] parts = timeString.split(":");
        long hours = Long.parseLong(parts[0]);
        long minutes = Long.parseLong(parts[1]);
        long seconds = Long.parseLong(parts[2]);

        Duration delta = Duration.ofHours(hours)
                .plusMinutes(minutes)
                .plusSeconds(seconds);

        currentLap = currentLap.plus(delta);
        totalElapsed = totalElapsed.plus(delta);
    }

    private String formatDuration(Duration duration) {
        return String.format(
                "%02d:%02d:%02d",
                duration.toHours(),
                duration.toMinutesPart(),
                duration.toSecondsPart()
        );
    }
}
