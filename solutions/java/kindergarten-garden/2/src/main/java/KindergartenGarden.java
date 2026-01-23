import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class KindergartenGarden {

    private final String nearWindowPlants;
    private final String farWindowPlants;
    private static final List<String> STUDENTS = Arrays.asList(
        "Alice", "Bob", "Charlie", "David", "Eve", "Fred", 
        "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry"
    );

    KindergartenGarden(String garden) {
        String[] rows = garden.split("\n");
        this.nearWindowPlants = rows[0];
        this.farWindowPlants = rows[1];
    }

    List<Plant> getPlantsOfStudent(String student) {
        int studentIndex = STUDENTS.indexOf(student);
        if (studentIndex == -1) {
            throw new IllegalArgumentException("Unknown student: " + student);
        }
        
        int startIndex = studentIndex * 2;
        List<Plant> plants = new ArrayList<>();
        String[] rows = {nearWindowPlants, farWindowPlants};
        
        for (String row : rows) {
            plants.add(Plant.getPlant(row.charAt(startIndex)));
            plants.add(Plant.getPlant(row.charAt(startIndex + 1)));
        }
        
        return plants;
    }

}
