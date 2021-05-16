package file.and.datafile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {

	public static void main(String[] args) {
		boolean exist = false;
		try {
			while (!exist) {
				// Enter data using BufferReader
				System.out.println("Zip files utils. Please input your command\n");
				System.out.println("\tzip <file path>\n");
				System.out.println("\tzip <folder path>\n");
				System.out.println("\tunzip <zip file path>\n");
				System.out.println("\texit <zip file path>\n");
				System.out.print(">>\t");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				// Reading data using readLine
				String commandLine = reader.readLine();
				// Printing the read line
				if (null == commandLine || "".equalsIgnoreCase(commandLine)) {
					return;
				}
				String[] commands = commandLine.split(" ");
				if (null == commands || 0 == commands.length) {
					return;
				}
				String command = commands[0];
				String options = "";
				if (commands.length > 1) {
					for (int i = 1; i < commands.length; i ++) {
						options += commands[i] + " ";
					}
					options = options.substring(0, options.length()-1);
				}
				System.out.println("command: " + command);
				switch (command) {
				case "exit":
					exist = true;
					System.out.println("Application will stop now. See you later\n");
					break;
				case "zip":
					if (FileUtils.checkFileExist(options)) {
						zipFile(options, options);
					} else if (FileUtils.checkFolderExist(options)) {
						zipFolder(options, options);
					} else {
						System.out.println("File was not found");
					}
					break;
				case "unzip":
					if (FileUtils.checkFileExist(options)) {
//						zipFile(option, option);
					} else {
						System.out.println("File was not found");
					}
					System.out.println("unzip: " + options);
					break;
				default:
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void zipFile(String src, String dest) throws IOException {
		FileOutputStream fos = null;
		ZipOutputStream zipOut = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream(dest + ".zip");
			zipOut = new ZipOutputStream(fos);
			File fileToZip = new File(src);
			fis = new FileInputStream(fileToZip);
			ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
			zipOut.putNextEntry(zipEntry);
			byte[] bytes = new byte[1024];
			int length;
			while ((length = fis.read(bytes)) >= 0) {
				zipOut.write(bytes, 0, length);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != zipOut) {
				zipOut.close();
			}
			if (null != fis) {
				fis.close();
			}
			if (null != fos) {
				fos.close();
			}
		}
	}

	public static void zipFiles(String[] srcs, String dest) throws IOException {
		FileOutputStream fos = null;
		ZipOutputStream zipOut = null;
		try {
			List<String> srcFiles = Arrays.asList(srcs);
			fos = new FileOutputStream(dest + ".zip");
			zipOut = new ZipOutputStream(fos);
			for (String srcFile : srcFiles) {
				File fileToZip = new File(srcFile);
				FileInputStream fis = new FileInputStream(fileToZip);
				ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
				zipOut.putNextEntry(zipEntry);
				byte[] bytes = new byte[1024];
				int length;
				while ((length = fis.read(bytes)) >= 0) {
					zipOut.write(bytes, 0, length);
				}
				fis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != zipOut) {
				zipOut.close();
			}
			if (null != fos) {
				fos.close();
			}
		}
	}

	public static void zipFolder(String src, String dest) throws IOException {
		String sourceFile = src;
		FileOutputStream fos = new FileOutputStream(dest + ".zip");
		ZipOutputStream zipOut = new ZipOutputStream(fos);
		File fileToZip = new File(sourceFile);

		zipFile(fileToZip, fileToZip.getName(), zipOut);

		zipOut.close();
		fos.close();
	}

	private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
		if (fileToZip.isHidden()) {
			return;
		}
		if (fileToZip.isDirectory()) {
			if (fileName.endsWith("/")) {
				zipOut.putNextEntry(new ZipEntry(fileName));
				zipOut.closeEntry();
			} else {
				zipOut.putNextEntry(new ZipEntry(fileName + "/"));
				zipOut.closeEntry();
			}
			File[] children = fileToZip.listFiles();
			for (File childFile : children) {
				zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
			}
			return;
		}
		FileInputStream fis = new FileInputStream(fileToZip);
		ZipEntry zipEntry = new ZipEntry(fileName);
		zipOut.putNextEntry(zipEntry);
		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zipOut.write(bytes, 0, length);
		}
		fis.close();
	}
}
