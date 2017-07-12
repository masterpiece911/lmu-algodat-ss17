package CalcTree;

public class DivisionOperator extends BinaryOperator{
	
	
	/** 
	 * Erzteugt einen neuen Divisions Operator mit den �bergebenen Nachfolgern.
	 * 
	 * @param left linker Nachfolger
	 * @param right rechter Nachfolger
	 */
	public DivisionOperator(CalcTreeNode left, CalcTreeNode right){
		super(left, right);
	}

	/** 
	 * Gibt den Quotienten der Auswertung beider Nachfolger als Ergebnis zur�ck.
	 * 
	 * @return Ergebnis der Auswertung
	 */
	public int eval() {
		return leftChild.eval() / rightChild.eval();
	}
	
	/**
	 * Gibt die Stringrepresentation des Divisions Operators zur�ck.
	 */
	public String toString(){
		return ":";
	}
	
}
