
public class Account {
	
	//variables
	private int index;
	private String username;
	private String password;
	private String name;
	
	//constructors
	public Account(int i, String u, String p, String n) {
		index = i;
		username = u;
		password = p;
		name = n;
	}
	public Account() {
		this(0, "", "", "");
	}
	public void setAccount(Account a) {
		index = a.getIndex();
		username = a.getUsername();
		password = a.getPassword();
		name = a.getName();
	}
	
	//setters
	public void setIndex(int i){
		index = i;
	}
	public void setUsername(String u) {
		username = u;
	}
	public void setPassword(String p) {
		password = p;
	}
	public void setName(String n) {
		name = n;
	}
	
	//getters
	public int getIndex(){
		return index;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
}
