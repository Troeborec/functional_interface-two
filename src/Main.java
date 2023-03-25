import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> listNum = new ArrayList<Integer>();
        listNum.add(15);
        listNum.add(7);
        listNum.add(12);
        listNum.add(2);
        listNum.add(8);
        listNum.add(104);
        listNum.add(86);
        listNum.add(45);
        listNum.add(20);
        listNum.add(57);

        Stream<Integer> numStream = listNum.stream();
        Comparator<Integer> comparator1 = Comparator.comparingInt(Integer::intValue);
        BiConsumer<Integer, Integer> biConsumer = (min, max) -> System.out.println(min + " " + max);

        findMinMax(numStream, comparator1, biConsumer);

        System.out.println(countEvenNums(listNum));
        System.out.println( );
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.sorted(order).collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    public static Integer countEvenNums(List<Integer> list) {
        Stream<Integer> strean = list.stream();
        int count = (int) list.stream().filter(n -> n % 2 == 0).count();
        return count;
    }
}
