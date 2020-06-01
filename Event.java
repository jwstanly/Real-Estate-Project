import java.util.ArrayList;

public abstract class Event {
	
	protected static final String[] operationOptions = {"Undeclaired","Data","Task","Comment","Problem"};
	
	protected String client;
	protected String projectName;
	protected String operation;
	
	public Event() {
		client = "NA";
		projectName = "NA";
		operation = operationOptions[0];
	}
	
	public Event(String input, String input2) {
		client = input;
		projectName = input2;
		operation = operationOptions[0];
	}
	
	public Event(String input, String input2, int input3) {
		client = input;
		projectName = input2;
		operation = operationOptions[input3];
	}
	
	public static String[] getOperationOptions() {
		return operationOptions;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String toString() {
		String output = client + " edited " + projectName + "'s " + operation + " page";
		return output;
	}
	
	public String scriptLog() {
		String output = client + "~" + projectName + "~" + "0" + "~";
		return output;
	}
}
