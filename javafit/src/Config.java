// This class is for all our configuration data. By putting it all in one place, we can easily make changes to the program without having to hunt down where in the code a constant is defined.

public class Config {

	public final static String APPLICATIONNAME = "JavaFit: Muscles for Computer Scientists!";
	public final static String WORKOUTFILE = "data/workouts.csv";
	public final static String WORKOUTFORMATFILE = "data/workoutformats.csv";
	public final static String ICON = "data/icon.png";

	public enum MuscleGroup {
		UPPERBODY, LOWERBODY, WHOLEBODY
	}

	public enum Equipment {
		BARBELL, BODYWEIGHT, DUMBBELL, CABLE, HAMMERSTRENGTH
	}

	public enum Muscle {
		ABS, BACK, BICEPS, CHEST, FOREARM, GLUTES, LOWERLEG, SHOULDER, TRICEPS, UPPERLEG, NONE
	} // Why didn't I have to declare this static?

}
