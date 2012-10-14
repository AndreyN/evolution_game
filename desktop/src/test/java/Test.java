import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Test {
	private class Element {
		private int number;
		
		public Element(int number) {
			this.number = number;
		}
		
		public int getNumber() {
			return number;
		}
		
		public void setNumber(int number) {
			this.number = number;
		}
		
		public String toString() {
			return Integer.toString(number) + "t";
		}
	}
	
	private class ElementWrapper {
		private int position;
		private Element element;
		
		public ElementWrapper(Element element, int position) {
			this.element = element;
			this.position = position;
		}
	}
	
	private int m_count = 0;
	private List<Element> m_list;
	private int m_uniqueNumber = 0;
	
	private void setNumber(Element element, int number) {
		m_count++;
		element.setNumber(number);
		print(m_list);
		Set<Integer> set = new HashSet<Integer>();
		for(Element x: m_list)
			set.add(x.number);
		if(m_list.size() != set.size())
			throw new IllegalStateException();
	}
	
	public List<Element> createList() {
		List<Element> list = new ArrayList<Element>();
		/*list.add(new Element(7));
		list.add(new Element(6));
		list.add(new Element(3));
		list.add(new Element(1));
		list.add(new Element(5));*/
		/*list.add(new Element(1));
		list.add(new Element(2));
		list.add(new Element(7));
		list.add(new Element(0));*/
		int size = 100;
		for(int i = 0; i < size; i++)
			list.add(new Element(i));
		Collections.shuffle(list);
		return list;
	}
	
	public int getUnigueNumber(List<Element> list) {
		return Integer.MAX_VALUE;
	}
	
	public void variant2() {
		m_list = createList();
		Map<Integer, ElementWrapper> collisionMap = new HashMap<Integer, ElementWrapper>();
		Map<Element, Integer> removeCollisionMap = new HashMap<Element, Integer>();
		
		for(int i = 0; i < m_list.size(); i++) {
			Element element = m_list.get(i);
			collisionMap.put(element.number, new ElementWrapper(element, i));
			removeCollisionMap.put(element, element.number);
		}
		
		m_uniqueNumber = getUnigueNumber(m_list);
		print(m_list);
		for(int i = 0; i < m_list.size(); i++) {
			Element element = m_list.get(i);
			int temp = element.number;
			if(temp != i) {
				Set<Integer> collisions = new HashSet<Integer>();
				collisions.add(temp);
				Element result = search(collisionMap, i, element, collisions, removeCollisionMap);
				if(result != null) {
					setNumber(result, temp);
					collisionMap.remove(removeCollisionMap.get(element));
				}
				System.out.print("Result for iteration " + i + ":");
				print(m_list);
			}
		}
		System.out.println(m_count);
	}
	
	/**
	 * 
	 * @param collisionMap все элементы, дл€ быстрого доступа по их номеру
	 * @param elementPosition позици€ элемента в результирующем списке
	 * @param element элемент, дл€ которого пытаемс€ установить пор€дковый номер
	 * @param collisions мн-во коллизий
	 * @param removeCollisionMap дл€ быстрого удалени€
	 * @return элемент, если ему нужно установить правильный номер
	 */
	public Element search(Map<Integer, ElementWrapper> collisionMap, int elementPosition, Element element, Set<Integer> collisions, 
			Map<Element, Integer> removeCollisionMap) {
		Element collisionElement = collisionMap.get(elementPosition).element;
		if(collisionElement == null) {
			setNumber(element, elementPosition);
			collisionMap.remove(removeCollisionMap.get(element));
		} else {
			if(!collisions.contains(collisionElement.number)) {
				collisions.add(collisionElement.number);
				Element result = search(collisionMap, collisionMap.get(collisionElement.number).position, collisionElement, collisions, removeCollisionMap);
				setNumber(element, elementPosition);
				collisionMap.remove(removeCollisionMap.get(element));
				if(result != null)
					return result;
			} else {
				setNumber(element, m_uniqueNumber);
				return element;
			}
		}
		return null;
	}
	
	private void print(List<Element> list) {
		StringBuilder b = new StringBuilder();
		for(Element e: list)
			b.append(',').append(e.number);
		if(b.length() > 0)
			System.out.println(b.toString().substring(1));
	}
	
	public static void main(String[] args) {
		System.out.println("start");
		Test t = new Test();
		t.variant2();
	}
}
