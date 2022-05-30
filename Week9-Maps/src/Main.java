import ADTs.Cache;
import ADTs.KeyValue;
import ADTs.Map;
import ADTs.Set;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    static Random random = new Random();
    public static void main(String[] args) {
//        testHashMap();
//        testHashSet();
//        testSpeed();
        try{
          testContainsDuplicate2();
          // testLongestUniqueSubstring();
          // testTopFrequentElements();
          // testLRUCache();
        } catch (AssertionError err) {
          System.out.println(err.getMessage());
        }
    }

    private static void testLRUCache() {
        /*
        * ["init", "put", "put", "get", "put", "get", "put",  "get",  "get",   "get"]
            [[2], [1, 1], [2, 2], [1], [3, 3], [2],   [4, 4],  [1],    [3],     [4]]
            [void, void,    void,  1,   void,  null,  void,   null,     3,       4]
        */
        int capacity = 2;
        Cache<Integer, Integer> cache = new DoubleLinkedLRU<>(capacity);
        cache.put(1, 1);
        cache.put(2, 2);
        assert cache.get(1) == 1;
        cache.put(3, 3);
        assert cache.get(2) == null;
        cache.put(4, 4);
        assert cache.get(1) == null;
        assert cache.get(3) == 3;
        assert cache.get(4) == 4;
    }

    private static void testTopFrequentElements() {
        int[] nums; int k;
        nums = new int[] {1,1,1,2,2,3,3,3}; k = 2;
        Set<Integer> answer = new HashSet<>();
        for(int nr : topFrequentElements(nums, k))
            answer.add(nr);
        assert (answer.contains(1) && answer.contains(3)) :
        "TopFrequentElements failed -> nums = {1,1,1,2,2,3,3,3}; k = 2 should return [1, 3], returned " + answer;
        nums = new int[] {1,2};
        answer = new HashSet<>();
        for (int nr : topFrequentElements(nums, k))
            answer.add(nr);
        assert (answer.contains(1) && answer.contains(2)) :
        "TopFrequentElements failed -> nums = {1,2}; k = 2 should return [1, 2], returned " + answer;
        nums = new int[] {1, 2, 2, 2, 1, 1, 1, 4, 4, 4, 2, 5, 5}; k = 3;
        answer = new HashSet<>();
        for (int nr : topFrequentElements(nums, k))
            answer.add(nr);
        assert (answer.contains(1) && answer.contains(2) && answer.contains(4)) :
        "TopFrequentElements failed -> nums = {1,2}; k = 2 should return [1, 2, 5], returned " + answer;
    }

    private static ArrayList<Integer> topFrequentElements(int[] nums, int k) {
        // write your solution here
        return new ArrayList<Integer>();
    }

    private static void testLongestUniqueSubstring() {
        String str = "abcabcbb";
        int answer;
        answer = longestUniqueSubstring(str);
        assert answer == 3 : "LongestUniqueSubstring failed -> str = \"abcabcbb\" should be 3, your answer is " + answer;
        str = "bbbbb";
        answer = longestUniqueSubstring(str);
        assert answer == 1 : "LongestUniqueSubstring failed -> str = \"bbbbb\" should be 1, your answer is " + answer;
        str = "pwwkew";
        answer = longestUniqueSubstring(str);
        assert answer == 3 : "LongestUniqueSubstring failed -> str = \"pwwkew\", should be 3, your answer is " + answer;
        str = "dvdf";
        answer = longestUniqueSubstring(str);
        assert answer == 3 : "LongestUniqueSubstring failed -> str = \"dvdf\", should be 3, your answer is " + answer;
    }

    private static int longestUniqueSubstring(String str) {
        // write your solution here
        return 0;
    }

    private static void testContainsDuplicate2() {
        int[] nums; int k;
        nums = new int[] {1,2,3,1}; k = 3;
        assert containsDuplicate2(nums, k) : "ContainsDuplicate2 failed -> nums = {1,2,3,1}; k = 3";
        nums = new int[] {1,0,1,1}; k = 1;
        assert containsDuplicate2(nums, k) : "ContainsDuplicate2 failed -> nums = {1,0,1,1}; k = 1";
        nums = new int[] {1,2,3,1,2,3}; k = 2;
        assert !containsDuplicate2(nums, k) : "ContainsDuplicate2 failed -> nums = {1,2,3,1,2,3}; k = 2";
    }
    static boolean containsDuplicate2(int[] nums, int k) {
        // write your solution here
        return false;
    }

    private static void testHashSet() {
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
        System.out.printf("Initial numbers: %s\n", numbers);
        numbers.removeWhere(x -> x % 2 == 0 && x > 5);
        System.out.printf("Odd or <= 5: %s\n", numbers);
        HashSet<Integer> evenNumbers = new HashSet<>();
        for (int i = 1; i <= 5; i++) {
            evenNumbers.add(2*i);
        }
        System.out.printf("Even Numbers: %s\n", evenNumbers);
        numbers.unionWith(evenNumbers);
        System.out.printf("All Numbers: %s\n", numbers);
        numbers.subtractWith(evenNumbers);
        System.out.printf("Odd numbers: %s\n", numbers);
        numbers.intersectWith(evenNumbers);
        System.out.printf("Odd and even numbers: %s\n", numbers);
    }

    private static void testHashMap() {
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
    }

    private static void testSpeed() {
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
