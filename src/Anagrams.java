import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Anagrams {

	public static void main(String[] args) {
		new Anagrams().setup();
	}

	public void setup() {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> anagrams = new ArrayList<String>();

		Scanner s = new Scanner(System.in);

		try {
			URL u = new URL("https://raw.githubusercontent.com/eneko/data-repository/master/data/words.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));

			System.out.print("Reading Dictionary... ");
			String line;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
			System.out.println("Done!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print("What is the word: ");
		String word = s.nextLine();

		for (String dict : list) {
			boolean isAnagram = true;
			for (String letter : word.split("")) {
					if (!dict.contains(letter)) {
						isAnagram = false;
						continue;
					}
			}
			if (isAnagram && dict.length() == word.length() && !word.equals(dict)) {
				System.out.println(dict);
				anagrams.add(dict);
			}
		}
		
		s.close();
	}

}
