import java.util.Vector;
import java.util.Hashtable;
import java.util.ArrayList;

public class ISetup
{
	static Vector<Ingredient> v = new Vector<Ingredient>();
	static Vector<String> payment = new Vector<String>(); 
	static StringBuffer sbNote = new StringBuffer("");

	static Hashtable<Integer, Integer> payNum = new Hashtable<Integer, Integer>();
	static ArrayList<String> payArray= new ArrayList<String>();


	public ISetup()	//�ʱ���Ἴ��
	{
		// ��ä �� 1
		v.add(new Ingredient(1, "�����", 20, 11, 2000));
		v.add(new Ingredient(1, "���", 10, 34, 1000));
		v.add(new Ingredient(1, "����丶��", 10, 8, 1000));
		v.add(new Ingredient(1, "����", 10, 35, 1000));
		v.add(new Ingredient(1, "����", 10, 9, 1000));

		// ���� �� 2
		v.add(new Ingredient(2, "����", 3, 106, 2500));
		v.add(new Ingredient(2, "������", 3, 145, 1800));
		v.add(new Ingredient(2, "�߰�����", 3, 107, 1500));

		// �ҽ� �� 3
		v.add(new Ingredient(3, "�߻��", 3, 27, 500));
		v.add(new Ingredient(3, "������Ż",3,28,500));
		v.add(new Ingredient(3, "�����巹��",3,65,700));
		v.add(new Ingredient(3, "��ϸӽ�Ÿ��",3,30,300));

		// ���� �� 4
		v.add(new Ingredient(4, "ġ��", 3, 25, 300));
		v.add(new Ingredient(4, "�����ķ���ũ", 4, 77, 300));
	}

} //end ISetup class