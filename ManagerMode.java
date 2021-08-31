
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ManagerMode 
{
	private static BufferedReader br;
	private static Integer sel;				//-- ���� ��

	static
	{
		// BufferedReader �ν��Ͻ� ����
		br = new BufferedReader(new InputStreamReader(System.in));
	}


	public void mMenuPrint() // �޴� ��� �޼ҵ�
	{
		// �� �׽�Ʈ�� �ʿ�
		if (Change.moneyCount[0] == 0 || Change.moneyCount[1] == 0 || 
			Change.moneyCount[2] == 0 || Change.moneyCount[3] == 0 || 
			Change.moneyCount[4] < 5)
			System.out.println("�ذ��� ���������� �ʿ��մϴ�.");

		System.out.println();
		System.out.println("��������������������������������������������������������������������������������������");
		System.out.println("��                                         ��");
		System.out.println("��              [�޴� ���]                ��");
		System.out.println("��                                         ��");
		System.out.println("��            1. ��û���� Ȯ��             ��");
		System.out.println("��            2. ��� ����                 ��");
		System.out.println("��            3. �ݰ� ����                 ��");
		System.out.println("��            4. ��� ����                 ��");
		System.out.println("��                                         ��");
		System.out.println("��������������������������������������������������������������������������������������");
		System.out.println();
	}// end mMenuPrint()


	public void mMenuSelect()// �޴� ���� �޼ҵ�
	{
		do	// 1~4 �ܿ� �ٸ� ���� ������ �ݺ�
		{
			try
			{
				System.out.print(">> �޴� ����(1~4) : ");

				Password.sel = Integer.parseInt(br.readLine());
			}

			catch (NumberFormatException e)
			{
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}

			// �� IOException ����ó��
			catch (IOException e)
			{
			}
		}
		while (Password.sel<1 || Password.sel>4);
		
	}// end mMenuSelect()


	public void mMenuRun() throws IOException // �޴� ȣ�� �޼ҵ�
	{
		// Password �ν��Ͻ� ����
		Password pw = new Password();

		switch (Password.sel)	// �Է¹��� ���� ���� ����
		{
			case Menus.E_ONE : mNote(); break;		// ��û���� Ȯ������
			case Menus.E_TWO : mStorage(); break;	// ��� ������
			case Menus.E_THREE : mMoney(); break;	// �ݰ� ������
			case Menus.E_FOUR :						// pw��� ��������
			{
				pw.modePrint();
				pw.modeSelect();
				pw.modeRun();
			} break;
		}
	}// end mMenuRun()


	// �١١ٹ̿ϼ��١١� (���ѹݺ���)
	public void mNote() throws IOException // ��û���� Ȯ�� �޼ҵ�
	{
		System.out.println(ISetup.sbNote);

		System.out.print("���� �Ҹ����� ���ðڽ��ϱ�? (Y/N) : ");
		Password.con = br.readLine().toUpperCase();
 
		if (Password.con.equals("Y"))	// Y �Է��� ���
		{								// 
			ISetup.sbNote.delete(0,ISetup.sbNote.length());
			System.out.println("���� �Ҹ����� ��������ϴ�");
		}
		
		mMenuPrint();	// ������ �޴� �������
		mMenuSelect();
		mMenuRun();

	}// end mNote()


	public void mStorageSelect()
	{
		System.out.println();
		System.out.println("��������������������������������������������������������������������������������������");
		System.out.println("��                                         ��");
		System.out.println("��                                         ��");
		System.out.println("��       [�޴� ���] (�����޴� : -1)       ��");
		System.out.println("��                                         ��");
		System.out.println("��            1. ��� �߰�/����            ��");
		System.out.println("��            2. ǰ�� �߰�/����            ��");
		System.out.println("��            3. ��� �߰�                 ��");
		System.out.println("��                                         ��");
		System.out.println("��                                         ��");
		System.out.println("��������������������������������������������������������������������������������������");
		System.out.println();
	}// end mStorageSelect()


	public void mStorage() throws IOException // ��� ���� �޼ҵ�
	{
		// Storagechange �ν��Ͻ� ����
		MStorage stc = new MStorage();

		MStorageNew msn = new MStorageNew();

		mStorageSelect();	// ��¹� ȣ��

		do	// 1~3 �ܿ� �ٸ� ���� ������ �ݺ�
		{
			System.out.print(">> �޴� ����(1~3) : ");

			Password.sel = Integer.parseInt(br.readLine());
		}
		while (Password.sel!=-1 && (Password.sel<1 || Password.sel>3));


		switch (Password.sel)	// �Է¹��� ���� ���� ����
		{
			case Menus.E_MINUS :
			{
				mMenuPrint();
				mMenuSelect();
				mMenuRun();
			} break;
			case Menus.E_ONE :	// ��� �߰� / ������
			{
				mStock();

				stc.mStorageChange();
			} break;
			case Menus.E_TWO :	// ǰ�� �߰� / ������
			{
				mStock();

				msn.mAddRemove();
			} break;
			case Menus.E_THREE :// ǰ�� �߰� / ������
			{
				stc.mBowlChange();
			} break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�."); break;
		}

	}// end mStorage()

	public void mMoneySelect()
	{
		System.out.println();
		System.out.println("��������������������������������������������������������������������������������������");
		System.out.println("��                                         ��");
		System.out.println("��                                         ��");
		System.out.println("��              [�޴� ���]                ��");
		System.out.println("��                                         ��");
		System.out.println("��          1. ����                        ��");
		System.out.println("��          2. ���� Ȯ�� �� ����           ��");
		System.out.println("��                                         ��");
		System.out.println("��                                         ��");
		System.out.println("��������������������������������������������������������������������������������������");
		System.out.println();
	}// end mStorageSelect()

	public void mMoney() throws IOException // ��� ���� �޼ҵ�
	{
		MMoneyChange mmcg = new MMoneyChange();

		MMoneyCheck mmck = new MMoneyCheck();

		mMoneySelect();	// ��¹� ȣ��

		do	// 1~2 �ܿ� �ٸ� ���� ������ �ݺ�
		{
			System.out.print(">> �޴� ����(1~2) : ");

			Password.sel = Integer.parseInt(br.readLine());
		}
		while (Password.sel<1 || Password.sel>2);
		

		switch (Password.sel)	// �Է¹��� ���� ���� ����
		{
			case Menus.E_ONE :	// �����
			{
				mmcg.rightNowChange();
				mmcg.changeInput();
			} break;
			case Menus.E_TWO :	// ���� Ȯ�� �� ��������
			{
				mmck.mMoneyPrint();
				mmck.mMoneyCal();
			} break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�."); break;
		}

	}// end mStorage()


	public void mStock()	// ���� ��� ��� �޼ҵ�
	{
		System.out.println("\n          [��� ����]");
		System.out.println();
		System.out.println("     �߰��������� ��� ����");
		
		System.out.println("��������������������������������������������������������������");
		System.out.println("��		              ��");
		System.out.println("��          [��ä]             ��");
		System.out.println("��		              ��");
		for (int n=0; n<ISetup.v.size(); n++)
		{
			if (ISetup.v.get(n).cate == 1)
				System.out.printf("��%2d. %-10s	" + ":" + "%3d����\n", n+1, ISetup.v.get(n).name, ISetup.v.get(n).num);

				// �׽�Ʈ��(MMoneyCheck)
				//System.out.printf("��%2d. %-10s	" + ": " + "%3d�� / %d����\n", n+1, ISetup.v.get(n).name, 100, 20000);
		}
		System.out.println("��		              ��");
		System.out.println("��   -----------------------   ��");
		System.out.println("��		              ��");
		System.out.println("��          [����]             ��");
		System.out.println("��		              ��");
		for (int n=0; n<ISetup.v.size(); n++)
		{
			if (ISetup.v.get(n).cate == 2)
				System.out.printf("��%2d. %-10s	" + ":" + "%3d����\n", n+1, ISetup.v.get(n).name, ISetup.v.get(n).num);
		}
		System.out.println("��		              ��");
		System.out.println("��   -----------------------   ��");
		System.out.println("��		              ��");
		System.out.println("��          [�ҽ�]             ��");
		System.out.println("��		              ��");
		for (int n=0; n<ISetup.v.size(); n++)
		{
			if (ISetup.v.get(n).cate == 3)
				System.out.printf("��%2d. %-10s	" + ":" + "%3d����\n", n+1, ISetup.v.get(n).name, ISetup.v.get(n).num);
		}
		System.out.println("��		              ��");

		System.out.println("��   -----------------------   ��");
		System.out.println("��		              ��");
		System.out.println("��          [����]             ��");
		System.out.println("��		              ��");;
		for (int n=0; n<ISetup.v.size(); n++)
		{
			if (ISetup.v.get(n).cate == 4)
				System.out.printf("��%2d. %-10s	" + ":" + "%3d����\n", n+1, ISetup.v.get(n).name, ISetup.v.get(n).num);
		}
		System.out.println("��������������������������������������������������������������");
		
	}// end mStock()


}// end class