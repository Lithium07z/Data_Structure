import java.util.NoSuchElementException;

public class DList <E> {
	protected DNode head, tail; // ����� ���۰� �� �� 
	protected int size;

	public DList() { // ���� ���Ḯ��Ʈ ������
		head = new DNode (null, null, null); // Dummy ���
		tail = new DNode (null, head, null); // tail�� ���� ��带 head�� ����� 
		head.setNext(tail); // head�� ���� ��带 tail�� ����� 
		size = 0;
	}

	public void insertBefore(DNode p, E newItem) { // p�� ����Ű�� ���� ��� t�տ� ����
		DNode t = p.getPrevious(); // p�� ���� ��带 t�� ���� 
		DNode newNode = new DNode(newItem, t, p); // �ڷδ� t �����δ� p�� ����Ű�� ���ο� newNode�� ����  
		p.setPrevious(newNode); // p�� ���� ��ũ�� newNode�� �����  
		t.setNext(newNode); // t�� ���� ��ũ�� newNode�� ����� �ᱹ t - newNode - p �� ����
		size++; // �߰������� ������ ���� 
	}
	
	public void insertAfter(DNode p, E newItem) { // p�� ����Ű�� ���� ��� t�ڿ� ����
		DNode t = p.getNext(); // p�� ���� ��带 t�� ����
		DNode newNode = new DNode(newItem, p, t); // �ڷδ� p �����δ� t�� ����Ű�� ���ο� newNode�� ����
		t.setPrevious(newNode); // t�� ���� ��ũ�� newNode�� �����
		p.setNext(newNode); // p�� ���� ��ũ�� newNode�� ����� �ᱹ  p - newNode - t �� ����
		size++; // �߰������� ������ ���� 
	}
	
	public void delete(DNode x) { // x�� ����Ű�� ��� ����
		if (x == null ) { // x��尡 ���ٸ� Exception ������ 
			throw new NoSuchElementException();
		}
		if (size <= 0) { // ��尡 ���ų� ������ ��� Exception ������
			throw new NoSuchElementException();
		}
		DNode f = x.getPrevious(); // f��忡 x����� ���� �� ����
		DNode r = x.getNext(); // r��忡 x����� ���� �� ���� 
		f.setNext(r); // f����� ���� ���� r���� ����
		r.setPrevious(f); // r����� ���� ���� f ���� ���� 
		size--; // ���������� ������ ���� ��� ���������� ������ ������ �ƴ� x��忡 ������ �� �ִ� ��ũ�� ��� ���ֹ��� ����
	}
	
	public void print() {
		DNode out = this.head.getNext();
		if (out.getNext() == null) { // head��� ������ null�̸� 
			System.out.println("����Ʈ �������");
		}
		for (int i = 0; i < this.size; i++) {
			System.out.print(out.getItem() + " ");
			out = out.getNext();
		}
		System.out.println();
	}
}
