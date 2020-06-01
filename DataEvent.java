
public class DataEvent extends Event{

	private String dataFieldChanged;
	private String originalDataValue;
	private String newDataValue;
	
	public DataEvent() {
		super();
	}

	public DataEvent(String input1, String input2, String[] input4) {
		super(input1, input2);
		super.operation = super.operationOptions[1];
		
		assert input4.length >= 3;
		
		dataFieldChanged = input4[0];
		originalDataValue = input4[1];
		newDataValue = input4[2];
	}
	
	public DataEvent(String input1, String input2, String input3, String input4, String input5) {
		super(input1, input2);
		super.operation = super.operationOptions[1];
		
		dataFieldChanged = input3;
		originalDataValue = input4;
		newDataValue = input5;
	}
	
	public String getDataFieldChanged() {
		return dataFieldChanged;
	}

	public void setDataFieldChanged(String dataFieldChanged) {
		this.dataFieldChanged = dataFieldChanged;
	}

	public String getOriginalDataValue() {
		return originalDataValue;
	}

	public void setOriginalDataValue(String originalDataValue) {
		this.originalDataValue = originalDataValue;
	}

	public String getNewDataValue() {
		return newDataValue;
	}

	public void setNewDataValue(String newDataValue) {
		this.newDataValue = newDataValue;
	}

	public String toString() {
		String output = client + " edited " + projectName + "'s " + operation + " page: " +
						dataFieldChanged + " was changed from " + originalDataValue + " to " + newDataValue;
		return output;
	}
	
	public String scriptLog() {
		String output = client + "~" + projectName + "~" + "1" + "~" + dataFieldChanged +
						"~" + originalDataValue + "~" + newDataValue + "~";
		return output;
	}
}
