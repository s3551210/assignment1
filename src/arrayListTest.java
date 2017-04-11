import java.util.ArrayList;

public class arrayListTest {

	static Swimmers playerOne = new Swimmers("ss", "dd", 11, "aa", 0, 0);
	static Swimmers playerTwo = new Swimmers("qq", "ww", 33, "zz", 1, 1);
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(playerOne.ID);
		list.add(playerOne.name);
		list.add(String.valueOf(playerOne.age));
		list.add(playerOne.state);
		list.add(String.valueOf(playerOne.totalPoints));
		list.add("C");
		list.add(playerTwo.ID);
		list.add(playerTwo.name);
		list.add(String.valueOf(playerTwo.age));
		list.add(playerTwo.state);
		list.add(String.valueOf(playerTwo.totalPoints));
		list.add("C");

		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			for(int j =0; j <list.size(); j++){
				System.out.print(list.get(j));
			}
			System.out.println();
			
		}

	}

}
