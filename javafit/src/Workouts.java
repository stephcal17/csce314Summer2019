import java.util.ArrayList; // We choose ArrayList over Vector because...? 

/**
 * Use the provided enumerations and code framework to create our workouts
 * class. This class should contain all the functionality we need to interact
 * with our workout list. Minimize duplication of code by writing helper
 * functions as needed.
 * 
 * Do not change any of the provided code, although you can, and should, add to
 * it as needed. (E.G. Do not make private attributes public, or change the
 * parameters of a function.)
 */

public class Workouts {

	// Use the Refactor functionality in Eclipse to rename "muscle" to "Muscle" to
	// match our naming convention.
	public enum muscle {
		ABS, BACK, BICEPS, CHEST, FOREARM, GLUTES, LOWERLEG, SHOULDER, TRICEPS, UPPERLEG, NONE
	} // Why didn't I have to declare this static?

	public enum Equipment {
		BARBELL, BODYWEIGHT, DUMBBELL, CABLE, HAMMERSTRENGTH
	}

	private final ArrayList<Workout> workoutList = new ArrayList<Workout>();

	// This is a nested class, also known as an inner class. Why do we use a nested
	// class?
	// You will need to create a number of methods for the inner class. You are not
	// limited to
	// only the methods listed inside this class.
	private class Workout {
		private String name;
		private Equipment equipment;
		private muscle primaryMuscle;
		private muscle secondaryMuscle;
		private String desc;
		private String reminders;

		//constructor
		Workout(String name, Equipment equipment, muscle primaryMuscle, muscle secondaryMuscle, String desc,
		String reminders) {
			this.name = name;
			this.equipment = equipment;
			this.primaryMuscle = primaryMuscle;
			this.secondaryMuscle = secondaryMuscle;
			this.desc = desc;
			this.reminders = reminders;
		}

		// How do we get the name of an enumeration value?
	}

	// This function adds a new workout to the Workouts object.
	public final void addWorkout(String name, Equipment equipment, muscle primaryMuscle, muscle secondaryMuscle,
	String desc, String reminders) {
		workoutList.add(new Workout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders));
	}

	// This function adds a workout to the Workouts object.
	public final void addWorkout(Workout workout) {
		workoutList.add(workout);
	}

	// This list returns a new Workouts object that contains only the workouts that
	// contain the
	// Equipment value that is provided as an argument. The programmer has an option
	// to get
	// Workouts that only have the Muscle in the PrimaryMuscle attribute, or to also
	// look
	// in the secondaryMuscle category.
	public final Workouts getWorkoutsByMuscle(muscle m, boolean includeSecondary) {
		// What is short-circuit evaluation?
		Workouts workoutsByMuscle = new Workouts();
		//iterate through workoutList and get workouts by muscles
		for(Workout workout : workoutList) {
			if((includeSecondary && workout.secondaryMuscle == m) || workout.primaryMuscle == m) {
				workoutsByMuscle.addWorkout(workout);
			}
		}
		return workoutsByMuscle;
	}

	// This list returns a new Workouts object that contains only the workouts that
	// contain the
	// Equipment value that is provided as an argument.
	public final Workouts getWorkoutsByEquipment(Equipment e) {
		Workouts workoutsByEquipment = new Workouts();
		//iterate through workoutList and get workouts by equipment
		for(Workout workout : workoutList) {
			if(workout.equipment == e) {
				workoutsByEquipment.addWorkout(workout);
			}
		}
		return workoutsByEquipment;
	}

	// This returns a new Workouts object that contains only the workouts that
	// contain an Equipment
	// value that is in the provided ArrayList of Equipment.
	public final Workouts getWorkoutsByEquipment(ArrayList<Equipment> e) {
		Workouts workoutsByEquipment = new Workouts();
		//iterate through workoutList and get workouts by list of equipment
		for(Workout workout : workoutList) {
			for(Equipment equipment : e) {
				if(workout.equipment == equipment) {
					workoutsByEquipment.addWorkout(workout);
				}
			}
		}
		return workoutsByEquipment;
	}

	// This method returns an ArrayList of Strings. Each String is a name of a
	// workout in our Workouts list.
	public final ArrayList<String> getNames() {
		ArrayList<String> names;
		names = new ArrayList<String>();
		// iterate through workoutList and get names
		for(Workout workout : workoutList) {
			names.add(workout.name);
		}
		return names;
	}

	// This method returns all the information of the Workouts as an ArrayList of
	// String arrays,
	// one entry in the ArrayList per Workout. The String array should contain the
	// workout's Name,
	// Equipment, Primary and Secondary Muscles, Description, and Reminders. All of
	// these should be strings.
	public final ArrayList<String[]> getFullInformation() {
		ArrayList<String[]> information;
		information = new ArrayList<String[]>();
		// iterate through workoutList and get everything
		for(Workout workout : workoutList) {
			String[] stringArray;
			stringArray = new String[6];
			stringArray[0] = workout.name;
			stringArray[1] = workout.equipment.name();
			stringArray[2] = workout.primaryMuscle.name();
			stringArray[3] = workout.secondaryMuscle.name();
			stringArray[4] = workout.desc;
			stringArray[5] = workout.reminders;
			information.add(stringArray);
		}
		return information;
	}
}
