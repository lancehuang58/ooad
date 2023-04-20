package waterball;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Individual> list = generateIndividuals();
//        printIndividual(list);

//
//        MatchMakingSystem matchSystemByHabit = new MatchMakingSystem(new HabitBaseStrategy());
//        matchSystemByHabit.matchEach(list);
//        printMatchedTarget(list);
//
        MatchMakingSystem matchSystemByDistance = new MatchMakingSystem(new DistanceBaseStrategy());
        matchSystemByDistance.matchEach(list);
        printMatchedTarget(list);
//
//        MatchMakingSystem matchSystemByFurthestDistance = new MatchMakingSystem(new ReverseStrategy(new DistanceBaseStrategy()));
//        matchSystemByFurthestDistance.matchEach(list);
//        printMatchedTarget(list);
    }

    private static List<Individual> generateIndividuals() {
        ArrayList<Individual> objects = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            objects.add(new Individual());
        }
        return objects;
    }

    private static void printMatchedTarget(List<Individual> list) {
        for (Individual individual : list) {
            individual.printMatch();
        }
    }
    private static void printIndividual(List<Individual> list) {
        for (Individual individual : list) {
            System.out.println(individual);
        }
    }
}
