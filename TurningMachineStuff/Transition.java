package TurningMachineStuff;

/*
 * Simple transition class to be honest. Template right now but probably wont change much. First class made. 
 * @Author Sabastian Leeper, Parker Smith
 * @Date Spring 2025
 */
public class Transition {
    private int nextState;
    private int writeSymbol;
    private char moveDirection; // l = left / r = right

    public Transition(int nextState, int writeSymbol, char moveDirection) {
        this.nextState = nextState;
        this.writeSymbol = writeSymbol;
        this.moveDirection = moveDirection;
    }

    public int getNextState() {
        return nextState;
    }

    public int getWriteSymbol() {
        return writeSymbol;
    }

    public char getMoveDirection() {
        return moveDirection;
    }
}