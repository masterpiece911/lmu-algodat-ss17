package CalcTree;

public class Test {

	/**
	 * Generates a CalcTree, calculates the result and writes the tree to the console in post-, pre- and in-order.
	 */
	public static void main(String[] args) {
		CalcTreeNode tree = new MultiplicationOperator(new PlusOperator(new MinusOperator(new Value(4),new Value(5)), new Value(3)), new DivisionOperator(new Value(8), new Value(2)));
		
		System.out.println(tree.inOrderString());
		System.out.println(tree.preOrderString());
		System.out.println(tree.postOrderString());
		
		System.out.println(tree.eval());
	
	}

}
