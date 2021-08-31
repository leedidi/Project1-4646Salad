import java.util.Vector;
import java.util.Scanner;
import java.io.IOException;


// ��Ʈ����
// ��Ű�� ������ Ŭ����
public class UPackageSalad
{
	static Vector<Ingredient> salmon = new Vector<Ingredient>();
	static Vector<Ingredient> cajun = new Vector<Ingredient>();
	static Vector<Ingredient> chicbr = new Vector<Ingredient>();

	TempStation ts = new TempStation();

	public static void uPackageStock() // �޴� ���� �޼ҵ�
	{
		// ���� ��� �������� ������ ���� �ؾ���
			
		// ���� ������ : ����, �����, ���, ����, ������Ż, ���� (-500��)
		salmon.add(ISetup.v.get(5));	// ����
		salmon.add(ISetup.v.get(0));	// �����
		salmon.add(ISetup.v.get(1));	// ���				
		salmon.add(ISetup.v.get(2));	// ����
		salmon.add(ISetup.v.get(3));	// ����
		salmon.add(ISetup.v.get(9));	// ������Ż

		// ������ ������ : ������, ��ϸӽ�Ÿ��, �����, ����, ��� (-500��)
		cajun.add(ISetup.v.get(6));		// ������
		cajun.add(ISetup.v.get(11));	// ��ϸӽ�Ÿ��
		cajun.add(ISetup.v.get(0));		// �����
		cajun.add(ISetup.v.get(2));		// ����丶��
		cajun.add(ISetup.v.get(1));		// ���

		// �߰����� ������ : ����, �߰�����, �����, ����, ���, �߻�� (-500��)
		chicbr.add(ISetup.v.get(7));	// �߰�����
		chicbr.add(ISetup.v.get(4));	// ����
		chicbr.add(ISetup.v.get(0));	// �����
		chicbr.add(ISetup.v.get(2));	// ����丶��
		chicbr.add(ISetup.v.get(8));	// �߻��
	}//end uPackageStock()	


	public void uPackagePrint()
	{
		System.out.println();
		System.out.println("��������������������������������������������������������������������������������");
		System.out.println("��                                      ��");
		System.out.println("��                                      ��");
		System.out.println("��          [��Ű¡ ������]             ��");
		System.out.println("��         (���� �޴��� : -1)           ��");
		System.out.println("��                                      ��");
		System.out.println("��         1. ���� ������               ��");
		System.out.println("��         2. ������ ������             ��");
		System.out.println("��         3. �߰����� ������           ��");
		System.out.println("��                                      ��");
		System.out.println("��                                      ��");
		System.out.println("��������������������������������������������������������������������������������");
		System.out.println();
	}//end uPackagePrint()
	

	public void uPackageSalad() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		UserMode um = new UserMode();

		// 1. ��Ű¡ �������� ������ �����Ͽ� ���
		//���� uPackageStock() ��ȯ
		uPackageStock();
		uPackagePrint();
		
		// 2. �����ڰ� �����ϰ� ���� �������� ��ȣ �Է�
		while (true)
		{
			System.out.print("�޴� ���� : ");
			Password.sel = sc.nextInt();

			if((Password.sel>0 && Password.sel<4) || Password.sel==-1)		// �޴� ��ȣ �ùٸ��� �Է� ��
				break;			    // �ݺ��� Ż��
			System.out.println("\n�Է¿� ������ �ֽ��ϴ�.\n");	// �ùٸ��� �ʰ� �Է� �� �޼��� ǥ�� �� �ٽ� �Է¹���	
		}
		
		if (Password.sel == Menus.E_MINUS)
		{
			um.uMenuPrint();
			um.uMenuSelect();
			um.uMenuRun();
		}

		if (Password.sel == Menus.E_ONE)
		{
			for (int i=0;i<salmon.size();i++)
			{
				if (salmon.get(i).num<1)
				{
					System.out.printf("[%s] sold out\n", ISetup.v.get(i).name);
					System.out.printf("�ٸ� �޴��� �̿����ּ���. �˼��մϴ�.");
					um.uMenuPrint();
					um.uMenuSelect();
					um.uMenuRun();
				}
			}
			ts.tStation(salmon);
			salmon.clear();
		}
		else if (Password.sel == Menus.E_TWO)
		{
			for (int i=0;i<cajun.size();i++)
			{
				if (cajun.get(i).num<1)
				{
					System.out.printf("[%s] sold out\n", ISetup.v.get(i).name);
					System.out.printf("�ٸ� �޴��� �̿����ּ���. �˼��մϴ�.");
					um.uMenuPrint(); 
					um.uMenuSelect();	
					um.uMenuRun();   	
				}
			}
			ts.tStation(cajun);
			cajun.clear();
		}
		else 
		{
			for (int i=0;i<chicbr.size();i++)
			{
				if (chicbr.get(i).num<1)
				{
					System.out.printf("[%s] sold out\n", ISetup.v.get(i).name);
					System.out.printf("�ٸ� �޴��� �̿����ּ���. �˼��մϴ�.");
					um.uMenuPrint();    
					um.uMenuSelect();	
					um.uMenuRun();   	
				}
			}
			ts.tStation(chicbr);
			chicbr.clear();
		}

	}//end Vector<Ingredient> uPackageSalad()
}//end uPackageSalad()