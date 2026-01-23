public class Twofer {
    public String twofer(String name) {
        if (name != null && !name.isBlank()) return "One for " + name + ", one for me.";
        else return "One for you, one for me.";
    }
}
