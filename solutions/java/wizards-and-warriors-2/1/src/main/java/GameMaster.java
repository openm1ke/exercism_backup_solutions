public class GameMaster {

    // TODO: define a 'describe' method that returns a description of a Character
    public String describe(Character character) {
        return "You're a level " + character.getLevel() + " " + character.getCharacterClass() + " with " + character.getHitPoints() + " hit points." ;
    }
    // TODO: define a 'describe' method that returns a description of a Destination
    public String describe(Destination destination) {
        return "You've arrived at " + destination.getName() + ", which has " + destination.getInhabitants() + " inhabitants.";
    }

    // TODO: define a 'describe' method that returns a description of a TravelMethod
    public String describe(TravelMethod travelMethod) {
        String name = switch (travelMethod) {
            case WALKING -> "by walking";
            case HORSEBACK -> "on horseback";
        };
        return "You're traveling to your destination " + name + ".";
    }
    // TODO: define a 'describe' method that returns a description of a Character, Destination and TravelMethod
    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        return describe(character) + " " + describe(travelMethod) + " " + describe(destination);
    }

    // TODO: define a 'describe' method that returns a description of a Character and Destination
    public String describe(Character character, Destination destination) {
        return describe(character) + " " + describe(TravelMethod.WALKING) + " " + describe(destination);
    }
}
