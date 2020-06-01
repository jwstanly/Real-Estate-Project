import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public  class RandomAccessFileEditor {
	
	private String nonStaticFileDirectory;
	
	public RandomAccessFileEditor(String nonStaticFileDirectory) {
		this.nonStaticFileDirectory = nonStaticFileDirectory;
	}
	
	public static String readData(String filepath, int position) throws Exception{
		//makes RAF and seeks to correct position
		RandomAccessFile file = new RandomAccessFile(filepath, "rw");
		file.seek(position);
		
		//collects the first character to see if its a " " space for later testing
		int readInt = file.read();
		String output = "";
		
		//RECURSIVELY collects the other characters
		file.seek(position);
		if(readInt!=32) output += (char)file.read() + readData(filepath, position+1);

		return output;
	}
	
	public static String[] getProjects(String filepath) throws Exception {
		//makes the array list to add project names to
		ArrayList<String> projectsList = new ArrayList<String>();
		
		//finds total seek size
		int totalSeek = Integer.parseInt(readData(filepath, 0));
		
		//hunts through the document to add projects to the array
		for(int x=100;x<=totalSeek;x+=100) {	
			projectsList.add(readData(filepath, x));
		}
		
		for(int x=0;x<projectsList.size();x++) System.out.println(projectsList.get(x));
		
		//converts array list to traditional array; returns array
		String[] projectArray = new String[projectsList.size()];
		for(int x=0;x<projectsList.size();x++) projectArray[x] = projectsList.get(x);
		
		return projectArray;
	}
	
	public static void addProject(String filepath, String projectTitle) throws Exception {
		
		RandomAccessFile file = new RandomAccessFile(filepath, "rw");
		
		//read the size of the RAF
		int totalSeek = Integer.parseInt(readData(filepath, 0));
		int newTotal = totalSeek+100;
		String newTotalString = null;
		if(totalSeek>=000 && totalSeek<1000) newTotalString = "00"+newTotal;
		else if(totalSeek>=1000 && totalSeek<10000) newTotalString = "0"+newTotal;
		else if(totalSeek>=10000 && totalSeek<100000) newTotalString = ""+newTotal;
		
		//go back to the beginning and replace the new total size
		file.seek(0);
		file.write(newTotalString.getBytes("UTF-8"));
		
		//go to the end of the file and add the new project
		file.seek(newTotal);
		String projectTitleToAdd = projectTitle+" ";
		file.write(projectTitleToAdd.getBytes("UTF-8"));
		
		file.close();
		
		System.out.println(projectTitle + " added to file");
	}
	
	public static String readCharacter(String filepath, int position) {
		
		RandomAccessFile file = null;
		
		try
			{file = new RandomAccessFile(filepath, "rw");} 
		catch (FileNotFoundException e2)
			{e2.printStackTrace();}
		
		try 
			{file.seek(position);}
		catch (IOException e1) 
			{e1.printStackTrace();}
		
		try 
			{return ""+(char)file.read();}
		catch (IOException e)
			{e.printStackTrace();}
		
		return "error";
	}
	
	public static String readASCII(String filepath, int position) {
		
		RandomAccessFile file = null;
		
		try
			{file = new RandomAccessFile(filepath, "rw");} 
		catch (FileNotFoundException e2)
			{e2.printStackTrace();}
		
		try 
			{file.seek(position);}
		catch (IOException e1) 
			{e1.printStackTrace();}
		
		try 
			{return ""+file.read();}
		catch (IOException e)
			{e.printStackTrace();}
		
		return "error";
	}
		
	
	public String readData(int position) throws Exception {
		return readData(nonStaticFileDirectory, position);
	}
	
	public String[] getProjects() throws Exception {
		return getProjects(nonStaticFileDirectory);
	}
	
	public void addProject(String projectTitle) throws Exception {
		addProject(nonStaticFileDirectory, projectTitle);
	}
	
	public String readCharacter(int position) {
		return readCharacter(nonStaticFileDirectory, position);
	}
	
	public String readASCII(int position) {
		return readCharacter(nonStaticFileDirectory, position);
	}
}
