package file.and.datafile;

import java.io.File;

public class FileUtils {

	public static void main(String[] args) {

	}

	public static boolean checkFileExist(String src) {
		File file = new File(src);
		return file.exists() && file.isFile();
	}
	
	public static boolean checkFolderExist(String src) {
		File file = new File(src);
		return file.exists() && file.isDirectory();
	}
	
	
}
