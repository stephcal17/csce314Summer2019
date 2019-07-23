// Write code to load the workouts from the provided workouts.csv file. The function should return a Workouts object.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class FileAccess {

	public static Workouts loadWorkouts() {
		// What is a try/catch block and why do we need one?
		// What is an exception?
		Workouts workouts = new Workouts();
		String line = "";
		BufferedReader br = null;
		try {
			// read file and load to workouts
			br = new BufferedReader(new FileReader(Config.WORKOUTFILE));
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				workouts.addWorkout(fields[0], Workouts.Equipment.valueOf(fields[1]),
						Workouts.muscle.valueOf(fields[2]), Workouts.muscle.valueOf(fields[3]),
						fields[4], fields[5]);
			}
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return workouts;
	}
	
}
