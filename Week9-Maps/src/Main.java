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
        // ChainingHashMap is a custom class
        // use Java HashMap instead since you won't have enough time in exam to write ChainingHashMap class
        // re-write all the solutions using java.util.HashMap, little will change
    }
    private static ArrayList<Integer> topFrequentElements(int[] nums, int k) {
        
        Map<Integer, Integer> frequencies = new ChainingHashMap<>();
        for (int nr : nums) {
            if (frequencies.contains(nr))
                frequencies.put(nr, frequencies.get(nr) + 1);
            else
                frequencies.put(nr, 1);
        }
        // consider it as a matrix ≈ array of lists
        ArrayList<Integer>[] orderedFreq = new ArrayList[nums.length + 1];
        for (KeyValue<Integer, Integer> pair : frequencies.items()) {
            // the most frequent elements will be placed on the right
            if (orderedFreq[pair.getValue()] == null)
                orderedFreq[pair.getValue()] = new ArrayList<>();
            orderedFreq[pair.getValue()].add(pair.getKey()); // since might be different numbers with the same frequency
        }
        ArrayList<Integer> top = new ArrayList<>();
        int i = 0;
        for (int j = orderedFreq.length - 1; j >= 0; j--) {
            if (i >= k) break;
            if (orderedFreq[j] != null) {
                top.addAll(orderedFreq[j]);
                i += orderedFreq[j].size();
            }
        }
        return top;
    }

    
    private static int longestUniqueSubstring(String str) {
        Set<Character> chars = new HashSet<>();
        int left = 0, right = 0; // two pointers, left and right
        int longest = 0;
        while (right != str.length()) { // while we haven't reached the end of the string
            if (!chars.contains(str.charAt(right))) {
                chars.add(str.charAt(right));
                right++;
            } // if right char is unique in the currently checked substring
            else {
                chars.remove(str.charAt(left));
                left++;
            }
            longest = Math.max(longest, chars.size());
        }
        return longest;
    }

    
    static boolean containsDuplicate2(int[] nums, int k) {
         // let's save each number as a key and last index as a value
         Map<Integer, Integer> map = new ChainingHashMap<>();
         for (int i = 0; i < nums.length; i++) {
             if (map.contains(nums[i]) && (i - map.get(nums[i]) <= k))
                 return true;
             map.put(nums[i], i);
         }
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
