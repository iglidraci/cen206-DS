import ADTs.Map;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    static Random random = new Random();
    public static void main(String[] args) {
        Map<String, String> map = new ChainingHashMap<>();
        String[] keys = {"id", "name", "surname", "city", "name", "state", "age", "id"};
        String[] values = {"1", "Foo", "Bar", "Tirana", "Baz", "Iraq", "90", "2"};
        for (int i = 0; i < keys.length; i++){
            map.put(keys[i], values[i]);
        }
        System.out.printf("%s is %s\n", keys[0], map.get(keys[0]));
        System.out.printf("%s is %s\n", keys[1], map.get(keys[1]));
        System.out.printf("%s is %s\n", keys[2], map.get(keys[2]));
        assert map.contains("id");
        map.remove("id");
        assert !map.contains("id");
        System.out.println("=====");
        System.out.println(map);
        testHashSet();
    }

    private static void testHashSet() {
        int total = 1_000_000;

        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> mySet = new HashSet<>(total*2);
        java.util.HashSet<Integer> set = new java.util.HashSet<>(total*2);
        while (total-- > 0) {
            int nr = random.nextInt();
            list.add(nr);
            mySet.add(nr);
            set.add(nr);
        }
        for (int i = 0; i < 10; i++) {
            int nr = random.nextInt();
            long start, finish;
            start = System.currentTimeMillis();
            if (list.contains(nr)) System.out.printf("list found key %s\n", nr);
            finish = System.currentTimeMillis();
            System.out.printf("List time: %o\n", finish - start);
            start = System.currentTimeMillis();
            if (mySet.contains(nr)) System.out.printf("my set found key %s\n", nr);
            finish = System.currentTimeMillis();
            System.out.printf("My set time: %o\n", finish - start);
            start = System.currentTimeMillis();
            if (set.contains(nr)) System.out.printf("set found key %s\n", nr);
            finish = System.currentTimeMillis();
            System.out.printf("set time: %o\n", finish - start);
        }
    }
}
