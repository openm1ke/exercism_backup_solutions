import java.util.HashSet;

class SumOfMultiples {

    // Здесь храним только уникальные числа.
    // HashSet автоматически не даст добавить одно и то же число дважды.
    private final HashSet<Integer> unique = new HashSet<>();

    SumOfMultiples(int limit, int[] factors) {
        // Проходим по всем факторам (делителям), которые пришли в массиве.
        for (int factor : factors) {
            // Если фактор 0 или отрицательный, пропускаем его.
            // Делить по модулю на 0 нельзя, а отрицательные в этой задаче не нужны.
            if (factor <= 0) {
                continue;
            }

            // Берем только кратные этого фактора:
            // factor, 2*factor, 3*factor и так далее, пока число меньше limit.
            for (int n = factor; n < limit; n += factor) {
                // Добавляем кратное число в Set.
                // Если это число уже добавляли через другой фактор, дубликата не будет.
                unique.add(n);
            }
        }
    }

    int getSum() {
        int sum = 0;

        // Проходим по всем уникальным кратным числам и складываем их.
        for (int n : unique) {
            sum += n;
        }

        // Возвращаем итоговую сумму.
        return sum;
    }
}
