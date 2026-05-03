import java.time.*;

public class SwiftScheduling {

    private enum Abbreviation {
        NOW,
        ASAP,
        EOW;
    }

    public static LocalDateTime convertToDeliveryDate(LocalDateTime meetingStart, String description) {
        int currentYear = meetingStart.getYear();
        if (description.endsWith("M")) {
            int month = Integer.parseInt(description.substring(0, description.length() - 1));
            LocalDateTime startOfTargetMonth = LocalDateTime.of(currentYear, month, 1, 0, 0, 0);
            LocalDate date = LocalDate.of(currentYear, month, 1);
            if (!meetingStart.isBefore(startOfTargetMonth)) date = date.plusYears(1);
            while (isWeekend(date)) {
                date = date.plusDays(1);
            }
            return date.atTime(8, 0);
        }

        if (description.startsWith("Q")) {
            int quarter = Integer.parseInt(description.substring(1));
            LocalDateTime startOfNextQuarter = LocalDate.of(currentYear, 1, 1).plusMonths(quarter * 3L).atStartOfDay();
            LocalDate date = YearMonth.of(currentYear, quarter * 3).atEndOfMonth();
            if (!meetingStart.isBefore(startOfNextQuarter)) date = date.plusYears(1);
            while (isWeekend(date)) {
                date = date.minusDays(1);
            }
            return date.atTime(8, 0);
        }

        Abbreviation abbreviation = Abbreviation.valueOf(description);

        return switch (abbreviation) {
            case NOW -> meetingStart.plusHours(2);
            case ASAP -> {
                if (meetingStart.toLocalTime().isBefore(LocalTime.of(13, 0))) yield meetingStart.toLocalDate().atTime(LocalTime.of(17, 0));
                yield meetingStart.toLocalDate().plusDays(1).atTime(LocalTime.of(13, 0));
            }
            case EOW -> {
                DayOfWeek dayOfWeek = meetingStart.getDayOfWeek();
                if (dayOfWeek == DayOfWeek.MONDAY || dayOfWeek == DayOfWeek.TUESDAY || dayOfWeek == DayOfWeek.WEDNESDAY ) {
                    yield meetingStart.with(DayOfWeek.FRIDAY).toLocalDate().atTime(LocalTime.of(17, 0));
                } else if (dayOfWeek == DayOfWeek.THURSDAY || dayOfWeek == DayOfWeek.FRIDAY) {
                    yield meetingStart.with(DayOfWeek.SUNDAY).toLocalDate().atTime(LocalTime.of(20, 0));
                }
                throw new IllegalArgumentException("Invalid day of week: " + dayOfWeek);
            }
        };
    }

    private static boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}
