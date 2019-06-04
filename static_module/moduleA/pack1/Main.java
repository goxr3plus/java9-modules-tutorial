package pack1;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(String.class.getModule());

        List<String> list = Arrays.asList("l","b","c");
        String a = "m";

		System.err.println(
			Stream.of(list,List.of(a)).
				flatMap(Collection::stream).
				skip(1).
				collect(Collectors.toList()));

    }
}
