package bu.edu.cs673.edukid.settings.utils;

public enum Operator {

	ADD(" + "), SUBTRACT(" - ");

	private String operatorString;

	private Operator(String operatorString) {
		this.operatorString = operatorString;
	}

	public String getOperatorString() {
		return operatorString;
	}
}
