
public class ProblemEvent extends Event{

	private String problemTitle;
	private String problemDescription;
	private String problemPriority;
	private int problemAddedOrDeleted;
		//0=added (enqueued)
		//1=deleted (dequeued)
	
	public ProblemEvent() {
		super();
	}

	public ProblemEvent(String input1, String input2, String[] input3) {
		super(input1, input2);
		super.operation = super.operationOptions[4];

		assert input3.length >= 4;
		
		problemTitle = input3[0];
		problemDescription = input3[1];
		problemPriority = input3[2];
		int temp = Integer.parseInt(input3[3].trim());
		assert temp==0||temp==1;
		problemAddedOrDeleted = temp;
	}
	
	public ProblemEvent(String input1, String input2, String input3, String input4, String input5, int input6) {
		super(input1, input2);
		super.operation = super.operationOptions[4];

		problemTitle = input3;
		problemDescription = input4;
		problemPriority = input5;
		assert input6==0||input6==1;
		problemAddedOrDeleted = input6;
	}
	
	public String getProblemTitle() {
		return problemTitle;
	}

	public void setProblemTitle(String problemTitle) {
		this.problemTitle = problemTitle;
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public String getProblemPriority() {
		return problemPriority;
	}

	public void setProblemPriority(String problemPriority) {
		this.problemPriority = problemPriority;
	}

	public int getProblemAddedOrDeleted() {
		return problemAddedOrDeleted;
	}

	public void setProblemAddedOrDeleted(int problemAddedOrDeleted) {
		assert problemAddedOrDeleted==0||problemAddedOrDeleted==1;
		this.problemAddedOrDeleted = problemAddedOrDeleted;
	}

	public String toString() {
		String output = client + " edited " + projectName + "'s " + operation + " page: ";
		if(problemAddedOrDeleted==0) {
			output += problemTitle + " (" + problemDescription + ") was added as a problem with priority " + problemPriority;		
		}
		if(problemAddedOrDeleted==1) {
			output += problemTitle + " (" + problemDescription + ") was removed as a problem with priority " + problemPriority;
		}
		
		return output;
	}
	
	public String scriptLog() {
		String output = client + "~" + projectName + "~" + "4" + "~" + problemTitle +
						"~" + problemDescription + "~" + problemPriority +"~" + problemAddedOrDeleted + "~";
		return output;
	}
	
}

