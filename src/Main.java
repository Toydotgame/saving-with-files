import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static File saveFile = new File("save");
	
	public static void main(String[] args) {
		createFile();
		writeToFile();
		readFile();
		
		System.out.println(DataStorage.lines.get(1));
	}
	
	public static boolean createFile() {
		DataStorage.fileAlreadyExists = saveFile.exists();

		if(DataStorage.fileAlreadyExists == true) {
			System.out.println("The file \"" + saveFile + "\" already exists!");
			return true;
		} else {
			try { // I HATE try/catch loops!
				if(saveFile.createNewFile()) {
					System.out.println("File \"" + saveFile + "\" was successfully created.");
				} // I don't think the program should break here. Thus, I shouldn't need an `if()`. _Shouldn't_.
			} catch(IOException e) { // I STILL hate them!
				System.out.println("Couldn't create new file!");
				e.printStackTrace();
			} // Burn. Slowly.
			return false;
		}
	}
	
	public static void readFile() {
		try {
			Scanner reader = new Scanner(saveFile);
			while(reader.hasNextLine()) {
				String lineData = reader.nextLine();
				DataStorage.lines.add(lineData);
				System.out.println(lineData);
			}
			reader.close(); // nice
		} catch(IOException e) {
			System.out.println("Couldn't read file \"" + saveFile + "\"!");
			e.printStackTrace();
		}
	}
	
	public void doStuffWithValuesFromTheOldFile() {
		if(DataStorage.fileAlreadyExists == true) {
			
		}
	}
	
	public static void writeToFile() {
		try { // try/catch can actually leave now, it's okay. The joke's over.
			FileWriter writer = new FileWriter(saveFile);
			writer.write("x: " + String.valueOf(DataStorage.x) + "\n");
			writer.write("y: " + String.valueOf(DataStorage.y) + "\n");
			writer.write("z: " + String.valueOf(DataStorage.z) + "\n\n");
			writer.close(); // Good practices, good sir.
			System.out.println("Successfully wrote to file!");
		} catch(IOException e) { // Leave.
			System.out.println("Couldn't write to file! (" + saveFile + ")");
			e.printStackTrace();
		}
	}
}
