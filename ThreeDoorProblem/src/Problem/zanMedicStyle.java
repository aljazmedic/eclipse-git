package Problem;

import java.util.*;

public class zanMedicStyle {
	public static void main(String args[]) {

		int i1w = 0; // izbira 1 wins (obdrzi)
		int i2w = 0; // izbira 2 wins (zamenja)
		int i3w = 0; // izbira 3 wins (nakljucno obdrzi ali zamenja)
		int poskusov = 10000; // stevilo poskusov
		System.out.println("Število iger: " + poskusov);

		Random rand = new Random();

		final int PROPERTY_ZAKLAD = 1;
		final int PROPERTY_IZBIRA1 = 2;
		final int PROPERTY_IZBIRA2 = 3;
		final int PROPERTY_IZBIRA3 = 4;
		final int PROPERTY_ODPRTO = 5;

		int zanka = 0;
		while (zanka < poskusov) {
			zanka++;

			Vrata[] data = new Vrata[3]; // [vrata][1 zaklad, 2 izbira1, 3 izbira2, 4 odprto]
			for (int i = 0; i < data.length; i++)
				data[i] = new Vrata();

			int zaklad = rand.nextInt(3);
			data[zaklad].setTrue(PROPERTY_ZAKLAD); // skrijemo zaklad

			int izb1 = rand.nextInt(3);
			data[izb1].setTrue(PROPERTY_IZBIRA1); // zabelezimo prvo izbiro

			int odpri = rand.nextInt(3);
			while (data[odpri].getProperty(PROPERTY_IZBIRA1) || data[odpri].getProperty(PROPERTY_ZAKLAD)) {
				odpri = rand.nextInt(3); // poiscemo neizbrana prazna vrata
			}
			data[odpri].setTrue(PROPERTY_ODPRTO); // odpremo vrata

			int izb2 = rand.nextInt(3); // Drugo izbiro nastavimo na druga vrata
			while (data[izb2].getProperty(PROPERTY_IZBIRA1) || data[izb2].getProperty(PROPERTY_ODPRTO)) {
				izb2 = rand.nextInt(3);
			}
			data[izb2].setTrue(PROPERTY_IZBIRA2);

			// Tretjo izbiro nakljucno nastavimo, da bodisi obdrzi bodisi zamenja int
			int izb3 = 0;
			if (rand.nextFloat() >= 0.5f)
				izb3 = izb1;
			else
				izb3 = izb2;
			data[izb3].setTrue(PROPERTY_IZBIRA3);

			// Preverjanje rezultatov
			for (int i = 0; i < data.length; i++) {
				if (!data[i].getProperty(PROPERTY_ZAKLAD))
					continue;
				if (data[i].getProperty(PROPERTY_IZBIRA1))
					i1w++;
				if (data[i].getProperty(PROPERTY_IZBIRA2))
					i2w++;
				if (data[i].getProperty(PROPERTY_IZBIRA3))
					i3w++;
			}
		}
		System.out.println("Izbira 1 zmaga: " + i1w + "\r\nIzbira 2 zmaga: " + i2w + "\r\nIzbira 3 zmaga: " + i3w);
		System.out.println("Delež zmag po prvi izbiri: " + (100 * i1w / poskusov) + " %");
		System.out.println("Delež zmag po drugi izbiri: " + (100 * i2w / poskusov) + " %");
		System.out.println("Delež zmag po tretji izbiri: " + (100 * i3w / poskusov) + " %");
	}

	public static class Vrata {
		boolean[] prp;

		public Vrata() {
			prp = new boolean[5];
			Arrays.fill(prp, false);
		}

		public void setTrue(int i) {
			this.prp[i - 1] = true;
		}

		public boolean getProperty(int i) {
			return this.prp[i - 1];
		}
	}

}