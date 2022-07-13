package lesson5.Assignment2;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Functional {
    public static List<Integer> rightDigit(List<Integer> arr) {
        return arr
                .stream()
                .map(i -> i % 10)
                .collect(Collectors.toList());
    }

    public static List<Integer> doubling(List<Integer> arr) {
        return arr
                .stream()
                .map(i -> i * 2)
                .collect(Collectors.toList());
    }

    public static List<String> noX(List<String> arr) {
        return arr
                .stream()
                .map(s -> s.replace("x", ""))
                .collect(Collectors.toList());
    }

    public static boolean groupSumClump(int start, List<Integer> arr, int target) {
        collapseAdjacent(arr);

        return summate(arr, 0, 0, target);
    }

    private static void collapseAdjacent(List<Integer> arr) {
        int sum = 0;
        for (int i = 0; i < arr.size() - 1; ++i) {
            if (Objects.equals(arr.get(i), arr.get(i + 1))) {
                sum += arr.get(i) + arr.get(i + 1);
                arr.set(i, sum);
                arr.set(i + 1, 0);
            }
        }
    }

    private static boolean summate(List<Integer> arr, int index, int sum, int target) {
        if (sum == target)
            return true;

        if (index == arr.size())
            return false;

        if (summate(arr, index + 1, sum + arr.get(index), target))
            return true;

        return summate(arr, index + 1, sum, target);
    }
}
