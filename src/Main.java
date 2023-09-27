import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in;
        try {
            in = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        int[] seriesLength = new int[n];

        for (int i = 0; i < n; i++) {

            int length = 1;

            for (int j = 0; j < m; j++) {
                if (j != 0 && matrix[i][j] == matrix[i][j - 1])
                    length++;
                if (length > seriesLength[i])
                    seriesLength[i] = length;
                else
                    length = 1;
            }
        }

        int maxElement = 0;

        for (int i = 0; i < n; i++) {
            if (seriesLength[i] > maxElement)
                maxElement = seriesLength[i];
        }

        if (maxElement == 1)
        {
            System.out.println("No such lines");
            System.exit(0);
        }

        System.out.print("Lines with longest series: " + " ");
        for (int i = 0; i < n; i++) {
            if (seriesLength[i] == maxElement)
                System.out.print(i + 1 + " ");
        }
    }
}