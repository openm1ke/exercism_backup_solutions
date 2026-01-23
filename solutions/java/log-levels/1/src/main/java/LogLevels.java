public class LogLevels {
    
    public static String message(String logLine) {
        String[] splitted = logLine.split(":",2);
        return splitted[1].trim();
    }

    public static String logLevel(String logLine) {
        String[] splitted = logLine.split(":", 2);
        return splitted[0].replace("[", "").replace("]", "").toLowerCase();
    }

    public static String reformat(String logLine) {
        String err = LogLevels.message(logLine);
        String lvl = LogLevels.logLevel(logLine);
        return err + " (" + lvl + ")";
    }
}
