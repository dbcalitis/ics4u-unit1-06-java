/*
* This is a program that calculates mean, median and mode
* after reading in a text file into an array.
*
* @author  Daria Bernice Calitis
* @version 1.0
* @since   2022-09-29
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// import java.util.HashMap;
// import java.util.Map;

/**
* This is the statistics program.
*/
final class Average {

    /**
    * Prevent instantiation
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private Average() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * The mean() function.
    *
    * @param arrayOfIntegers the collection of integers
    * @return the mean of the integers
    */
    public static double mean(final Integer[] arrayOfIntegers) {
        double mean = 0;
        final int arrLen = arrayOfIntegers.length;

        for (int count = 0; count < arrLen; count++) {
            mean += arrayOfIntegers[count];
        }

        mean /= arrLen;

        return mean;
    }

    /**
    * The median() function.
    *
    * @param arrayOfIntegers the collection of integers
    * @return the median of the integers
    */
    public static double median(final Integer[] arrayOfIntegers) {
        Arrays.sort(arrayOfIntegers);
        final int arrLen = arrayOfIntegers.length;
        double returnValue = 0;

        // Checks if the array length is even or odd.
        // If it's even, it will calculate the mean of 2 middle numbers.
        if (arrLen % 2 == 0) {
            final Integer[] midNums = {
                    arrayOfIntegers[arrLen / 2],
                    arrayOfIntegers[arrLen / 2 - 1],
            };
            returnValue = mean(midNums);
        } else {
            returnValue = arrayOfIntegers[arrLen / 2];
        }

        return returnValue;
    }

    /**
    * The mode() function.
    *
    * @param numbers the collection of integers
    * @return the mode of the integers
    */
    public static List<Integer> mode(final Integer[] numbers) {
        final List<Integer> modes = new ArrayList<>();
        return modes;
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        Integer tempNumber;
        System.out.println(args);
        final ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        final Path filePath = Paths.get("./", args[0]);
        final Charset charset = Charset.forName("UTF-8");

        try (BufferedReader reader = Files.newBufferedReader(
                                     filePath, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                tempNumber = Integer.parseInt(line);
                listOfNumbers.add(tempNumber);
            }
        } catch (IOException errorCode) {
            System.err.println(errorCode);
        }

        final Integer[] arrayOfNumbers = listOfNumbers.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arrayOfNumbers));

        System.out.println("\nCalculating stats...");
        final double mean = mean(arrayOfNumbers);
        final double median = median(arrayOfNumbers);
        // final List<Integer> mode = mode(arrayOfNumbers);

        System.out.println("The mean is: " + mean);
        System.out.println("The median is: " + median);

        /*
        System.out.println("The mode(s) is/are: "
                            + Arrays.toString(mode.toArray()));
        */

        System.out.println("\nDone.");
    }
}
