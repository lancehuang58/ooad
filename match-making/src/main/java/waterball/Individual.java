package waterball;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Individual {


    private int id;
    private String gender;
    private int age;
    private String intro;
    private String habits;
    private Coord coord;
    private Individual foundMatch;
    private static int taskCount = 0;
    static RandomEnumGenerator<Habit> generator = new RandomEnumGenerator<>(Habit.class);

    public Individual() {
        id = taskCount++;
        gender = RandomUtils.nextInt() % 2 == 0 ? "MALE" : "FEMALE";
        age = RandomUtils.nextInt(0, 100);
        intro = RandomString.make(20);
        coord = new Coord(RandomUtils.nextInt(0, 99), RandomUtils.nextInt(0, 99));
        List<Habit> times = generator.times(2);
        List<String> collect = times.stream().map(habit -> habit.name()).collect(Collectors.toList());
        habits = String.join(",", collect);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("gender", gender)
                .append("age", age)
                .append("intro", intro)
                .append("habits", habits)
                .append("coord", coord)
                .toString();
    }

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
