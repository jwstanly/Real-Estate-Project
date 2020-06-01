import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

public class Driver {

	public static void main(String[] args) throws Exception {
		
		DataEvent de = new DataEvent("John Wright Stanly", "Summer Woods", "Average Cost Per Lot", "15000", "10000");
		TaskEvent te = new TaskEvent("John Wright Stanly", "Summer Woods", "Furniture", "Lowes", "3/6/2019");
		CommentEvent ce = new CommentEvent("John Wright Stanly", "Summer Woods", "This is a test comment!");
		ProblemEvent pe = new ProblemEvent("John Wright Stanly", "Summer Woods", "YungThug", "Help a thugger out", "5", 0);
		
		EventScripter.addEvent(de);
		EventScripter.addEvent(te);
		EventScripter.addEvent(ce);
		EventScripter.addEvent(pe);
		
		EventScripter.buildStackFromEventLogFile();
		
		EventScripter.removeEvent(de);
		
		System.out.println(EventScripter.getEventStack());
	}

}
