package TurningMachineStuff;

import java.io.*;
import java.util.*;

/**
 * Turing Machine Simulator for CS361 Project 3.
 * Parses a TM encoding file and simulates the machine on a bi-infinite tape.
 * 
 * @author 
 * Parker Smith, Sabastian Leeper
 */
public class TMSimulator {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java TurningMachineStuff.TMSimulator <inputfile>");
            System.exit(1);
        }

        String filename = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            int numStates = Integer.parseInt(reader.readLine().trim()); 
            // total number of states
            int numSymbols = Integer.parseInt(reader.readLine().trim());
            // number of input symbols, blanks not included

            // Transition table: state -> (input_symbol -> Transition)
            Map<Integer, Map<Integer, Transition>> transitionTable = new HashMap<>();

            // total number of transitions = |Γ| * (|Q| - 1)
            int numTransitions = (numSymbols + 1) * (numStates - 1);
             // +1 includes blank symbol 0
            for (int i = 0; i < numTransitions; i++) {
                String line = reader.readLine();
                if (line == null || line.trim().isEmpty()) continue;
                String[] parts = line.trim().split(",");
                if (parts.length != 3) {
                    System.err.println("Invalid transition line: " + line);
                    continue;
                }

                int fromState = i / (numSymbols + 1);
                int readSymbol = i % (numSymbols + 1);

                int nextState = Integer.parseInt(parts[0]);
                int writeSymbol = Integer.parseInt(parts[1]);
                char move = parts[2].charAt(0);

                transitionTable
                    .computeIfAbsent(fromState, k -> new HashMap<>())
                    .put(readSymbol, new Transition(nextState, writeSymbol, move));
            }

            // Initialize tape
            Tape tape = new Tape();
            String input = reader.readLine();
             // input string could be blank or null

            if (input != null && !input.trim().isEmpty()) {
                for (char c : input.trim().toCharArray()) {
                    tape.write(Character.getNumericValue(c));
                    tape.move('R');
                }
                // move to start of tape
                for (int i = 0; i < input.length(); i++) {
                    tape.move('L');
                }
            }

            // Start simulation
            int currentState = 0;
            int maxSteps = 10000;  // Safety net to prevent infinite loops (adjust as needed)
            int steps = 0;

            while (currentState != (numStates - 1) && steps < maxSteps) {
                int currentSymbol = tape.read();
                Transition transition = transitionTable
                                            .getOrDefault(currentState, new HashMap<>())
                                            .get(currentSymbol);

                if (transition == null) {
                    break;
                     // no defined transition = stop early
                }

                tape.write(transition.getWriteSymbol());
                tape.move(transition.getMoveDirection());
                currentState = transition.getNextState();

                steps++;
            }

            if (steps >= maxSteps) {
                System.err.println("Warning: Max steps exceeded. Possible infinite loop. Halting.");
            }

            // Output content from visited tape
            System.out.println(tape.getVisitedTapeToString());

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            System.exit(1);


        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
