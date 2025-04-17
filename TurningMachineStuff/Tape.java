package TurningMachineStuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tape {
    private HashMap<Integer, Integer> tape; // I like hashmaps and it makes sense here
    private int headPosition;

    public Tape() {
        this.tape = new HashMap<>();
        this.headPosition = 0;
    }

    public int read() {
        return tape.getOrDefault(headPosition, 0); // default blank case
    }

    public void write(int symbol) {
        tape.put(headPosition, symbol);
    }

    public void move(char direction) {
        if (direction == 'L') {
            headPosition--;
        } else if (direction == 'R') {
            headPosition++;
        }
    }

    /*
     * This method retrieves the content of the tape that has been visited. 
     * It is a list-based implementation but can be reworked at some point if we need.
     * It determines the range of visited positions by finding the minimum
     * and maximum keys in the `tape` map, which represent the leftmost
     * and rightmost positions visited.
     *
     * The symbols are collected into a list as strings, and then joined
     * together into a single string representing the visited tape content.
     *
     *  (temp) I can't lie, I had to look up a bit for the min/max sections. Its a bit weird for sure. 
     * 
     * @Return 
     * - A string containing the visited symbols in order.
     */ 
    String getVisitedTapeToString() {
    int min = tape.keySet().stream().min(Integer::compare).orElse(0); //  
    int max = tape.keySet().stream().max(Integer::compare).orElse(0);

    List<String> content = new ArrayList<>();
    for (int i = min; i <= max; i++) {
        content.add(String.valueOf(tape.getOrDefault(i, 0)));
    }

    return String.join("", content);
}
}