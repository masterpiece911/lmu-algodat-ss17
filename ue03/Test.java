import CalcTree.CalcTreeNode;
import CalcTree.DivisionOperator;
import CalcTree.MinusOperator;
import CalcTree.MultiplicationOperator;
import CalcTree.PlusOperator;
import CalcTree.Value;

public class Test {

	/**
	 * Erzeugt einen Operatorbaum, berechnet das Ergebnis und gibt den Baum in Pre-, In- und Postorder-Darstellung aus.
	 */
	public static void main(String[] args) {
		CalcTreeNode tree = new MultiplicationOperator(new PlusOperator(new MinusOperator(new Value(4),new Value(5)), new Value(3)), new DivisionOperator(new Value(8), new Value(2)));
		
		System.out.println("Ergebnis der Auswertung: " + tree.eval());
		System.out.println("Preorder:  " + tree.preOrderString());
		System.out.println("Postorder: " + tree.postOrderString());
		System.out.println("Inorder:   " + tree.inOrderString());
	
	}

}
