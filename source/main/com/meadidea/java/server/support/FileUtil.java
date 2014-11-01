package com.meadidea.java.server.support;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

//import java.text.SimpleDateFormat;
//import java.util.Date;
/**

 * <p>The <b>FileUtil</b>class contains some smart method for file folder manipulate.</p>
 * 
 * @author Mead Lai
 * @since 2013-05-09
 * @version 1.0
 * @see java.nio.channels.FileChannel
 */
public class FileUtil {

	public static void main(String[] args) throws IOException {
		String arg1 = "a_mead";
		boolean b = arg1.startsWith("_");
		System.out.println(b);
		File f1 = new File("M://flowattach//1351483620156.docx");
		File f2 = new File("C://TEMP//mead.docx");
		if (!f1.exists()) {
			System.out.println("no file exists!");
			return;
		}
		copyFile(f1, f2);
	}

	/**
	 * nio copy file
	 * @param in
	 * @param out
	 */
	public static void copyFile(File in, File out) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel inChannel = null;
		FileChannel outChannel = null;

		try {
			fis = new FileInputStream(in);
			inChannel = fis.getChannel();
			fos = new FileOutputStream(out);
			outChannel = fos.getChannel();
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inChannel != null){
				try {
					inChannel.close();
				} catch (IOException e) {
				}
			}
			if (outChannel != null){
				try {
					outChannel.close();
				} catch (IOException e) {
				}
			}
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
				}
			}
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
