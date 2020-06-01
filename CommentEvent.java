
public class CommentEvent extends Event{

	private String comment;
	
	public CommentEvent() {
		super();
	}

	public CommentEvent(String input1, String input2, String input3) {
		super(input1, input2);
		super.operation = super.operationOptions[3];
		comment = input3;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String toString() {
		String output = client + " edited " + projectName + "'s " + operation + " page: \"" +
						comment + "\" was commented by " + client;
		return output;
	}

	public String scriptLog() {
		String output = client + "~" + projectName + "~" + "3" + "~" + comment + "~";
		return output;
	}
}

