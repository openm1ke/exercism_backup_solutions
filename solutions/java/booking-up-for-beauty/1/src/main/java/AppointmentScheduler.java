import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        return LocalDateTime.parse(appointmentDateDescription, parser);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        LocalDateTime noon = LocalDateTime.of(appointmentDate.getYear(), appointmentDate.getMonth(), appointmentDate.getDayOfMonth(), 12, 0, 0);
        LocalDateTime evening = LocalDateTime.of(appointmentDate.getYear(), appointmentDate.getMonth(), appointmentDate.getDayOfMonth(), 18, 0, 0);
        return (appointmentDate.isAfter(noon) || appointmentDate.isEqual(noon)) && (appointmentDate.isBefore(evening));
    }

    public String getDescription(LocalDateTime appointmentDate) {
        return "You have an appointment on " + appointmentDate.format(DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy")) + ", at " + appointmentDate.format(DateTimeFormatter.ofPattern("h:mm a."));
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 15);
    }
}
