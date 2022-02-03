
import java.util.Scanner;
public class Cinema {
    public static void printCinema(char[][] cinema, int numRows, int numSeats) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 0; i < numSeats; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < numRows; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < numSeats; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int buyTicket(char[][] cinema,int numRows,int numSeats) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int numRow = 0;
        int numSeat = 0;
        while (flag) {
            System.out.println("Enter a row number:");
            numRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            numSeat = scanner.nextInt();

            if (numRow < 0 || numSeat < 0 || numRow > numRows || numSeat > numSeats) {
                System.out.println("Wrong input!");
            } else if (cinema[numRow-1][numSeat-1] == 'B') {
                System.out.println("That ticket has already been purchased!");
            } else {
                cinema[numRow-1][numSeat-1] = 'B';
                flag = false;
            }
        }

        int numAllSeats = numSeats * numRows;
        //System.out.println("Total income:");
        if (numAllSeats <= 60) {
            System.out.println("Ticket price: $10");
            return 10;
        } else {
            int halfHall = numRows / 2 * numSeats;
            //System.out.println("$" + (halfHall * 10 + (numAllSeats - halfHall) * 8));
            int sum = numSeats * (numRow - 1) + numSeat;
            if(sum <= halfHall) {
                System.out.println("Ticket price: $10");
                return 10;
            } else {
                System.out.println("Ticket price: $8");
                return 8;
            }
        }
    }
    public static void statistics(int numRows, int numSeats, int buys, int cost) {
        int numAllSeats = numSeats * numRows;
        int totalIncome = 0;
        final int price1 = 10;
        final int price2 = 8;
        if (numAllSeats <= 60) {
            totalIncome = numAllSeats * price1;
        } else {
            int halfHall = numRows / 2 * numSeats;
            //System.out.println("$" + (halfHall * 10 + (numAllSeats - halfHall) * 8));
            totalIncome = halfHall * price1 + (numAllSeats - halfHall) * price2;
        }
        double percentage = (double)buys / (double)numAllSeats * 100;
        System.out.println("Number of purchased tickets:" + buys);
        System.out.printf("Percentage: %.2f%%",percentage);
        System.out.printf("Current income: $%d",cost);
        System.out.printf("Total income: $%d",totalIncome);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numSeats = scanner.nextInt();
        char[][] cinema = new char[numRows][numSeats];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numSeats; j++) {
                cinema[i][j] = 'S';
            }
        }
        int buys = 0;
        int cost = 0;
        boolean flag = true;
        while (flag) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int numMenu = scanner.nextInt();
            switch (numMenu) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    printCinema(cinema,numRows,numSeats);
                    break;
                case 2:
                    cost += buyTicket(cinema,numRows,numSeats);
                    buys++;
                    break;
                case 3:
                    statistics(numRows,numSeats,buys,cost);
                    break;
            }
        }

        //printCinema(cinema,numRows,numSeats);
        //buyTicket(cinema,numRows,numSeats);
        //printCinema(cinema,numRows,numSeats);

    }
}
