package CalcTree;

public class MinusOperator extends BinaryOperator{
	
	/** 
	 * Erzteugt einen neuen Minus Operator mit den �bergebenen Nachfolgern.
	 * 
	 * @param left linker Nachfolger
	 * @param right rechter Nachfolger
	 */
	public MinusOperator(CalcTreeNode left, CalcTreeNode right){
		super(left, right);
	}

	/** 
	 * Gibt die Differenz der Auswertung beider Nachfolger als Ergebnis zur�ck.
	 * 
	 * @return Ergebnis der Auswertung
	 */
	public int eval() {
		return leftChild.eval() - rightChild.eval();
	}
	
	/**
	 * Gibt die Stringrepresentation des Minus Operators zur�ck.
	 */
	public String toString(){
		return "-";
	}
	
}
