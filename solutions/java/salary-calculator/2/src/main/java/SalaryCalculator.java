public class SalaryCalculator {
    public double salaryMultiplier(int daysSkipped) {
        return daysSkipped < 5 ? 1.0 : 0.85;
    }

    public int bonusMultiplier(int productsSold) {
        return productsSold < 20 ? 10 : 13;
    }

    public double bonusForProductsSold(int productsSold) {
        return productsSold * bonusMultiplier(productsSold);
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double salary = 1000.0;
        double multiplier = salaryMultiplier(daysSkipped);
        double bonus = bonusForProductsSold(productsSold);
        return (salary * multiplier + bonus > 2000.0) ? 2000.0 : salary * multiplier + bonus;
    }
}
