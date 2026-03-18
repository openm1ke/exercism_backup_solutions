import java.util.ArrayList;
import java.util.List;

class Sieve {
    private final int limit;
    Sieve(int maxPrime) {
        this.limit = maxPrime;
    }

    List<Integer> getPrimes() {
        boolean[] isComposite = new boolean[limit + 1];
        List<Integer> primes = new ArrayList<>();
        if (limit < 2) {
            return primes;
        }

        for (int i = 2; i <= Math.sqrt(limit); i++) {
            if (isComposite[i]) {
                continue;
            }

            int j  = i * i;
            while (j <= limit) {
                isComposite[j] = true;
                j += i;
            }
        }

        for (int i = 2; i <= limit; i++) {
            if (!isComposite[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
