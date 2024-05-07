package maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Exercises {
    static Random random = new Random();
    public static void main(String[] args) {
    }
    private static ArrayList<Integer> topFrequentElements(int[] nums, int k) {
        
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for (int nr : nums) {
            if (frequencies.containsKey(nr))
                frequencies.put(nr, frequencies.get(nr) + 1);
            else
                frequencies.put(nr, 1);
        }
        // consider it as a matrix ≈ array of lists
        ArrayList<Integer>[] orderedFreq = new ArrayList[nums.length + 1];
        for (var pair : frequencies.entrySet()) {
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

    
    static boolean containsDuplicate2(int[] nums, int k) {
         // let's save each number as a key and last index as a value
         HashMap<Integer, Integer> map = new HashMap<>();
         for (int i = 0; i < nums.length; i++) {
             if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k))
                 return true;
             map.put(nums[i], i);
         }
         return false;
    }
}
