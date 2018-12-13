package own;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streamtest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        Stream<Integer> stream = list.stream();
        List<Integer> list2 = stream.collect(Collectors.toList());
        return;
    }

}
