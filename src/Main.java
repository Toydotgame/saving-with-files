import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	static File saveFile = new File("save");
	
	static int x = 1;
	static int y = 2;
	static int z = 3;

	public static void main(String[] args) {
		createFile();
	}
	
	public static void createFile() {
		boolean fileAlreadyExists = saveFile.exists();
		
		if(fileAlreadyExists == true) {
			System.out.println("The file \"" + saveFile + "\" already exists!");
		} else {
			try { // I HATE try/catch loops!
				if(saveFile.createNewFile()) {
					System.out.println("File \"" + saveFile + "\" was successfully created.");
				} // I don't think the program should break here. Thus, I shouldn't need an `if()`. _Shouldn't_.
			} catch(IOException e) { // I STILL hate them!
				System.out.println("Couldn't create new file!");
				e.printStackTrace();
			} // Burn. Slowly.
		}
	}
	
	public static void writeToFile() {
		try { // try/catch can actually leave now, it's okay. The joke's over.
			FileWriter writer = new FileWriter(saveFile);
			writer.write("x: " + String.valueOf(x));
		} catch(IOException e) { // Leave.
			
		}
	}
}
