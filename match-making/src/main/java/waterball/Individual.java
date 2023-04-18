package waterball;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode(of = "id")
public class Individual {
    private int id;
    private String gender;
    private int age;
    private String intro;
    private String habits;
    private Coord coord;
    private Individual foundMatch;

    public void setMatchedIndividual(Individual foundMatch) {
        this.foundMatch = foundMatch;
    }

    public void printMatch() {
        System.out.println("match individul " + foundMatch);
    }

    public Set<String> getHabitsSet() {
        return Arrays.stream(habits.split(",")).collect(Collectors.toSet());
    }

    public int habitDiffCount(Individual other) {
        Set<String> habitsSet = getHabitsSet();
        habitsSet.retainAll(other.getHabitsSet());
        return habitsSet.size();
    }

}
