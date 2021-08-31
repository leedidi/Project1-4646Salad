import java.util.Scanner;
import java.io.IOException;

public class MMoneyChange 
{
	
	Scanner sc = new Scanner(System.in);
	//ManagerMode mm = new ManagerMode();

	int[] changenum = new int[5];		// temp ����� ����
	int[] changemoney = new int[5];		// ������ �ִ� �� �ƴϰ� �߰��� ���簡������
	

	// ���� ������ ��Ȳ
	public void rightNowChange()
	{
		System.out.println("=============���� ��Ȳ================");
		System.out.println();
		for (int i=0; i<Change.moneyCount.length; i++)
			System.out.printf("%5d�� : %3d��\n", Change.bills[i], Change.moneyCount[i]);
		System.out.println();
		System.out.println("========================================");
	}


	// ������ ���� �Է�(�ִ�100��)
	public void changeInput() throws IOException
	{
		System.out.println("������ ���� ���� 100��");
		for (int i = 0;i<5 ;i++ )
		{
			do
			{
				System.out.printf("%d���� ���� (�Է°����� ����˴ϴ�.) : ",Change.bills[i]);
				changenum[i] = sc.nextInt();
			}
			while (changenum[i] >100 ||  changenum[i]<=0);
		}
		System.out.println();
		realChange();

	}


	// ��¥ �������� ����� �޼ҵ�
	public void realChange() throws IOException
	{
		System.out.println("�ڼ��� ���� Ȯ�� �� [������ ���]�� ���ư��ϴ�.��");
		System.out.print("������ �����Ͻðڽ��ϱ�? (Y/N) : ");
		String real = sc.next().toUpperCase();
		
		if (real.equals("Y"))
		{
			for (int i=0; i<5; i++)
				Change.moneyCount[i] = changenum[i];
			rightNowChange();	// ���� �����Ȳ
		}
		else	
			System.out.println("\n������ ������� �ʾҽ��ϴ�.\n");	

		System.out.println("������ ���� ���ư��ϴ�.");

		ManagerMode mm = new ManagerMode();
		mm.mMenuPrint();
		mm.mMenuSelect();
		mm.mMenuRun();

	}
}