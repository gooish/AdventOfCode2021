import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * AoC
 */
public class AoC {

    public static void main(String[] args) {
        System.out.println("Advent Of Code 2021");
        System.out.println(day1part1());
        System.out.println(day1part2());
    }

    /* 
    *    .__           .__                            _____                    __  .__                      
    *    |  |__   ____ |  | ______   ___________    _/ ____\_ __  ____   _____/  |_|__| ____   ____   ______
    *    |  |  \_/ __ \|  | \____ \_/ __ \_  __ \   \   __\  |  \/    \_/ ___\   __\  |/  _ \ /    \ /  ___/
    *    |   Y  \  ___/|  |_|  |_> >  ___/|  | \/    |  | |  |  /   |  \  \___|  | |  (  <_> )   |  \\___ \ 
    *    |___|  /\___  >____/   __/ \___  >__|       |__| |____/|___|  /\___  >__| |__|\____/|___|  /____  >
    *        \/     \/     |__|        \/                         \/     \/                    \/     \/ 
    */

    static String[] readLines(String fileName) {
        try {
            String rowsString = "";
            File dataFile = new File("Day1.txt");
            Scanner dataScanner = new Scanner(dataFile);
            while (dataScanner.hasNextLine()) {
                rowsString = rowsString + dataScanner.nextLine() + ",";
            }

            dataScanner.close();
            return rowsString.split(",");

        } catch (FileNotFoundException e) {
            System.out.println(fileName + " File missing");
            return null;
        }
    }

    static int[] toInts(String[] strings) {
        int[] toReturn = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            toReturn[i] = Integer.parseInt(strings[i]);
        }
        return toReturn;
    }

    /*
    *        .___                    
    *    __| _/____  ___.__. ______
    *    / __ |\__  \<   |  |/  ___/
    *    / /_/ | / __ \\___  |\___ \ 
    *    \____ |(____  / ____/____  >
    *        \/     \/\/         \/ 
    *
    */




    static int day1part1() {
        int counter = 0;
        int[] numbers = toInts(readLines("Day1.txt"));
        for (int i =  1; i < numbers.length; i++) {
            if (numbers[i] > numbers[i -1]) {
                counter++;
            }
        }

        return counter;

    }

    static int day1part2() {
        int counter = 0;
        int previousSum = 999999999;
        int[] numbers = toInts(readLines("Day1.txt"));

        for (int i =  0; i < numbers.length - 2; i++) {
            int currentSum = numbers[i] + numbers[i+1] + numbers[i+2];
            if (currentSum > previousSum) {
                counter++;
            }
            previousSum = currentSum;
        }
        return counter;
    }
}