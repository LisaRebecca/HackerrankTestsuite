package suite;

import java.io.File;
import java.io.IOException;

public class Main {
	static String myMain;
	static String myPath;

	public static void main(String[] args) {

		try {
			myMain = String.join(" ", args);
			myPath = "" + System.getProperty("user.dir") + "/src/" + myMain;
			checkSetup();
		} catch (ArrayIndexOutOfBoundsException aiob) {
			System.out.println("No Exercise specified.");
		}
	}

	static void checkSetup() {

		File exercise = new File(myPath);
		if (exercise.exists() && exercise.isDirectory()) {
			System.out.println("The directiory for exercise \""+myMain+"\" already exists.");
		} else {
			try {
				exercise.createNewFile();
				System.out.println("The directiory for exercise "+myMain+" was created.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String[] neededFiles = { "Main.java", "input.txt", "expected.txt", "actual.txt" };

		for(String path : neededFiles) {
			
			File f = new File(myPath + "/" + path);
			if (f.exists()) {
				System.out.println("The file " + path + " already exists.");
			} else {
				try {
					f.createNewFile();
					System.out.println("The file " + path +" was created.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		

	}
}