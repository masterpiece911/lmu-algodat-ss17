package CalcTree;

public class MultiplicationOperator extends BinaryOperator{
	
	/** 
	 * Erzteugt einen neuen Multiplikations Operator mit den übergebenen Nachfolgern.
	 * 
	 * @param left linker Nachfolger
	 * @param right rechter Nachfolger
	 */
	public MultiplicationOperator(CalcTreeNode left, CalcTreeNode right){
		super(left, right);
	}

	/** 
	 * Gibt das Produkt der Auswertung beider Nachfolger als Ergebnis zurück.
	 * 
	 * @return Ergebnis der Auswertung
	 */
	public int eval() {
		return leftChild.eval() * rightChild.eval();
	}
	
	/**
	 * Gibt die Stringrepresentation des Multiplikations Operators zurück.
	 */
	public String toString(){
		return "*";
	}
	
}
