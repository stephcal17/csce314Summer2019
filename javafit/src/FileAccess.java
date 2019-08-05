// This file gives access to the underlying datafile and stores the data in the Workout class.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Scanner;

public class FileAccess {

	public static Workouts loadWorkouts() {
		Workouts retval = new Workouts();

		try {
			Scanner scanner = new Scanner(new File(Config.WORKOUTFILE));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] fields = line.split(",");
				// Check to make sure glen didn't bork the data file.
				if (fields.length != 6)
					System.out.println("Line has " + fields.length + " fields instead of 6. Check your commas.");
				String name = fields[0];
				Config.Equipment equipment = Config.Equipment.valueOf(fields[1]);
				Config.Muscle primaryMuscle = Config.Muscle.valueOf(fields[2]);
				Config.Muscle secondaryMuscle = Config.Muscle.valueOf(fields[3]);
				String desc = fields[4];
				String reminders = fields[5];
				retval.addWorkout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find workouts file. Is it in the same directory as the executable?\nError:"
					+ e.toString());
		}
		return retval;
	}

	public static EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> loadFormats() {

		EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> retval = new EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>>(
				Config.MuscleGroup.class);

		// Code goes here.
		try {
			Scanner scanner = new Scanner(new File(Config.WORKOUTFORMATFILE));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] fields = line.split(",");
				Config.MuscleGroup key = Config.MuscleGroup.valueOf(fields[0]);
				ArrayList<Config.Muscle> modifiedFields = new ArrayList<Config.Muscle>();
				for (int i = 1; i < fields.length; i++) {
					modifiedFields.add(Config.Muscle.valueOf(fields[i]));
				}
				retval.put(key, modifiedFields);
				
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find workouts file. Is it in the same directory as the executable?\nError:"
					+ e.toString());
		}
		
		return retval;
	}
}
