package Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(53);
        numbers.add(9);
        numbers.add(83);
        numbers.add(13);

        Consumer<Integer> method = (n) -> { System.out.println(n); };
        numbers.forEach((n) -> { if(n == 9) System.out.print(n + " "); });

        System.out.println();

        numbers.forEach((n) -> { System.out.print(n + " "); });

        System.out.println();

        Iterator<Integer> it = numbers.iterator();
        while(it.hasNext()) {
            Integer i = it.next();
            System.out.print(i + " ");
        }

        System.out.println();

        System.out.println(numbers);

    }
}