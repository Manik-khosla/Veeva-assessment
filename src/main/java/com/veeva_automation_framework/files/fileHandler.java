package com.veeva_automation_framework.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.veeva_automation_framework.pojo.JacketInfo;

public class fileHandler {
	
	public static <T> void generateFile(List<T> list){
		
		FileWriter writer = null;
		try {
			writer = new FileWriter("log-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss-SSS")) + ".txt");

			JacketInfo[] obj = list.toArray(new JacketInfo [list.size()]);
			for(JacketInfo jacket : obj) {
		   writer.write("Title:" + jacket.getTitle() + "\n"
			+ "Price:" + jacket.getPrice() + "\n"
			+ "Top Seller Message:" + jacket.getTopSeller() + "\n\n");
			}
		    writer.flush();	    
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Exception");
		} 
		finally{		
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}

}
