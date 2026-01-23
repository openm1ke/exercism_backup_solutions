import java.util.List;
import java.util.Map;
import java.util.ArrayList;

class KindergartenGarden {

    final private String nearWindowPlants;
    final private String farWindowPlants;
    private Map<String, Integer> students = Map.ofEntries(
        Map.entry("Alice", 0),
        Map.entry("Bob", 2),
        Map.entry("Charlie", 4),
        Map.entry("David", 6),
        Map.entry("Eve", 8),
        Map.entry("Fred", 10),
        Map.entry("Ginny", 12),
        Map.entry("Harriet", 14),
        Map.entry("Ileana", 16),
        Map.entry("Joseph", 18),
        Map.entry("Kincaid", 20),
        Map.entry("Larry", 22)
    );

    KindergartenGarden(String garden) {
        this.nearWindowPlants = garden.split("\n")[0];
        this.farWindowPlants = garden.split("\n")[1];
    }

    List<Plant> getPlantsOfStudent(String student) {
        Integer startIndex = students.get(student);
        if (startIndex == null) {
            throw new IllegalArgumentException("Unknown student: " + student);
        }
        
        List<Plant> plants = new ArrayList<>();

        plants.add(Plant.getPlant(nearWindowPlants.charAt(startIndex)));
        plants.add(Plant.getPlant(nearWindowPlants.charAt(startIndex + 1)));
        
        plants.add(Plant.getPlant(farWindowPlants.charAt(startIndex)));
        plants.add(Plant.getPlant(farWindowPlants.charAt(startIndex + 1)));
        
        return plants;
    }

}
