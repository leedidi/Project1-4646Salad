import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Collections;

public class MMoneyCheck // ���� Ȯ�� Ŭ����
{
	private static Scanner sc;
	private static ManagerMode mm;
	
	public int sumMPay;	// ���� ����

	static
	{
		sc = new Scanner(System.in);

		mm = new ManagerMode();
	}

	
	public void mMoneyPrint()
	{
		System.out.println("\n             [���� Ȯ��]");
		
		System.out.println("������������������������������������������������������������������������������������");
		System.out.println("��		                         ��");
		System.out.println("��		                         ��");
		System.out.println("��               [��ä]                   ��");
		System.out.println("��		                         ��");
		int sumMPay = 0;      // ���� ���� ����

		for (int i=0; i<ISetup.v.size(); i++)
		{
			if (ISetup.v.get(i).cate == 1)
			{
				System.out.printf("��	%-6s\t %3d��\t %,5d�� ��\n", ISetup.v.get(i).name, Collections.frequency(ISetup.payArray, ISetup.v.get(i).name), 
												(Collections.frequency(ISetup.payArray, ISetup.v.get(i).name) * ISetup.v.get(i).money));
				sumMPay += (Collections.frequency(ISetup.payArray, ISetup.v.get(i).name) * ISetup.v.get(i).money);
			}
		}
		System.out.println("��		                         ��");
		System.out.println("��      --------------------------        ��");
		System.out.println("��		                         ��");
		System.out.println("��		                         ��");
		System.out.println("��               [����]                   ��");
		System.out.println("��		                         ��");
		for (int i=0; i<ISetup.v.size(); i++)
		{
			if (ISetup.v.get(i).cate == 2)
			{
				System.out.printf("��	%-6s\t %3d��\t %,5d�� ��\n", ISetup.v.get(i).name, Collections.frequency(ISetup.payArray, ISetup.v.get(i).name), 
												(Collections.frequency(ISetup.payArray, ISetup.v.get(i).name) * ISetup.v.get(i).money));
				sumMPay += (Collections.frequency(ISetup.payArray, ISetup.v.get(i).name) * ISetup.v.get(i).money);
			}
		}
		System.out.println("��		                         ��");
		System.out.println("��      --------------------------        ��");
		System.out.println("��		                         ��");
		System.out.println("��		                         ��");
		System.out.println("��               [�ҽ�]                   ��");
		System.out.println("��		                         ��");
		for (int i=0; i<ISetup.v.size(); i++)
		{
			if (ISetup.v.get(i).cate == 3)
			{
				System.out.printf("��	%-6s\t %3d��\t %,5d�� ��\n", ISetup.v.get(i).name, Collections.frequency(ISetup.payArray, ISetup.v.get(i).name), 
												(Collections.frequency(ISetup.payArray, ISetup.v.get(i).name) * ISetup.v.get(i).money));
				sumMPay += (Collections.frequency(ISetup.payArray, ISetup.v.get(i).name) * ISetup.v.get(i).money);
			}
		}
		System.out.println("��		                         ��");
		System.out.println("��      --------------------------        ��");
		System.out.println("��		                         ��");
		System.out.println("��		                         ��");
		System.out.println("��               [����]                   ��");
		System.out.println("��		                         ��");
		for (int i=0; i<ISetup.v.size(); i++)
		{
			if (ISetup.v.get(i).cate == 4)
			{
				System.out.printf("��	%-6s\t %3d��\t %,5d�� ��\n", ISetup.v.get(i).name, Collections.frequency(ISetup.payArray, ISetup.v.get(i).name), 
												(Collections.frequency(ISetup.payArray, ISetup.v.get(i).name) * ISetup.v.get(i).money));
				sumMPay += (Collections.frequency(ISetup.payArray, ISetup.v.get(i).name) * ISetup.v.get(i).money);
			}
		}
		System.out.println("��		                         ��");
		System.out.println("������������������������������������������������������������������������������������");

		// 2. �� ���� ���
		System.out.println();
		System.out.printf("�� �� ���� : %,5d��\n", sumMPay); 


	}//end mMoneyPrint()


	public void mMoneyCal() throws IOException	//�� ���Աݾ� Ȯ�� �� ��� 
	{
		UserMode um = new UserMode();

		//pay���� �ߺҷ�����~!!!!!!!!!!!!!!!!!!!!!!!!
		System.out.println("");

		int sumMPay = 0;	// ���� ����
		
		for (int i=1; i<um.count + 1;i++ )
			sumMPay += ISetup.payNum.get(i);
		
		System.out.printf("�� �� ���� �ݾ� : %,5d�� �Դϴ�.", sumMPay);

		// ����ϱ�
		System.out.println("\n����� ���� Ȯ�� �� [������ ���]�� ���ư��ϴ�.��");
		System.out.println("�ڰ��! �ǵ��� �� �����ϴ�.��");
		System.out.print("  ��� �Ͻðڽ��ϱ�? (Y/N) : ");
		String real = sc.next().toUpperCase();

		if (real.equals("Y"))				// UpperClass �� �ϱ�
		{
			System.out.println(sumMPay + "���� ��� �Ǿ����ϴ�.");
			sumMPay = 0;
		}

		mm.mMenuPrint(); //��ݿ��� ������� �����ڸ���...
		mm.mMenuSelect();
		mm.mMenuRun();

	}//end mMoneyCal()



}// end class MMoneyCheck