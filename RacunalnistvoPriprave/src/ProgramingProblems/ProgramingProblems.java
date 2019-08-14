package ProgramingProblems;

public class ProgramingProblems {

	public static String getFile(Class<?> c) {
		return ("data" + c.getName().split("_")[1] + ".txt");
	}
}
