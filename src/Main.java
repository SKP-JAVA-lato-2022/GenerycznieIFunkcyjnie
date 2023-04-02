import anonymous.SomeInterface;
import generic.BoxOnSteroids;
import generic.ObjectBox;
import generic.oranges.Orange;
import generic.apples.Apple;
import lambda.Human;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        //fruits();
        //anonymous();
        //lambda();
        //lambda2();
        //human();
        sort();

    }

    private static void fruits() {
        ObjectBox objectBox = new ObjectBox(new Orange());
        if (objectBox.getObject() instanceof Orange) {
            Orange orange = (Orange) objectBox.getObject();
            System.out.println(orange);
        }

        BoxOnSteroids<Orange> orangeBoxOnSteroids = new BoxOnSteroids<>(new Orange());
        BoxOnSteroids<Apple> appleBoxOnSteroids = new BoxOnSteroids<>(new Apple());
        Orange orange = orangeBoxOnSteroids.getFruit();

    }

    private static void anonymous(){
        SomeInterface someInterface = new SomeInterface() {
            @Override
            public void doSomething() {
                System.out.println("Hej!");
            }
        };

        System.out.println(someInterface.getClass().getName());

        List<String> list = new ArrayList<>();
        list.add("jeden");
        list.add("trzy");
        list.add("cztery");

        // posortuj listę według długości stringa

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        //to samo tylko lambda
        Comparator<String> comparator1 = (o1, o2) -> o1.length() - o2.length();
        System.out.println(comparator1.getClass().getName());
        list.sort(comparator1);



        System.out.println(list);

    }

    private static void lambda(){
        SomeInterface someInterface = () -> System.out.println("Jestem w lambda");
        someInterface.doSomething();

        Function<String, Integer> function = (str) -> str.length();
        System.out.println(function.apply("to jest tekst"));
        //inaczej
        Function<String, Integer> function1 = String::length;
        System.out.println(function1.apply("to jest tekst"));

        Consumer<String> consumer = (str) -> System.out.println(str);
        consumer.accept("123!");
        // to samo
        Consumer<String> consumer2 = System.out::println;
        consumer.accept("123!");

        Consumer<Integer> consumer1 = (i) -> i+=1;
        Integer number = 1;
        consumer1.accept(number);
        System.out.println(number);
        System.out.println();

        Predicate<Integer> isOdd = (i) -> i%2!=0;
        System.out.println(isOdd.test(3));

        Supplier<String> someString = () -> "some return value";
        System.out.println(someString.get());






    }

    private static void lambda2(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        // wersja 1
        Consumer<Integer> integerConsumer = n -> System.out.println(n);
        numbers.forEach(integerConsumer);
        // wersja 2
        Consumer<Integer> consumer = System.out::println;
        numbers.forEach(consumer);
        // wersja 3
        numbers.forEach(System.out::println);
    }

    private static void human(){
        BiFunction<Integer, String, Human> constructor = (i, str) -> new Human(i,str);
        BiFunction<Integer, String, Human> constructor2 = Human::new;

        System.out.println(constructor.apply(20, "Jan"));
        System.out.println(constructor2.apply(40, "Zenon"));

    }

    private static void sort(){
        List<String> names = Arrays.asList("Jan", "Antoni", "Franciszek", "Beata");
        names.sort((s1, s2) -> s2.length() - s1.length());
        System.out.println(names);

        List<String> names1 = Arrays.asList("Jan", "Antoni", "Franciszek", "Beata");
        names1.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println(names1);

        // alfabetycznie
        List<String> names3 = Arrays.asList("Jan", "Antoni", "Franciszek", "Beata");
        names3.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println(names3);

        List<String> names4 = Arrays.asList("Jan", "Antoni", "Franciszek", "Beata");
        names4.sort(String::compareTo);
        System.out.println(names4);



    }
}