# CS361P3TuringMachines

## Overview:
This project implements a Turing Machine simulator in Java. The simulator reads a machine description and an input string from a file, simulates the machine using a bi-infinite tape, and outputs the resulting tape contents.

## Files:
- Tape.java: Implements the tape structure using a HashMap and manages read, write, and head movement operations.
- Transition.java: Represents a transition with a next state, symbol to write, and direction to move.
- TMSimulator.java: The main simulator. Reads the machine definition, builds the transition table, runs the simulation, and prints the output.
- TempTapeTest.java: A small test class to verify that the Tape implementation behaves correctly.
- BB3.txt, file0.txt, file2.txt, file5.txt: Test input files for running the simulator.

## How to Compile:
Open a terminal in the project root directory (the one containing the TurningMachineStuff folder) and run:

    javac TurningMachineStuff/*.java

## How to Run:
Run the simulator with one of the provided input files:

    java TurningMachineStuff.TMSimulator BB3.txt

## Expected Output:
The simulator will print the content of the visited tape after halting. For runs that are too long or non halting machines, the simulator uses a step limit (10,000 steps) to prevent infinite loops and prints a warning if that limit is reached.

Notes:
- The machine halts when it reaches the highest-numbered state.
- Blank tape cells are treated as the symbol 0.
- Transitions are defined for each state and symbol pair except the halting state.
