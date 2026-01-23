import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {
        int len = a - 'A';
        List<String> list = new ArrayList<>();

        for (int i = 0; i <= len; i++) {
            list.add(line(i, len));
        }
        for (int i = len - 1; i >= 0; i--) {
            list.add(line(i, len));
        }

        return list;
    }

    private String line(int i, int len) {
        char c = (char) ('A' + i);
        int out = len - i;

        if (i == 0) {
            return " ".repeat(out) + c + " ".repeat(out);
        }

        int in = 2 * i - 1;
        return " ".repeat(out) + c + " ".repeat(in) + c + " ".repeat(out);
    }

}
