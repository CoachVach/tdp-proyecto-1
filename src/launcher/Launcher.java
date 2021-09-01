package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
		Student alumno = new Student(43408495,"Kovach","Erik","kovacherik@gmail.com","https://github.com/CoachVach","/images/perfil.png"); 
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SimplePresentationScreen screen= new SimplePresentationScreen(alumno);
            	screen.setVisible(true);
            }
        });
    }
}