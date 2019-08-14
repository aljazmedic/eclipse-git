package rtk2018_Vaje;

public class Kosi_S_4 {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			Kosi2_Main(i);
		}
	}

	static int kosiCount;

	public static int Kosi1_Main(int stevilo) {
		kosiCount = 0;
		Kosi1_Sub(stevilo);
		System.out.println(kosiCount);
		return kosiCount;
	}

	public static void Kosi1_Sub(int times) {
		if (times == 0) {
			kosiCount++;
			return;
		} else if (times < 0) {
			return;
		} else {
			Kosi1_Sub(times - 1);
			Kosi1_Sub(times - 2);
			Kosi1_Sub(times - 3);

		}
	}

	static int[] table2;

	public static int Kosi2_Main(int stevilo) {
		table2 = new int[stevilo + 1];
		System.out.println(Kosi2_Sub(stevilo));
		return (Kosi2_Sub(stevilo));
	}

	public static int Kosi2_Sub(int k) {
		if (table2[k] == 0) {
			prvis: switch (k) {
			case 0:
				table2[k] = 1;
				break prvis;
			case 1:
				table2[k] = 1;
				break prvis;
			case 2:
				table2[k] = 2;
				break prvis;
			default:
				table2[k] = Kosi2_Sub(k - 1) + Kosi2_Sub(k - 2) + Kosi2_Sub(k - 3);
				break prvis;
			}
		}
		return table2[k];
	}
}
