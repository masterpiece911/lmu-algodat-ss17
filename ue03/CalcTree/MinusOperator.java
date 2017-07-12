package CalcTree;

public class MinusOperator extends BinaryOperator{
	
	/** 
	 * Erzteugt einen neuen Minus Operator mit den übergebenen Nachfolgern.
	 * 
	 * @param left linker Nachfolger
	 * @param right rechter Nachfolger
	 */
	public MinusOperator(CalcTreeNode left, CalcTreeNode right){
		super(left, right);
	}

	/** 
	 * Gibt die Differenz der Auswertung beider Nachfolger als Ergebnis zurück.
	 * 
	 * @return Ergebnis der Auswertung
	 */
	public int eval() {
		return leftChild.eval() - rightChild.eval();
	}
	
	/**
	 * Gibt die Stringrepresentation des Minus Operators zurück.
	 */
	public String toString(){
		return "-";
	}
	
}
