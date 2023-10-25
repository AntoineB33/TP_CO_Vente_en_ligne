import java.util.List;
import java.util.function.Predicate;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");

        // Pass a lambda expression as an argument to a method
        filterAndPrint(names, s -> s.startsWith("C"));
    }

    // A method that accepts a Predicate (a functional interface) as an argument
    public static void filterAndPrint(List<String> names, Predicate<String> filter) {
        for (String name : names) {
            if (filter.test(name)) {
                System.out.println(name);
            }
        }
    }
}
