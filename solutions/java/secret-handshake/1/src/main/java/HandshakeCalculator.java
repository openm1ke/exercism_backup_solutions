import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        String binary = new StringBuilder(Integer.toBinaryString(number)).reverse().toString();
        List<Signal> signals = new ArrayList<>();
        for (int i = 0; i < binary.length() && i < 5; i++) {
            if (binary.charAt(i) == '1') {
                if (i == 4) {
                    Collections.reverse(signals);
                } else {
                    signals.add(Signal.values()[i]);
                }
            }
        }
        return signals;
    }
}
