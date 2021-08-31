
import java.util.Scanner;
import java.io.IOException;

public class MStorageNew
{
	String name;				// �߰� ǰ�� �̸� ����
	int cate,num,kcal,money;	// �߰� ǰ�� ī�װ�, ����, Į�θ�, �ݾ� ����

	private static Scanner sc;
	private static ManagerMode mm;

	static
	{
		// Scanner �ν��Ͻ� ����
		 sc = new Scanner(System.in);

		// ManagerMode �ν��Ͻ� ����
		 mm = new ManagerMode();
	}


	public void mAddRemove() throws IOException // ǰ�� �߰�/ ���� �޼ҵ�
	{
		System.out.println("ǰ�� �߰�/���� ");

		System.out.print("ǰ�� �߰� ��(+), ����(-) �� �Է� : ");
		Password.op = sc.next();

		switch (Password.op)
		{
			case "+" : mNewAdd(); break;
			case "-" : mNewRemove(); break;
		}
	}//end mAddRemove()


	public void mNewAdd() throws IOException // �߰� �޼ҵ�
	{
		// ���� �߰��� ǰ���� ī�װ�, ǰ���, ����, Į�θ�, �ݾ� �Է�
		System.out.println("(��ä : 1, ���� : 2, �ҽ� : 3, ���� : 4)");
		System.out.print("���ο� ǰ���� ī�װ��� �Է����ּ��� : ");
		cate = sc.nextInt();

 		System.out.print("�� ǰ����� �Է����ּ��� : ");
		name = sc.next();

		System.out.print("�� ������ �Է����ּ��� : ");
		num = sc.nextInt();

		System.out.print("�� Į�θ��� �Է����ּ��� : ");
		kcal = sc.nextInt();

		System.out.print("�� �ݾ��� �Է����ּ��� : ");
		money = sc.nextInt();
			
		System.out.println();
		System.out.println(" [ǰ���] [����] [Į�θ�] [�ݾ�]");	
		System.out.printf("%5s %4d %4dkcal %5d��",name,num,kcal,money);

		System.out.println();
		System.out.print("������ �߰��Ͻðڽ��ϱ�? (Y/N) : ");
		Password.con = sc.next().toUpperCase();
 
		if (Password.con.equals("Y"))	// Y �Է��� ���
		{								// v���Ϳ� ǰ�� �߰�
			ISetup.v.add(new Ingredient(cate,name,num,kcal,money));

			System.out.printf("\n<<%sǰ���� �߰��Ǿ����ϴ�.>>\n",name);

			mStorageNewReturn();	// ǰ�� �߰�/���� ��� ����� �޼ҵ� ȣ��
		}
		else
		{
			System.out.println("�߰��� ��ҵǾ����ϴ�");

			mStorageNewReturn();	// ǰ�� �߰�/���� ��� ����� �޼ҵ� ȣ��
		}						

	}//end mNewAdd()


	public void mNewRemove() throws IOException	// ǰ�� ���� �޼ҵ�
	{	
		System.out.print("������ ǰ����� �Է����ּ��� : ");
		name = sc.next();

		for (int i=0; i<ISetup.v.size(); i++)		// v���͸� ���鼭
		{
			if (ISetup.v.get(i).name.equals(name))	// �Է��� ǰ��� ��ġ�ϴ� ǰ���� ã�Ƽ�
			{										// ��ǰ���� ��ġ�� ��� ǰ�� ����
				ISetup.v.remove(i);

				System.out.printf("\n<<%sǰ���� ���ŵǾ����ϴ�.>>\n",name);

				mStorageNewReturn();	// ǰ�� �߰�/���� ��� ����� �޼ҵ� ȣ��
			}
		}

	}//end mNewRemove()


	public void mStorageNewReturn() throws IOException	// ǰ�� �߰�/���� ��� ����� �޼ҵ�
	{

		System.out.print("ǰ�� �߰�/������ ��� �Ͻðڽ��ϱ�? (Y/N) : ");
		Password.con = sc.next().toUpperCase();

		Password pw = new Password();

		if (Password.con.equals("Y"))	// Y �Է��� ���
			mAddRemove();				// ǰ�� �߰�/���� �����
		else
			pw.modePrint();
			pw.modeSelect();
			pw.modeRun();				// �ƴҰ�� ������ ����
		//else => ������ ���� ���� &&
	}//end mStorageNewReturn()

}//end class