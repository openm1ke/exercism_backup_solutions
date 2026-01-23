import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    private static final long GIGASECOND = 1_000_000_000L;
    private final LocalDateTime dateTime;

    // Если пришёл только день — считаем моментом начало суток (00:00)
    public Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    // Основной конструктор: прибавляем 1e9 секунд
    public Gigasecond(LocalDateTime moment) {
        this.dateTime = moment.plusSeconds(GIGASECOND);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}

