
class Node{
	int value;
	Node next;
}

public class List {
		
	private Node head;
	
	public List(){
		head = null;
	}
	
	/**
	 * Gibt den Wert des ersten Elementes zur�ck.
	 * Ist die Liste leer so wird 0 zur�ckgegeben.
	 * 
	 * @return Wert des ersten Elements
	 */
	public int getFirst(){
		if(head != null)
			return head.value;
		else 
			return 0;
	}
	
	public boolean empty(){
		return head == null;		
	}
	
	/**
	 * F�gt ein neues Element am Anfang der Liste ein.
	 * 
	 * @param value Wert der eingef�gt wird.
	 */
	public void insert(int value){
		Node node = new Node();
		node.value = value;
		node.next = head;
		
		head = node;
	}
	
	/**
	 * F�gt ein Element an der gegebenen Position ein.
	 * Wenn die Position gr��er ist als die L�nge der Liste 
	 * wird das Element am Ende der Liste eingef�gt.
	 * 
	 * @param value	Wert der eingef�gt werden soll
	 * @param pos Position an der eingef�gt werden soll.
	 */
	public void insert(int value, int pos){		
		
		// Falls am Anfang eingef�gt werden soll nutzen wir
		// die entsprechende Methode
		if(pos <= 0)
			insert(value);
		
		// Hilfszeiger position vom Kopf aus pos-1 viele Nodes 
		// weiter schieben
		Node position = head;
		for(int i = 0; i < pos-1; i++){
			if(position.next != null)
				position = position.next;
		}
		
		// Erstellen eines neuen Nodes und einf�gen an der aktuellen 
		// Position
		Node node = new Node();
		node.value = value;
		node.next = position.next;
		
		position.next = node;
	}
	
	/**
	 * L�scht das erste Element aus der Liste, falls dieses
	 * vorhanden ist. 
	 */
	public void delete(){
		if(head != null)
		head = head.next;
	}
		
	/**
	 * L�scht das Element an der gegebenen Position.
	 * Wenn die Liste k�rzer ist als die angegebene Position
	 * wird kein Element gel�scht.
	 */ 
	public void delete(int pos){
		
		// Falls am Anfang eingef�gt werden soll nutzen wir
		// die entsprechende Methode
		if(pos <= 0)
			delete();
		
		// Hilfszeiger position vom Kopf aus pos-1 viele Nodes 
		// weiter schieben
		Node position = head;
		for(int i = 0; i < pos-1; i++){
			if(position.next != null)
				position = position.next;
			else return;
		}
		
		// von aktueller Position aus ein Element �berspring
		position.next = position.next.next;
	}
	
	
	/**
	 * Dreht die Liste um
	 */
	public void reverse(){
		
		// Die leere Liste sowie die Liste mit nur einem Element muss nicht gedreht werden.
		if(head == null || head.next == null)
			return;
		
		Node newList = null;
		Node node = null;
		
		while(head != null){
			node = head;
			head = head.next;
			node.next = newList;
			newList = node;
		}
		
		head = newList;
		
		
	}
	
	
	/**
	 * Sortiert die Liste der Integer aufsteigend.
	 */
	public void sort(){
		
		// Die leere Liste sowie die Liste mit nur einem Element sind bereits sortiert.
		if(head == null || head.next == null)
			return;
		
		Node sortList = null;
		
		// f�gt jeweils das erste Element der Liste in die neue, sortierte Liste ein und l�scht es dann. 
		while(head != null){	
			
			// nehme das erste Element aus der Liste heraus:
			Node node = head;
			head = head.next;
						
			// Falls das einzuf�gende Element das erste in der  sortierten Liste sein wird - direkt einf�gen,
			// sonst bis zur entsprechenden Stelle vorlaufen und dort einf�gen 
			if(sortList == null || sortList.value > node.value){
				node.next = sortList;
				sortList = node;
			}else{
				Node pos  = sortList;			 
				
				while(pos.next != null && pos.next.value < node.value){
					pos = pos.next;
				}
			
				node.next = pos.next;
				pos.next = node;
			}				
		}
		
		head = sortList;
		
		
	}
	
	public static void main(String[] args){
		List liste = new List();

		liste.insert(2);
		liste.insert(5);
		liste.insert(3);
		liste.insert(4);
		liste.insert(1);
		
		liste.sort();
		
		liste.reverse();

		
		while(!liste.empty()){
			System.out.println(liste.getFirst());
			liste.delete();
		}
		
		
	}
	
	
}
