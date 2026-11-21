import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.Comparator;
import java.util.LinkedList;
import java.io.FileNotFoundException;

/**
 * Mitchell Kezer
 CS352 Unit 5 Assignment 2
 11/22/2026
 */
public class WeatherReport {

    private LinkedList<Temperature> temperatures;

    public WeatherReport() {
        temperatures = new LinkedList<>();

        temperatures.add(new Temperature("New York", "NY", 30, 80));
        temperatures.add(new Temperature("Los Angeles", "CA", 50, 80));
        temperatures.add(new Temperature("Chicago", "IL", 20, 80));
        temperatures.add(new Temperature("Houston", "TX", 40, 60));
        temperatures.add(new Temperature("Phoenix", "AZ", 60, 80));
        temperatures.add(new Temperature("Philadelphia", "PA", 30, 50));
        temperatures.add(new Temperature("San Antonio", "TX", 40, 60));
        temperatures.add(new Temperature("San Diego", "CA", 50, 70));
    }

    public WeatherReport(String fileName) throws FileNotFoundException {
        temperatures = new LinkedList<>();

        try (Scanner input = new Scanner(new File(fileName))) {
            if (input.hasNextLine()) {
                input.nextLine(); // Skip the header row
            }

            while (input.hasNextLine()) {
                String line = input.nextLine();

                if (!line.trim().isEmpty()) {
                    String[] fields = line.split(",");

                    String city = fields[1].trim();
                    int high = Integer.parseInt(fields[5].trim());
                    int low = Integer.parseInt(fields[6].trim());
                    String state = fields[10].trim();

                    temperatures.add(new Temperature(city, state, low, high));
                }
            }
        }
    }

    public boolean isSortedByCity() {
        for (int i = 0; i < temperatures.size() - 1; i++) {
            if (temperatures.get(i).getCity().compareTo(temperatures.get(i + 1).getCity()) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isSortedByHigh() {
        for (int i = 0; i < temperatures.size() - 1; i++) {
            if (temperatures.get(i).getHigh() > temperatures.get(i + 1).getHigh()) {
                return false;
            }
        }
        return true;
    }

    public void sortWithCollections(String sortBy) {
        if (sortBy.equalsIgnoreCase("City")) {
            Collections. sort(temperatures, new SortByCity());
        }
        else if (sortBy.equalsIgnoreCase("High")) {
            Collections.sort(temperatures, new SortByHigh());
        }
        else {
            throw new IllegalArgumentException("Sort by City or High Temperature");
        }
    }
}

/*
 * Comparator to sort by the city stored in a Temperature object
 */
class SortByCity implements Comparator<Temperature> {
    // Used for sorting in ascending order of City
    public int compare(Temperature t1, Temperature t2)
    {
        return t1.getCity().compareTo(t2.getCity());
    }
}

/*
 * Comparator to sort by the high temperature stored in a Temperature object
 */
class SortByHigh implements Comparator<Temperature> {
    // Used for sorting in ascending order of high temperature
    public int compare(Temperature t1, Temperature t2)
    {
        return t1.getHigh() - t2.getHigh();
    }
}