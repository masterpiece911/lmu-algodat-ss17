package CalcTree;

public class DivisionOperator extends BinaryOperator{
	
	
	/** 
	 * Erzteugt einen neuen Divisions Operator mit den übergebenen Nachfolgern.
	 * 
	 * @param left linker Nachfolger
	 * @param right rechter Nachfolger
	 */
	public DivisionOperator(CalcTreeNode left, CalcTreeNode right){
		super(left, right);
	}

	/** 
	 * Gibt den Quotienten der Auswertung beider Nachfolger als Ergebnis zurück.
	 * 
	 * @return Ergebnis der Auswertung
	 */
	public int eval() {
		return leftChild.eval() / rightChild.eval();
	}
	
	/**
	 * Gibt die Stringrepresentation des Divisions Operators zurück.
	 */
	public String toString(){
		return ":";
	}
	
}
