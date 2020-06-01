
public class TaskEvent extends Event{

	private String taskCategory;
	private String taskContractor;
	private String taskProjectedCompletion;
	
	public TaskEvent() {
		super();
	}

	public TaskEvent(String input1, String input2, String[] input3) {
		super(input1, input2);
		super.operation = super.operationOptions[2];
		
		assert input3.length >= 3;
		
		taskCategory = input3[0];
		taskContractor = input3[1];
		taskProjectedCompletion = input3[2];
	}
	
	public TaskEvent(String input1, String input2, String input3, String input4, String input5) {
		super(input1, input2);
		super.operation = super.operationOptions[2];
		
		taskCategory = input3;
		taskContractor = input4;
		taskProjectedCompletion = input5;
	}
	
	public String getTaskCategory() {
		return taskCategory;
	}

	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
	}

	public String getTaskContractor() {
		return taskContractor;
	}

	public void setTaskContractor(String taskContractor) {
		this.taskContractor = taskContractor;
	}

	public String getTaskProjectedCompletion() {
		return taskProjectedCompletion;
	}

	public void setTaskProjectedCompletion(String taskProjectedCompletion) {
		this.taskProjectedCompletion = taskProjectedCompletion;
	}

	public String toString() {
		String output = client + " edited " + projectName + "'s " + operation + " page: A " +
						taskCategory + " task was contracted with " + taskContractor + " set for " + taskProjectedCompletion;
		return output;
	}
	
	public String scriptLog() {
		String output = client + "~" + projectName + "~" + "2" + "~" + taskCategory +
						"~" + taskContractor + "~" + taskProjectedCompletion + "~";
		return output;
	}
	
}

