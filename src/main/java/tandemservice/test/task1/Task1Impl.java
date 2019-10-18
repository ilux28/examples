package tandemservice.test.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1>Задание №1</h1>
 * Реализуйте интерфейс {@link IStringRowsListSorter}.
 *
 * <p>Мы будем обращать внимание в первую очередь на структуру кода и владение стандартными средствами java.</p>
 */
public class Task1Impl implements IStringRowsListSorter {

    private List<String[]> sortedList;
    // ваша реализация должна работать, как singleton. даже при использовании из нескольких потоков.
    public static final IStringRowsListSorter INSTANCE = new Task1Impl();


    @Override
    public void sort(final List<String[]> rows, final int columnIndex) {
//        sortedList = rows.stream().sorted( (o1, o2) -> {
//                    String stringMassMin;
//                    String stringMassMax;
//                    if (o2[columnIndex].length() < o1[columnIndex].length()) {
//                        stringMassMin = o2[columnIndex];
//                        stringMassMax = o1[columnIndex];
//                    } else (o2[columnIndex].length() > o1[columnIndex].length()) {
//                        stringMassMin = o1[columnIndex];
//                        stringMassMax = o2[columnIndex];
//                    }
//
////                    } o2[columnIndex].split(" ");
////                    if (o2[columnIndex].split(" ").length > 1) {
////                    for (elemMass : stringMass.split(" ")) {
////
////                    }
////                    o2[columnIndex].compareTo(o1[columnIndex]);
//                }
//                )
//                .collect(Collectors.toList());
        // напишите здесь свою реализацию. Мы ждем от вас хорошо структурированного, документированного и понятного кода.
    }
}
