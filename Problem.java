public class Problem implements Comparable<Problem>{
	private int priority;
	private String title;
	private String description;
	
	public Problem(){
		priority = 1;
		title = "NA";
		description = "";
	}
	
	public Problem(String s, String s2, int n){
		priority = n;
		title = s;
		description = s2;
	}
	
	public Problem(String s, int n){
		priority = n;
		title = s;
		description = "";
	}
	
	public String toString(){
		return "TITLE: " + title + " ... PRIORITY: " + priority;
	}
	
	public void setPriority(int n){
		priority = n;}
	
	public int getPriority(){
		return priority;}
	
	public void setTitle(String n){
		title = n;}
	
	public String getTitle(){
		return title;}
	
	public void setDescription(String n){
		description = n;}
	
	public String getDescription(){
		return description;}
	
	
	public int compareTo(Problem anotherProblem){
		return this.getPriority() - anotherProblem.getPriority();
	}
}

