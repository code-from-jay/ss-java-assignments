package lesson5.Assignment1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambdas {
    private static final String[] sortArr = new String[] {
            "hic", "illum", "aliquid", "iure", "ernun"
    };

    private static final int[] intArr = new int[] { 9, 2, 5, 4, 7 };

    private static final String[] filterArr = new String[] {
            "app", "money", "apple", "time", "purple",
            "anarchy", "add", "test", "arrays", "are",
            "valid", "main", "vim", "arc", "ave"
    };

    public static void main(String[] args) {
        List<String> sorted_by_length = Arrays
                .stream(sortArr)
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());

        List<String> sorted_by_reverse_length = Arrays
                .stream(sortArr)
                .sorted(Comparator.comparing(String::length).reversed())
                .collect(Collectors.toList());

        List<String> sorted_alphabetically = Arrays
                .stream(sortArr)
                .sorted(Comparator.comparing((s -> s.charAt(0))))
                .collect(Collectors.toList());

        List<String> sorted_by_e = Arrays
                .stream(sortArr)
                .sorted(Comparator.comparing((s -> s.charAt(0) == 'e' ? 0 : 1)))
                .collect(Collectors.toList());

        Arrays.sort(sortArr, (s1, s2) -> sortByE(s1, s2));

        System.out.println("1)");
        System.out.println("Sorted by Length: " + sorted_by_length);
        System.out.println("Sorted by Reverse Length: " + sorted_by_reverse_length);
        System.out.println("Sorted Alphabetically: " + sorted_alphabetically);
        System.out.println("Sorted by E: " + sorted_by_e);
        System.out.println("Sorted by E (Helper): " + Arrays.toString(sortArr));
        System.out.println();

        System.out.println("2)");
        System.out.println(lambda2Method());

        System.out.println("3)");
        System.out.println(lambda3Method());
    }

    private static int sortByE(String s1, String s2) {
        char c1 = s1.charAt(0), c2 = s2.charAt(0);
        if (c1 == 'e' && c2 == 'e') return 0;
        else if (c1 == 'e') return -1;
        else return 1;
    }

    private static String lambda2Method() {
        return Arrays
                .stream(Lambdas.intArr)
                .mapToObj(i -> (i % 2 == 0 ? "e" : "o") + i)
                .collect(Collectors.toList())
                .toString();
    }

    private static List<String> lambda3Method() {
        return Arrays
                .stream(Lambdas.filterArr)
                .filter(s -> s.charAt(0) == 'a' && s.length() == 3)
                .collect(Collectors.toList());
    }
}
