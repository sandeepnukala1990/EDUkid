package bu.edu.cs673.edukid.settings.utils;

public class MathProblem {

	private int operand1;
	
	private int operand2;

	private Operator operator;

	public MathProblem(int operand1, int operand2, Operator operator) {
		this.operand1 = operand1;
		this.operand2 = operand2;
		this.operator = operator;
	}

	public String getQuestion() {
		return "What is " + operand1 + operator.getOperatorString() + operand2
				+ "?";
	}

	public int getOperand1() {
		return operand1;
	}

	public int getOperand2() {
		return operand2;
	}

	public Operator getOperator() {
		return operator;
	}

	public int getAnswer() {
		if (operator == Operator.ADD) {
			return operand1 + operand2;
		}

		return operand1 - operand2;
	}
}
