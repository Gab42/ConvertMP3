package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import program.Program;

public class ReadFromFile {

	public static void ReadFromFile(String file){		
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			line = br.readLine();
			while (line != null) {			
				Program.songsList.add(line);
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
}
