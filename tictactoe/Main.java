package tictactoe;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char turn = 'X';
        char [] symbolsC = new char[9];
        Arrays.fill(symbolsC, '_');
        print(symbolsC);

        while (checkStatus(symbolsC)) {
            int x, y, position;
            String str;
            do {
                System.out.print("Enter the coordinates: ");
                str = scanner.nextLine().trim();
                if (!(str.length() == 3 && str.charAt(0) >= '0'
                        && str.charAt(0) <= '9' && str.charAt(1) == ' '
                        && str.charAt(2) >= '0' && str.charAt(2)  <= '9')) {
                    System.out.println("You should enter numbers!");
                    continue;
                }
                x = (int) str.charAt(0) - 48;
                y = (int) str.charAt(2) - 48;

                if (!(x < 4 && y < 4 && x > 0 && y > 0)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                position =  (3 - y) * 3 + x - 1;
                if (!(symbolsC[(3 - y) * 3 + x - 1] == '_')) {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                break;

            } while (true);

            symbolsC[position] = turn;
            if (turn == 'X') {
                turn = 'O';
            } else {
                turn = 'X';
            }
            print(symbolsC);

        }

    }

    public  static  boolean checkStatus(char[] symbolsC) {
        boolean finished = true;
        for (char c :
                symbolsC) {
            if (c == '_') {
                finished = false;
            }
        }
//        if (!isPossible(symbolsC)) {
//            System.out.println("Impossible");
//        } else {
            if (isWin(symbolsC, 'X')) {
                System.out.println("X wins");
            } else if (isWin(symbolsC, 'O')) {
                System.out.println("O wins");
            } else if  (!finished) {
//                System.out.println("Game not finished");
                return true;
            } else {
                System.out.println("Draw");
            }
//    }
        return false;
    }

    public static boolean isPossible(char[] symbols) {
        int countX = 0;
        int countO = 0;
        if (isWin(symbols, 'X') && isWin(symbols, 'O')) {
            return false;
        }
        for (int i = 0; i < 9; i++) {
            if ('X' == symbols[i]) {
                countX++;
            } else if ('O' == symbols[i]) {
                countO++;
            }
        }
        if (Math.abs(countO - countX) > 1) {
            return false;
        }

        return true;
    }

    public static boolean isWin(char[] symbols, char c) {

        if(c == symbols[0]) {
            if (c == symbols[1] && c == symbols[2]) {
                return true;
            }
            if (c == symbols[4] && c == symbols[8]) {
                return true;
            }
            if (c == symbols[3] && c == symbols[6]) {
                return true;
            }
        }

        if(c == symbols[3]) {
            if (c == symbols[4] && c == symbols[5]) {
                return true;
            }
        }

        if(c == symbols[6]) {
            if (c == symbols[7] && c == symbols[8]) {
                return true;
            }
            if (c == symbols[4] && c == symbols[2]) {
                return true;
            }
        }

        if(c == symbols[1]) {
            if (c == symbols[4] && c == symbols[7]) {
                return true;
            }
        }

        if(c == symbols[2]) {
            if (c == symbols[5] && c == symbols[8]) {
                return true;
            }
        }
        return false;
    }

    public  static  void  print(char[] symbols) {
        System.out.println("---------");
        for (int i = 0; i < 9; i++ ) {
            if (i % 3 == 0) {
                System.out.print("| ");
            }
            System.out.print(symbols[i] + " ");
            if (i % 3 == 2) {
                System.out.print("|\n");
            }
        }
        System.out.println("---------");
    }


}
