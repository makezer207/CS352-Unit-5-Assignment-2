import java.io.FileNotFoundException;
/**
 Mitchell Kezer
 CS352 Unit 5 Assignment 2
 11/22/2026
 */
public class WeatherDriver {

	public static void main(String[] args) {
		System.out.println("Starting simulation");

		String fileName = "weather.txt";

		try { 
			WeatherReport cityCollections = new WeatherReport(fileName);
			WeatherReport cityMerge = new WeatherReport(fileName);
			WeatherReport highTempCollections = new WeatherReport(fileName);
			WeatherReport highTempMerge = new WeatherReport(fileName);

			System.out.println("City Collections Sort: " + !cityCollections.isSortedByCity());
			System.out.println("City Merge Sort: " + !cityMerge.isSortedByCity());
			System.out.println("High Temp Collections Sort: " + !highTempCollections.isSortedByHigh());
			System.out.println("High Temp Merge Sort: " + !highTempMerge.isSortedByHigh());

			long startTime = System.nanoTime();
			cityCollections.sortWithCollections("City");
			long collectionsCityTime = System.nanoTime() - startTime;

			startTime = System.nanoTime();
			cityMerge.sortWithMerge("City");
			long mergeCityTime = System.nanoTime() - startTime;

			startTime = System.nanoTime();
			highTempCollections.sortWithCollections("High");
			long collectionsHighTempTime = System.nanoTime() - startTime;

			startTime = System.nanoTime();
			highTempMerge.sortWithMerge("High");
			long mergeHighTempTime = System.nanoTime() - startTime;

            System.out.println("\nSorting Times (in milliseconds):");
			System.out.println("City Collections Time: " + collectionsCityTime / 1_000_000.0);
			System.out.println("City Merge Time: " + mergeCityTime / 1_000_000.0);
			System.out.println("High Temp Collections Time: " + collectionsHighTempTime / 1_000_000.0);
			System.out.println("High Temp Merge Time: " + mergeHighTempTime / 1_000_000.0);

			System.out.println("\nSorted correctly");
			System.out.println("Collections by City: " + cityCollections.isSortedByCity());
            System.out.println("Merge sort by City: " + cityMerge.isSortedByCity());
            System.out.println("Collections by High: " + highTempCollections.isSortedByHigh());
            System.out.println("Merge sort by High: " + highTempMerge.isSortedByHigh());

		} 
		catch (FileNotFoundException e ) {
			System.out.println("Can't find file " + fileName); 
		}
		catch (Exception e) {
			System.out.println("Other error: " + e.getMessage());
		}

		System.out.println("Finished simulation");
	}

}
