import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class EventScripter {
	private static Stack<Event> eventStack = new Stack<Event>();
	private static File eventLog = new File("eventLog.txt");
	private static FileWriter fileWriter;
	private static PrintWriter printWriter;
	private static Scanner scanner;

	public static void buildStackFromEventLogFile() {
		
		if(!eventStack.isEmpty()) eventStack.clear();
		
		try {
			scanner = new Scanner(eventLog);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNextLine()) {
			//reads next line
			String[] tempTokens = scanner.nextLine().split("~");
			
			//creates an array with guaranteed size >5
			String[] tokens = new String[7];
			for(int x=0;x<tempTokens.length;x++) tokens[x] = tempTokens[x];

			//adds according to the event type
			switch(Integer.parseInt(tokens[2].trim())) {
			case 1:
				DataEvent tempData = new DataEvent(tokens[0],tokens[1],tokens[3],
						tokens[4],tokens[5]);
				eventStack.push(tempData);
				//System.out.println("New data event added to stack --- " + tempData);
				break;
			case 2:
				TaskEvent tempTask = new TaskEvent(tokens[0],tokens[1],tokens[3],
						tokens[4],tokens[5]);
				eventStack.push(tempTask);
				//System.out.println("New task event added to stack --- " + tempTask);
				break;
			case 3:
				CommentEvent tempComment = new CommentEvent(tokens[0],tokens[1],tokens[3]);
				eventStack.push(tempComment);
				//System.out.println("New comment event added to stack --- " + tempComment);
				break;
			case 4:
				ProblemEvent tempProblem = new ProblemEvent(tokens[0],tokens[1],tokens[3],
						tokens[4],tokens[5],Integer.parseInt(tokens[6].trim()));
				eventStack.push(tempProblem);
				//System.out.println("New problem event added to stack --- " + tempProblem);
				break;
			}
		}
		scanner.close();
	}
	
	public static void buildLogFileFromStack() {
		
		//clears the contents of the existing events log file
		FileWriter fwOb = null;
		PrintWriter pwOb = null;
		try {
			fwOb = new FileWriter(eventLog, false);
			pwOb = new PrintWriter(fwOb, false);
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
        pwOb.flush();
        pwOb.close();
        try {
			fwOb.close();
		}
        catch (IOException e1) {
			e1.printStackTrace();
		}
		
        //adds the events from the Stack
		try {
			//creates the file writer and print writer
			fileWriter = new FileWriter(eventLog, true);
			printWriter = new PrintWriter(fileWriter);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		//flips the ordering so the following lines of code don't write to the text field backwards
		Stack<Event> temp = new Stack<Event>();
		while(!eventStack.isEmpty()) {
			temp.push(eventStack.pop());
		}
		
		//adds the file's scriptLog to the event log
		System.out.println("DEBUG TEMP: "+temp);
		while(!temp.isEmpty()) {
			printWriter.print(temp.pop().scriptLog());
			printWriter.print("\r\n");
		}
		printWriter.close();
		
		//rebuilds the stack becuase in the process of creating the next text file, the stack was emptied
		buildStackFromEventLogFile();
	}
	
	public static String addEvent(Event newEvent) {
		//adds to the Stack
		eventStack.push(newEvent);
		
		//adds to the event log file
		try {
			//creates the file writer and print writer
			fileWriter = new FileWriter(eventLog, true);
			printWriter = new PrintWriter(fileWriter);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		//adds the file's scriptLog to the event log
		printWriter.print(newEvent.scriptLog());
		printWriter.print("\r\n");
		System.out.println(newEvent.toString());
		
		printWriter.close();
		
		return newEvent.toString();
	}

	public static Stack<Event> removeEvent(Event removeEvent) {
		buildStackFromEventLogFile();
		Stack<Event> tempStack = new Stack<Event>();
		while(!eventStack.isEmpty()) {
			Event tempEvent = eventStack.pop();
			//note the script logs (and not the objects themselves) are compared because the vales should not be compared...
			//...not the reference points of the actual reference variables
			if(!tempEvent.scriptLog().equals(removeEvent.scriptLog())) {
				tempStack.push(tempEvent);
			}
		}
		while(!tempStack.isEmpty()) {
			eventStack.push(tempStack.pop());
		}
		
		buildLogFileFromStack();
		
		return eventStack;
	}
	
	public static Stack<Event> getEventStack() {
		return eventStack;
	}

	public static void setEventStack(Stack<Event> eventStack) {
		EventScripter.eventStack = eventStack;
	}
	
	public static String[][] getUnsortedEventTable(String name){
		
		buildStackFromEventLogFile();
		
		//constructs a properly sized 2D array
		String data[][] = new String[eventStack.size()][3];
		
		//copies the existing Stack to a temp variable
		Stack<Event> tempStack = (Stack<Event>) eventStack.clone();
		
		int c=0;
		while(!tempStack.isEmpty()) {
			Event tempEvent = tempStack.pop();
			if(tempEvent.getClient().equals(name)) {
				
				data[c][0] = tempEvent.getProjectName();
				
				//removes the unnessary content from the toString that complicates...
				//...the already mentioned details by removing everything before the colon
				String[] tempTokens = tempEvent.toString().split(":");
				String details = tempTokens[1];
				
				//distinguishes which operation was used and properly...
				//...writes the subsequent data
				if(tempEvent.getOperation().trim().equals("Data")) {
					data[c][1] = "Data";
					data[c][2] = details;
					c++;
				}
				if(tempEvent.getOperation().trim().equals("Task")) {
					data[c][1] = "Task";
					data[c][2] = details;
					c++;
				}
				if(tempEvent.getOperation().trim().equals("Comment")) {
					data[c][1] = "Comment";
					data[c][2] = details;
					c++;
				}
				if(tempEvent.getOperation().trim().equals("Problem")) {
					data[c][1] = "Problem";
					data[c][2] = details;
					c++;
				}
			}
		}
		
		//System prints for debugging
		for(int x=0;x<data.length;x++) {
			for(int y=0;y<data[x].length;y++) {
				System.out.print(data[x][y]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		
		return data;
	}
		
	public static String[][] getProjectSortedEventTable(String name){
		
		buildStackFromEventLogFile();
		
		//creates a properly sized 2D array
		String data[][] = new String[eventStack.size()][3];
		
		//copies the existing stack to a temp variable
		Stack<Event> tempStack = (Stack<Event>) eventStack.clone();
		
		//adds every element in the stack to the new ArrayList
		ArrayList<Event> eventList = new ArrayList<Event>();
		while(!tempStack.isEmpty()) {
			Event tempEvent = tempStack.pop();
			if(tempEvent.getClient().equals(name)) {
				eventList.add(tempEvent);
			}
		}
		
		//Uses RandomAccessFileEditor to generate a list of projects 
		String[] projectArr = null;
		try {projectArr = RandomAccessFileEditor.getProjects("listOfProjectsRAF.txt");}
		catch (Exception e) {e.printStackTrace();}
		
		/*Creates an array of ArrayLists to store events to. Each ArrayList contains
		all the events from one project. Thus, the array contains all the ArrayLists
		of all the different projects the client is a part of. The loop manually
		instantiates each ArrayList to avoid null pointer errors*/
		ArrayList<Event>[] sortedEventList = new ArrayList[projectArr.length];
		for(int x=0;x<sortedEventList.length;x++) {
			sortedEventList[x] = new ArrayList<Event>();
		}
		
		for(int x=0;x<eventList.size();x++) {
			for(int y=0;y<projectArr.length;y++) {
				StringTokenizer st = new StringTokenizer(eventList.get(x).getProjectName());
				String projectName = "";
				while(st.hasMoreTokens()) projectName += st.nextToken();				
				//^modifies the Project Name's title to contain no spaces
				if(projectName.equals(projectArr[y])) {
					sortedEventList[y].add(eventList.get(x));
				}
				//^if an event matches a project, it's added to its respective ArrayList
			}
		}
		
		ArrayList<Event> finishedSortedEventList = new ArrayList<Event>();
		//^The final ArrayList to contain all the merged events, now in proper order
		for(int x=0;x<sortedEventList.length;x++) {
			if(!sortedEventList[x].isEmpty()) {
			//^checks to see if the project even has any events
				for(int y=0;y<sortedEventList[x].size();y++) {
					finishedSortedEventList.add(sortedEventList[x].get(y)); //adds event in order
				}
			}
		}
		
		for(int z=0;z<finishedSortedEventList.size();z++) {
			Event tempEvent = finishedSortedEventList.get(z);
			data[z][0] = tempEvent.getProjectName();
			
			String[] tempTokens = tempEvent.toString().split(":");
			String details = tempTokens[1];
			
			if(tempEvent.getOperation().trim().equals("Data")) {
				data[z][1] = "Data";
				data[z][2] = details;
			}
			if(tempEvent.getOperation().trim().equals("Task")) {
				data[z][1] = "Task";
				data[z][2] = details;
			}
			if(tempEvent.getOperation().trim().equals("Comment")) {
				data[z][1] = "Comment";
				data[z][2] = details;
			}
			if(tempEvent.getOperation().trim().equals("Problem")) {
				data[z][1] = "Problem";
				data[z][2] = details;
			}
		}
		
		//System prints for debugging
		for(int x=0;x<data.length;x++) {
			for(int y=0;y<data[x].length;y++) {
				System.out.print(data[x][y]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		
		return data;		
	}
		
	public static String[][] getOperationSortedEventTable(String name){
		

		buildStackFromEventLogFile();
		
		String data[][] = new String[eventStack.size()][3];
		
		Stack<Event> tempStack = (Stack<Event>) eventStack.clone();
		
		ArrayList<Event> eventList = new ArrayList<Event>();
		while(!tempStack.isEmpty()) {
			Event tempEvent = tempStack.pop();
			if(tempEvent.getClient().equals(name)) {
				eventList.add(tempEvent);
			}
		}
		
		//lists the operations in a String array
		String[] operationArr = {"Undeclaired","Data","Task","Comment","Problem"};;
		
		/*Creates an array of ArrayLists to store events to. Each ArrayList contains
		all the events from one type of operation. Thus, the array contains all the 
		ArrayLists of all the different operations the client is a part of. The loop 
		manually instantiates each ArrayList to avoid null pointer errors*/
		ArrayList<Event>[] sortedEventList = new ArrayList[operationArr.length];
		for(int x=0;x<sortedEventList.length;x++) {
			sortedEventList[x] = new ArrayList<Event>();
		}
		
		for(int x=0;x<eventList.size();x++) {
			for(int y=0;y<operationArr.length;y++) {				
				if(eventList.get(x).getOperation().equals(operationArr[y])) {
					sortedEventList[y].add(eventList.get(x));
				}
				//^if an event matches an operation, it's added to its respective ArrayList
			}
		}
		
		ArrayList<Event> finishedSortedEventList = new ArrayList<Event>();
		//^The final ArrayList to contain all the merged events, now in proper order
		for(int x=0;x<sortedEventList.length;x++) {
			if(!sortedEventList[x].isEmpty()) {
				//^checks to see if the project even has any events
				for(int y=0;y<sortedEventList[x].size();y++) {
					finishedSortedEventList.add(sortedEventList[x].get(y)); //adds event in order
				}
			}
		}
		
		for(int z=0;z<finishedSortedEventList.size();z++) {
			Event tempEvent = finishedSortedEventList.get(z);
			data[z][0] = tempEvent.getProjectName();
			
			String[] tempTokens = tempEvent.toString().split(":");
			String details = tempTokens[1];
			
			if(tempEvent.getOperation().trim().equals("Data")) {
				data[z][1] = "Data";
				data[z][2] = details;
			}
			if(tempEvent.getOperation().trim().equals("Task")) {
				data[z][1] = "Task";
				data[z][2] = details;
			}
			if(tempEvent.getOperation().trim().equals("Comment")) {
				data[z][1] = "Comment";
				data[z][2] = details;
			}
			if(tempEvent.getOperation().trim().equals("Problem")) {
				data[z][1] = "Problem";
				data[z][2] = details;
			}
		}
		
		//System prints for debugging
		for(int x=0;x<data.length;x++) {
			for(int y=0;y<data[x].length;y++) {
				System.out.print(data[x][y]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		
		return data;
	}
	
}
