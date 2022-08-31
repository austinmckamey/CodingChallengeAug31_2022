import java.util.*;
import java.io.*;


public class Tictactoe {

//Storage of gameboard information
private Vector<String> board = new Vector<String>(9);
private List<Integer> computerOptions = new ArrayList<>();

//Called upon starting program, controls all other method calls
private void runGame() {

System.out.println("Welcome to Tic Tac Toe!\nGood Luck!!");

makeBoard();
displayBoard();

System.out.print("Would you like to go first? Y or N.\n");
String input = getUserInputYN();

boolean gameRunning = true;
if(input.charAt(0) == 'Y') {
while(gameRunning) {
playerMoves();
gameRunning = checkWinCondition();
if(!gameRunning) {
break;
}
computerMoves();
gameRunning = checkWinCondition();
}
}
else {
while(gameRunning) {
computerMoves();
gameRunning = checkWinCondition();
if(!gameRunning) {
break;
}
playerMoves();
gameRunning = checkWinCondition();
}
}
System.out.print("Would you like to play again? Y or N.\n");
input = getUserInputYN();
if(input.charAt(0) == 'Y') {
runGame();
}
}

//Reads input from console
private int getUserMove() {
Scanner sc = new Scanner(System.in);
int move = sc.nextInt();
if(!board.contains(String.valueOf(move))) {
System.out.print("Invalid input, try again!\n");
move = getUserMove();
}
return move;
}

//Updates board with player input
private void playerMoves() {
System.out.print("Your turn, enter an available number between 1 & 9:\n");
int input = getUserMove();
int index = input - 1;
board.set(index,"X");
updateComputerOptions(input);
displayBoard();
}

//Selects computer input
private int getComputerMove() {
Random rand = new Random();
return computerOptions.get(rand.nextInt(computerOptions.size()));
}

//Updates board with computer input
private void computerMoves() {
int input = getComputerMove();
int index = input - 1;
board.set(index,"O");
updateComputerOptions(input);
System.out.print("Computer's turn, they selected " + input + "\n");
displayBoard();
}

//Updates options for computer from board information
private void updateComputerOptions(int input) {
for(int i = 0; i < computerOptions.size(); i++) {
if(computerOptions.get(i) == input) {
computerOptions.remove(i);
}
}
}

//Checks if game is over
private boolean checkWinCondition() {
if(computerOptions.size() == 0) { //All available spaces are taken
System.out.print("It is a tie!\n");
return false;
}
if((board.get(0) == board.get(1) && board.get(0) == board.get(2) && board.get(0) == "X") 
|| (board.get(3) == board.get(4) && board.get(3) == board.get(5) && board.get(3) == "X") 
|| (board.get(6) == board.get(7) && board.get(6) == board.get(8) && board.get(6) == "X") 
|| (board.get(0) == board.get(3) && board.get(0) == board.get(6) && board.get(0) == "X") 
|| (board.get(1) == board.get(4) && board.get(1) == board.get(7) && board.get(1) == "X") 
|| (board.get(2) == board.get(5) && board.get(2) == board.get(8) && board.get(2) == "X")
|| (board.get(0) == board.get(4) && board.get(0) == board.get(8) && board.get(0) == "X")
|| (board.get(2) == board.get(4) && board.get(2) == board.get(6) && board.get(2) == "X")) { 
System.out.print("You won! Great job!\n");
return false;
}
if((board.get(0) == board.get(1) && board.get(0) == board.get(2) && board.get(0) == "O") 
|| (board.get(3) == board.get(4) && board.get(3) == board.get(5) && board.get(3) == "O") 
|| (board.get(6) == board.get(7) && board.get(6) == board.get(8) && board.get(6) == "O") 
|| (board.get(0) == board.get(3) && board.get(0) == board.get(6) && board.get(0) == "O") 
|| (board.get(1) == board.get(4) && board.get(1) == board.get(7) && board.get(1) == "O") 
|| (board.get(2) == board.get(5) && board.get(2) == board.get(8) && board.get(2) == "O")
|| (board.get(0) == board.get(4) && board.get(0) == board.get(8) && board.get(0) == "O")
|| (board.get(2) == board.get(4) && board.get(2) == board.get(6) && board.get(2) == "O")) { 
System.out.print("Yikes! The computer won!\n");
return false;
}
return true;
}

//Gets user input and checks whether it is valid Y or N
private String getUserInputYN() {
Scanner sc = new Scanner(System.in);
String input = sc.next();
if(input.length() != 1 || input.charAt(0) != 'Y' && input.charAt(0) != 
'N') {
System.out.print("Invalid input, try again!\n");
input = getUserInputYN();
}
return input;
}

//Populates board information and computer options
private void makeBoard() {
board.clear(); //In case of a game restart
board.add("1");
board.add("2");
board.add("3");
board.add("4");
board.add("5");
board.add("6");
board.add("7");
board.add("8");
board.add("9");

if(computerOptions.size() != 0) {
computerOptions.clear(); //In case of a game restart
}
computerOptions.add(1);
computerOptions.add(2);
computerOptions.add(3);
computerOptions.add(4);
computerOptions.add(5);
computerOptions.add(6);
computerOptions.add(7);
computerOptions.add(8);
computerOptions.add(9);
}

//Displays board on console
private void displayBoard() {
System.out.print("\n" + board.elementAt(0) + " " + board.elementAt(1) + 
		" " + board.elementAt(2) + "\n" + board.elementAt(3) +
		" " + board.elementAt(4) + " " + board.elementAt(5) + 
		"\n" + board.elementAt(6) + " " + board.elementAt(7) + 
		" " + board.elementAt(8) + "\n\n");
}

//Main function, calls runGame() method
public static void main(String[] args) {
new Tictactoe().runGame();
}
}
