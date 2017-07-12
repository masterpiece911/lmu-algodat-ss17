
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
	 * Gibt den Wert des ersten Elementes zurück.
	 * Ist die Liste leer so wird 0 zurückgegeben.
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
	 * Fügt ein neues Element am Anfang der Liste ein.
	 * 
	 * @param value Wert der eingefügt wird.
	 */
	public void insert(int value){
		Node node = new Node();
		node.value = value;
		node.next = head;
		
		head = node;
	}
	
	/**
	 * Fügt ein Element an der gegebenen Position ein.
	 * Wenn die Position größer ist als die Länge der Liste 
	 * wird das Element am Ende der Liste eingefügt.
	 * 
	 * @param value	Wert der eingefügt werden soll
	 * @param pos Position an der eingefügt werden soll.
	 */
	public void insert(int value, int pos){		
		
		// Falls am Anfang eingefügt werden soll nutzen wir
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
		
		// Erstellen eines neuen Nodes und einfügen an der aktuellen 
		// Position
		Node node = new Node();
		node.value = value;
		node.next = position.next;
		
		position.next = node;
	}
	
	/**
	 * Löscht das erste Element aus der Liste, falls dieses
	 * vorhanden ist. 
	 */
	public void delete(){
		if(head != null)
		head = head.next;
	}
		
	/**
	 * Löscht das Element an der gegebenen Position.
	 * Wenn die Liste kürzer ist als die angegebene Position
	 * wird kein Element gelöscht.
	 */ 
	public void delete(int pos){
		
		// Falls am Anfang eingefügt werden soll nutzen wir
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
		
		// von aktueller Position aus ein Element überspring
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
		
		// fügt jeweils das erste Element der Liste in die neue, sortierte Liste ein und löscht es dann. 
		while(head != null){	
			
			// nehme das erste Element aus der Liste heraus:
			Node node = head;
			head = head.next;
						
			// Falls das einzufügende Element das erste in der  sortierten Liste sein wird - direkt einfügen,
			// sonst bis zur entsprechenden Stelle vorlaufen und dort einfügen 
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
