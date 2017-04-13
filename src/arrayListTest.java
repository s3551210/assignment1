import java.util.ArrayList;

public class arrayListTest {

	static String name = "GameName";
	static String referee = "Referee";
	static String gameID = "Game ID";
	static Swimmers playerOne = new Swimmers("SWIM01", "Mick", 11, "aa", 0, 0);
	static Swimmers playerTwo = new Swimmers("SWIM02", "Danial", 33, "zz", 1, 1);

	public static Swimmers[] swimPlayers = new Swimmers[8];
	public static Cyclists[] cyclingPlayers = new Cyclists[8];
	public static Sprinters[] sprinterPlayer = new Sprinters[8];

	public static void printArray(Athletes[] athletePrint) {
		for (int i = 0; i < athletePrint.length; i++) {
			System.out.println(athletePrint[i].ID + athletePrint[i].name + athletePrint[i].age + athletePrint[i].state
					+ athletePrint[i].totalPoints + athletePrint[i].timeAchieved);
		}
	}
	
	private static void athleteCompete(Athletes[] athleteCompete) {
		for (int y = 0; y < athleteCompete.length; y++) {
			athleteCompete[y].setTimeAchieved(athleteCompete[y].compete());
		}
	}

	public static void arraySort(Athletes [] game) {
		boolean swapped = true;
		int j = 0;
		Athletes[] tempArr = new Athletes[1];
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < game.length - j; i++) {
				if (game[i].timeAchieved > game[i + 1].timeAchieved) {
					tempArr[0] = game[i];
					game[i] = game[i + 1];
					game[i + 1] = tempArr[0];
					swapped = true;
				}
			}
		}
	}

	public static void main(String[] args) {

		swimPlayers[0] = new Swimmers("SWIM01 ", "Bell ", 21, " VIC ", 0, 0);
		swimPlayers[1] = new Swimmers("SWIM02 ", "Mick ", 24, " ACT ", 0, 0);
		swimPlayers[2] = new Swimmers("SWIM03 ", "John ", 22, " NSW ", 0, 0);
		swimPlayers[3] = new Swimmers("SWIM04 ", "Robot ", 21, " NT ", 0, 0);
		swimPlayers[4] = new Swimmers("SWIM05 ", "Olivr ", 20, " SA ", 0, 0);
		swimPlayers[5] = new Swimmers("SWIM06 ", "Jack ", 23, " QLD ", 0, 0);
		swimPlayers[6] = new Swimmers("SWIM07 ", "Noah ", 20, " TAS ", 0, 0);
		swimPlayers[7] = new Swimmers("SWIM08 ", "James ", 23, " WA ", 0, 0);
		
		cyclingPlayers[0] = new Cyclists("CYCL01", "AA", 19, "NSW", 0, 0);
		cyclingPlayers[1] = new Cyclists("CYCL02", "BB", 19, "NSW", 0, 0);
		cyclingPlayers[2] = new Cyclists("CYCL03", "CC", 19, "NSW", 0, 0);
		cyclingPlayers[3] = new Cyclists("CYCL04", "DD", 19, "NSW", 0, 0);
		cyclingPlayers[4] = new Cyclists("CYCL05", "EE", 19, "NSW", 0, 0);
		cyclingPlayers[5] = new Cyclists("CYCL06", "FF", 19, "NSW", 0, 0);
		cyclingPlayers[6] = new Cyclists("CYCL07", "GG", 19, "NSW", 0, 0);
		cyclingPlayers[7] = new Cyclists("CYCL08", "HH", 19, "NSW", 0, 0);
		
		sprinterPlayer[0] = new Sprinters("SPRN01", "III", 24, "NT", 0, 0);
		sprinterPlayer[1] = new Sprinters("SPRN02", "JJJ", 22, "NT", 0, 0);
		sprinterPlayer[2] = new Sprinters("SPRN03", "KKK", 22, "NT", 0, 0);
		sprinterPlayer[3] = new Sprinters("SPRN04", "LLL", 22, "NT", 0, 0);
		sprinterPlayer[4] = new Sprinters("SPRN05", "MMM", 21, "NT", 0, 0);
		sprinterPlayer[5] = new Sprinters("SPRN06", "NNN", 23, "NT", 0, 0);
		sprinterPlayer[6] = new Sprinters("SPRN07", "OOO", 23, "NT", 0, 0);
		sprinterPlayer[7] = new Sprinters("SPRN08", "PPP", 23, "NT", 0, 0);

		athleteCompete(swimPlayers);
		arraySort(swimPlayers);
		printArray(swimPlayers);
		printItAsArrayList(swimPlayers);
		
		athleteCompete(cyclingPlayers);
		arraySort(cyclingPlayers);
		printArray(cyclingPlayers);
		printItAsArrayList(cyclingPlayers);
		
		athleteCompete(sprinterPlayer);
		arraySort(sprinterPlayer);
		printArray(sprinterPlayer);
		printItAsArrayList(sprinterPlayer);

	}

	private static void printItAsArrayList(Athletes[] athletesArrayList) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add(name);
		for (int b = 0; b < athletesArrayList.length; b++) {
			list.add(athletesArrayList[b].name);
			list.add(String.valueOf(athletesArrayList[b].timeAchieved));
		}

		list.add(referee);
		list.add(gameID);

		System.out.println(list.size());

		for (int j = 0; j < list.size(); j++) {
			if (j == 0) {
				System.out.println(list.get(j));
			} else {
				if (j % 2 != 0) {
					System.out.print(list.get(j));
				} else {
					System.out.println("\t" + list.get(j));
				}
			}
		}
	}
}