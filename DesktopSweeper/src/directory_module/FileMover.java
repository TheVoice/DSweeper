package directory_module;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.*;

public class FileMover {
	
	private String desktopPath;
	
	//Sets desktopPath as the default user's desktop folder
	public FileMover(){
		desktopPath = System.getProperty("user.home")+"/Desktop";
	}
	
	//Specify desktop folder
	public FileMover(String path){
		desktopPath = path;
	}
	
	//Create a new directory path starting from the desktopPath
	public boolean createDirectory(String dirPath){
		File f = new File(desktopPath+"/"+dirPath);
		if(f.exists()) return true;
		else return f.mkdirs();
	}
	
	//Move a file located in the desktop folder to a specified destination
	public void moveFile(String filename,String destination){
		String fullDestination = desktopPath+"/"+destination;
		createDirectory(destination);
		
		try {
			Files.move(Paths.get(desktopPath+"/"+filename), Paths.get(fullDestination+"/"+filename), REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		/*
		FileMover fm = new FileMover();
		
		if(fm.createDirectory("foo/bar")){
			System.out.println("Directory creation succesful");
		}else
			System.out.println("Directory creation failed");
			
		fm.moveFile("test.txt", "foo/bar");
		*/
	}
}
