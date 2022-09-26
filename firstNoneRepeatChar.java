package com.company.models;

import java.util.HashMap;
import java.util.Map;

public class firstNoneRepeatChar {
    public static void main(String[] args) {
        // "A Green Apple" ==> only G is not repeated here
        // a green apple
        // hash table (python dictionaries) are a good data structure for look-up.// Our hash table is gonna look like this:
        // a = 2 (two a's in the given string)
        //  = 2 (white space repeated twice)
        // g = 1
        // we create a hashtable. if a character has a value of more than one we just ignore and then go to next

        firstNoneRepeatChar finder = new firstNoneRepeatChar();
        char ch = finder.findFirstNonRepeatingChar("a green apple");
        System.out.println(ch);
    }

    public char findFirstNonRepeatingChar(String str) {
        // keys: characters, Values: integers
        Map<Character, Integer> map = new HashMap<>();

        // in java we can not iterate over a string so:
        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                map.put(ch, count + 1);
            } else
                map.put(ch, 1);
        }

        // Alternatively could use the ternary operator instead:
        //int count = map.containsKey(ch) ? map.get(ch) : 0;
        // map.put(ch, count + 1)
        for (char ch : str.toCharArray()) {
            if (map.get(ch) == 1)
                return ch;
        }

        //System.out.println(map);
        // here is the map: { =2, p=2, a=2, r=1, e=3, g=1, l=1, n=1}
        return Character.MIN_VALUE;
    }
}
