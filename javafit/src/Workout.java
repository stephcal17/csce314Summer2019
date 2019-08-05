import java.util.ArrayList;

public class Workout {
	private String name;
	private Config.Equipment equipment;
	private Config.Muscle primaryMuscle;
	private Config.Muscle secondaryMuscle;
	private String desc;
	private String reminders;

	Workout(String name, Config.Equipment equipment, Config.Muscle primaryMuscle, Config.Muscle secondaryMuscle, String desc,
			String reminders) {
		this.name = name;
		this.equipment = equipment;
		this.primaryMuscle = primaryMuscle;
		this.secondaryMuscle = secondaryMuscle;
		this.desc = desc;
		this.reminders = reminders;
	}
	
	// new methods for part 2
	protected boolean hasPrimaryMuscle(ArrayList<Config.Muscle> muscleList) {
		for (Config.Muscle m : muscleList) {
			if (m == primaryMuscle)
				return true;
		}
		return false;
	}
	
	protected boolean hasSecondaryMuscle(ArrayList<Config.Muscle> muscleList) {
		for (Config.Muscle m : muscleList) {
			if (m == secondaryMuscle)
				return true;
		}
		return false;
	}
	// end of new methods

	protected boolean hasPrimaryMuscle(Config.Muscle m) {
		return primaryMuscle == m;
	}

	protected boolean hasSecondaryMuscle(Config.Muscle m) {
		return secondaryMuscle == m;
	}

	protected boolean hasEquipment(Config.Equipment e) {
		return equipment == e;
	}

	protected boolean hasEquipment(ArrayList<Config.Equipment> equipmentList) {
		for (Config.Equipment e : equipmentList) {// This is a ForEach, and uses an iterator in the background to loop
											// through the collection.
			if (hasEquipment(e))
				return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public String getEquipment() { // How do we get the name of an enumeration value?
		return equipment.name();
	}

	public String getPrimaryMuscle() { // How do we get the name of an enumeration value?
		return primaryMuscle.name();
	}

	public String getSecondaryMuscle() { // How do we get the name of an enumeration value?
		return secondaryMuscle.name();
	}

	public String getDesc() {
		return desc;
	}

	public String getReminders() {
		return reminders;
	}
}