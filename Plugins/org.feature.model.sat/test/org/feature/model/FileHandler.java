package org.feature.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Ingo Reimund
 * 
 */
public class FileHandler {
	/**
	 * read a file as single string and add line breaks after every readed line
	 * 
	 * @param fileName
	 *            name of the file
	 * @return complete file as string
	 * @throws IOException
	 */
	public String readFile(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
		StringBuffer result = new StringBuffer();

		String line = reader.readLine();
		result.append(line);
		while ((line = reader.readLine()) != null) {
			result.append("\n");
			result.append(line);
		}
		reader.close();
		return result.toString();
	}
}