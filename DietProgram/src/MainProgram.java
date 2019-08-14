import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MainProgram {

	final static String saveFileName = "save.txt";
	final static String goalsFileName = "goals.txt";
	public static ArrayList<Food> foodsList = new ArrayList<Food>();

	public static void main(String[] args) {

	}

	public static void saveFoods(String fn) {
		try {
			PrintWriter outptStream = new PrintWriter(new File(fn));
			for (Food fd : foodsList) {
				outptStream.print("newFood{ " + fd.name.replaceAll(" ", "%20") + ";");
				for (int i = 0; i < Food.abbr.length; i++)
					if (fd.values[i] != 0)
						outptStream.print(Food.abbr[i] + " " + fd.values[i] + ";");
				outptStream.println("}");
			}
			outptStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: \n\rNi datoteke");
			return;
		}
	}

	public static void loadFoods(String fn) {
		File f = new File(fn);
		try {
			Scanner fsc2 = new Scanner(f);
			Food tempfood = new Food();
			while (fsc2.hasNext()) {
				String[] temp = fsc2.nextLine().split(";");
				for (String ss : temp) {
					if (ss.split(" ")[0].equals("}")) {
						foodsList.add(tempfood);
						tempfood = new Food();
					} else if (ss.split(" ")[0].equals(new String("newFood{"))) {
						tempfood.name = ss.split(" ")[1].replaceAll("%20", " ");
					} else {
						for (int i = 0; i < Food.abbr.length; i++) {
							if (ss.split(" ")[0].equals(Food.abbr[i])) {
								tempfood.values[i] = Float.parseFloat(ss.split(" ")[1]);
							}
						}
					}
				}
			}
			fsc2.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	public static Food foodInput() {
		Food temp = new Food();
		try {
			String name_ = JOptionPane.showInputDialog(null, "Ime: ", "Vnos hrane", 3);
			if (name_.equals(""))
				throw new NullPointerException();
			for (Food curName : foodsList)
				if (name_.equals(curName.name)) {
					JOptionPane.showMessageDialog(null, "Hrana \"" + name_ + "\" že obstaja!");
					return temp;
				}
			temp.name = name_;
			String timp;
			for (int i = 0; i < Food.str.length; i++) {
				timp = JOptionPane.showInputDialog(null, Food.str[i] + ": ", "Vnos hrane", 3);
				temp.values[i] = Float.parseFloat((timp.equals("") ? "0" : timp));
			}
			return temp;
		} catch (NullPointerException npe) {
			for (float f : temp.values) {
				if (f > 0)
					;
				return null;
			}
			return temp;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
					"Napaka pri vnosu:\n\r " + e.getMessage().substring(19, e.getMessage().length() - 1));
			return null;
		}
	}

	public static void addFood(Food f) {
		if (f == null)
			return;
		for (Food curName : foodsList)
			if (f.name.equals(curName.name)) {
				JOptionPane.showMessageDialog(null, "Hrana \"" + f.name + "\" že obstaja!");
				return;
			}
		foodsList.add(f);
		saveFoods(saveFileName);
		return;
	}

	public static class Food {
		String name;
		static String[] str = { "Beljakovine", "Ogljikovi hidrati", "Mašèobe", "Nasièene in trans mašèobe",
				"Holesterol", "Sol", "Vlakna", "Sladkor", "Vitamin A", "Vitamin C", "Kalcij", "Železo" };
		static String[] abbr = { "prot", "carb", "fat", "sfat", "chol", "sod", "fibre", "sugar", "vA", "vC", "calc",
				"iron" };
		float[] values = new float[abbr.length];

		public Food(String nm, float[] inp) {
			name = nm;
			Arrays.fill(values, 0);
			this.values = inp;
		}

		public Food() {
			name = "";
			Arrays.fill(this.values, 0);
		}

		public static float[] setValues(String[] strs, float[] val) {
			float[] res = new float[abbr.length];
			Arrays.fill(res, 0);
			for (int i = 0; i < strs.length; i++) {
				for (int j = 0; j < abbr.length; j++) {
					if (strs[i].equals(abbr[j]))
						res[j] = val[i];
					continue;
				}
			}
			return res;
		}
	}

	public static void loadGoals(String fn) {
		Scanner scn;
		try {
			File f = new File(fn);
			scn = new Scanner(f);
		} catch (Exception e) {
			scn = null;
		}
	}

}