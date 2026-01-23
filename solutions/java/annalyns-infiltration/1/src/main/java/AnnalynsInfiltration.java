class AnnalynsInfiltration {
    public static boolean canFastAttack(boolean knightIsAwake) {
        return !knightIsAwake;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        return knightIsAwake || archerIsAwake || prisonerIsAwake;
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        return !archerIsAwake && prisonerIsAwake;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {

        if(knightIsAwake && archerIsAwake && prisonerIsAwake && petDogIsPresent) return false;
        if(knightIsAwake && archerIsAwake && !prisonerIsAwake && petDogIsPresent) return false;
        return (petDogIsPresent && !knightIsAwake && !archerIsAwake) || (prisonerIsAwake && !knightIsAwake && !archerIsAwake && !petDogIsPresent) || (petDogIsPresent && knightIsAwake);
    }
}
