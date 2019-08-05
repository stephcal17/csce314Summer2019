import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

// Bonus points: Create an icon (or find a public domain icon. Keep in mind federal Copyright law and TAMU's plagiarism policy and add it to the home screen window.
public class MainWindow implements ActionListener {

	private final JFrame mainFrame = new JFrame(Config.APPLICATIONNAME);
	private final JDialog selectWorkout = new JDialog(mainFrame, "Select Workout");
	private JComboBox<String> cboType, cboGoal;
	private JSpinner spnDuration;
	private final Workouts workouts;
	private final EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups;

	MainWindow(Workouts workouts, EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups) {
		// Code goes here.
		this.workouts = workouts;
		this.muscleGroups = muscleGroups;
		launchHomeScreen();
	}

	private void launchHomeScreen() {
		// Code goes here.
        
		JButton upperbody = new JButton("Upper Body Workout");
		JButton lowerbody = new JButton("Lower Body Workout");
		JButton wholebody = new JButton("Whole Body Workout");

		upperbody.setBounds(0, 0, 1200, 254);
		lowerbody.setBounds(0, 254, 1200, 254);
		wholebody.setBounds(0, 508, 1200, 254);
		
		upperbody.addActionListener(this);
		lowerbody.addActionListener(this);
		wholebody.addActionListener(this);

		mainFrame.add(upperbody);
		mainFrame.add(lowerbody);
		mainFrame.add(wholebody);
		          
		mainFrame.setSize(1200, 800);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Upper Body Workout")) {
            showWorkouts(muscleGroups.get(Config.MuscleGroup.valueOf("UPPERBODY")));
        }
        else if (action.equals("Lower Body Workout")) {
            showWorkouts(muscleGroups.get(Config.MuscleGroup.valueOf("LOWERBODY")));
        }
        else if (action.equals("Whole Body Workout")) {
            showWorkouts(muscleGroups.get(Config.MuscleGroup.valueOf("WHOLEBODY")));
        }
	}

	// This is the method your actionlistener should call. It should create and
	// display a WorkoutsPanel.
	private void showWorkouts(ArrayList<Config.Muscle> muscles) {
		// Code goes here.
		WorkoutsPanel wp = new WorkoutsPanel(muscles, workouts);
		JFrame workFrame = new JFrame(Config.APPLICATIONNAME);
		workFrame.setSize(1200, 800);
		workFrame.add(wp);
		workFrame.setVisible(true);
	}
}
