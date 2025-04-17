package TurningMachineStuff;

public class TempTapeTest {
    public static void main(String[] args) {
        //  test1: Write and Read in Tape
        Tape tape = new Tape();
        tape.write(1); // Write 1 at position 0 
        tape.move('R'); // Move to the right
        tape.write(2); // Write 2 at position 1
        tape.move('L'); // Move back to position 0
        System.out.println(tape.read() == 1 ? "Test 1 Passed" : "Test 1 Failed");

        // test2: Get Visited Tape Content
        tape.move('R'); // Move to position 1
        tape.move('R'); // Move to position 2
        tape.write(4); // Write 3 at position 2
        String visitedContent = tape.getVisitedTapeToString();
        System.out.println("Visited Tape Content: " + visitedContent);
        System.out.println(visitedContent.equals("124") ? "Test 2 Passed" : "Test 2 Failed");
    }
}