package bu.edu.cs673.edukid.settings.utils;

import java.util.Random;

public class MathProblemGenerator {

	private MathProblemGenerator() {
	}

	/**
	 * Generates a random math problem with the following stipulations.
	 * 
	 * <ul>
	 * <li>The first operand is between 26 and 50</li>
	 * <li>The second operand is smaller than the first operand and > 0</li>
	 * <li>The two operands are at least 10 digits apart</li>
	 * </ul>
	 * 
	 * @return
	 */
	public static MathProblem generateMathProblem() {
		Random random = new Random();
		int operand1 = random.nextInt(24) + 26;
		int operand2 = random.nextInt(operand1 - 10) + 1;
		Operator operator = Operator.values()[random.nextInt(2)];

		return new MathProblem(operand1, operand2, operator);
	}
}
