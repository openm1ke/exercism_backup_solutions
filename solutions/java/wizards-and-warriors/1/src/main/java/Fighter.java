class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

// TODO: define the Warrior class
class Warrior extends Fighter {
    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    @Override
    public boolean isVulnerable() {
        return false;
    }

    @Override
    public int getDamagePoints(Fighter fighter) {
        return fighter.isVulnerable() ? 10 : 6;
    }
}

// TODO: define the Wizard class
class Wizard extends Fighter {

    private boolean preparedSpell = false;

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }

    public void prepareSpell() {
        preparedSpell = true;
    }

    @Override
    public boolean isVulnerable() {
        return !preparedSpell;
    }

    @Override
    public int getDamagePoints(Fighter fighter) {
        return preparedSpell ? 12 : 3;
    }
}
