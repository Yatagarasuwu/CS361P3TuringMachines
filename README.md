# Project #3: Turing Machines
 
 * Author: Parker Smith, Sabastian Leeper
 * Class: CS361 Section #1
 * Semester: Spring 2025
 
 ## Overview:
 This project implements a Turing Machine simulator in Java. The simulator reads a machine description and an input string from a file, simulates the machine using a bi-infinite tape, and outputs the resulting tape contents.
 
 ## Reflection

 The biggest struggle for this project, funnily enough, was simply understanding Turing Machines in the first place. Once we had a deep enough understanding of how they worked, the implementation came pretty naturally. Our structuring of how we progressed in the project definitely helped with this smoothness. We started with the smaller sections, being the Transition.java (fundamental to start with since it dictates left and right), and Tape.java. Afterwards, we made a small test file to make sure they worked, then moved onwards to the bulk of the project, being TMSimulator. Obviously, TMSimulator was probably the hardest section of the assignemnt, but compared to some of the NFA stuff it wasn't too bad. Overall, I believe our design process was logical and went really well, so I don't think I would change too much for that specifically. Coding the actual logic for the files went well and I believe we both documented our sections in a manner that was easy to understand. All in all, I think the coding for this project was an absolute win.
 
 Honestly, the only concepts that aren't too clear are still related to my understanding of Turing Machines in general. With it coming near the end of the semester, I'm feeling shakier overall during all my lectures as professors are trying to cap out their content before finals. Therefore, if I could go back in time, I think I would tell myself to focus on understanding Turing Machines to a comfortable level *before* starting all sections of the project, instead of implementing files as I went. This isn't to say I didnt have a grasp on them to begin with, but I definitely feel like I have a much stronger grasp as I am typing this compared to starting the project. Otherwise, I believe the concepts that this project is intended to teach are quite clear. The final thing to mention is that I would tell myself to name the folder "TuringMachineStuff" or something else rather than misspelling it and going on...
 
 
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
 The simulator will print the content of the visited tape after halting.  At one point, we had a failsafe: For runs that are too long or non halting machines, the simulator uses a step limit (10,000 steps) to prevent infinite loops and prints a warning if that limit is reached. However, since we talked about it in lecture, this failsafe was removed.
 
 Notes:
 - The machine halts when it reaches the highest-numbered state.
 - Blank tape cells are treated as the symbol 0.
 - Transitions are defined for each state and symbol pair except the halting state.
 
 ## Sources used
 Stack overflow slightly used for Tape section on finding min keys in a Hashmap:
 
 https://stackoverflow.com/questions/36775518/java-stream-find-an-element-with-a-min-max-value-of-an-attribute
 https://stackoverflow.com/questions/72992742/find-min-key-by-value-if-map-contains-keysubstring-here-for-mapstring-doubl/72993201
