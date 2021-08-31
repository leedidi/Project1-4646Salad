
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MStorage
{
	int foodNum;		// ��� ��ȣ ����
	int su;				// ��� ����(����) ����
	static int bowl=10;	// ��� ����

	private static BufferedReader br;

	private static ManagerMode mm;

	static
	{
		// BufferedReader �ν��Ͻ� ����
		br = new BufferedReader(new InputStreamReader(System.in));

		// ManagerMode �ν��Ͻ� ����
		mm = new ManagerMode();
	}


	public void mStorageChange() throws IOException // ��� �߰�/���� �Է� �޼ҵ�
	{	
		while(true)
		{
			System.out.print("��Ḧ �߰��Ͻ÷��� (+), �����Ͻ÷��� (-) : "); // ��Ḧ �߰��Ϸ��� (+), �����Ϸ��� (-) �Է�
			
			Password.op = br.readLine();
			
			if(Password.op.equals("+") || Password.op.equals("-"))	// ���� : (+), (-) �ùٸ��� �Է� ��
				break;												// ������ �Է�ĭ ���

			System.out.println("\n�Է¿� ������ �ֽ��ϴ�.\n");		// ������ �ùٸ��� �ʰ� �Է� �� �޼��� ǥ�� �� �ٽ� �Է¹���	
		}

		mStorageFoodSelect();	// �̸� ���� �޼ҵ� ȣ��

	}// end mStorageChange()


	public void mStorageFoodSelect() throws IOException	// �̸� ���� �޼ҵ�
	{
		int vegNum=0;		// ��ä�� ���� �� ������ �˱����� ���� (ex : v.size()�� ��������)
		int mainNum=0;		// ������ ���� �� ������ �˱����� ����
		int sourceNum=0;	// �ҽ��� ���� �� ������ �˱����� ����
		int topNum=0;		// ������ ���� �� ������ �˱����� ����

		for (int i=0; i<ISetup.v.size(); i++)
		{
			if (ISetup.v.get(i).cate == 1)	// v���� ��ü�� ���鼭 ��ä ī�װ��� ���
				vegNum++;					// vegNum�� 1�� ����

			else if (ISetup.v.get(i).cate == 2)
				mainNum++;

			else if (ISetup.v.get(i).cate == 3)
				sourceNum++;

			else if (ISetup.v.get(i).cate == 4)
				topNum++;
		}

		while (true)
		{
			System.out.print("�� ��� ��ȣ : "); // ��� ��ȣ �Է�
			foodNum = Integer.parseInt(br.readLine())-1;

			if (foodNum>=0 && foodNum<ISetup.v.size())	// �Է°��� 1~v����ũ�� ������ ���̸� while�� ��������
			{
				break;
			}
			else
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");	// �ƴҰ�� �ٽ� �ݺ�

		}

		mStorageFoodNum();	// ������ ���� ���� �޼ҵ� ȣ��

	}// end mStorageFoodSelect()


	public void mStorageFoodNum() throws IOException // ������ ���� ���� �޼ҵ�
	{
		while (true)
		{
			System.out.printf("�� [%s] ���� : ", ISetup.v.get(foodNum).name); // ��� �߰�/������ ���� �Է�
			su = Integer.parseInt(br.readLine());

			// ��� �߰��� : �� ��� ����(���� ���+�߰� �Է� ���) 30�� ���Ϸ� �Է�
			// ��� ������ : �ش� ����� ���� ���� �̻� �Է��� �� ������ ��
			if (Password.op.equals("+"))
			{
				if(su + ISetup.v.get(foodNum).num<=30)	// [�� ���� �� ��� ���� 30�� ������ ��]
					break;								// ��� ���� �Է�ĭ ���

				System.out.println("\n�Է¿� ������ �ֽ��ϴ�.\n"); // �ùٸ��� �ʰ� �Է� �� �޼��� ǥ�� �� �ٽ� �Է¹���	
			}

			else
			{
				if(su<=ISetup.v.get(foodNum).num)		// [���� ���� ���Ϸ� �Է½�] 
					break;								// ��� ���� �Է�ĭ ���
				System.out.println("\n�Է¿� ������ �ֽ��ϴ�.\n"); // �ùٸ��� �ʰ� �Է� �� �޼��� ǥ�� �� �ٽ� �Է¹���
			}
		}

		if (Password.op.equals("+")) //���� ���䰡 ������ ������ ���� �޼ҵ� ȣ��
			mSAdd();
		else
			mSRemove();

	}// end mStorageFoodNum()


	public void mSAdd() throws IOException	// ��� �߰� ���� �޼ҵ�
	{
		System.out.print("\n��� �߰��Ͻðڽ��ϱ�? (Y/N) : ");
		Password.con = br.readLine().toUpperCase();

		if(Password.con.equals("Y")) // �����ڰ� Y �Է��� ��� ��� �߰�
		{
			ISetup.v.get(foodNum).num += su;
			System.out.println("\n<<��� �߰��ƽ��ϴ�.>>\n");
		}
		else
			System.out.println("��ҵƽ��ϴ�.");
		
		System.out.println("���� �޴��� ���ư��ϴ�.");
		mm.mStorage();
			
	} //end mSAdd()


	public void mSRemove() throws IOException	// ��� ���� ���� �޼ҵ�
	{                     
		System.out.print("\n��� �����Ͻðڽ��ϱ�? (Y/N) : "); 
		Password.con = br.readLine().toUpperCase();

		if(Password.con.equals("Y")) // �����ڰ� Y �Է��� ��� ��� ����
		{
			ISetup.v.get(foodNum).num -= su;
			System.out.println("\n<<��� �����Ǿ����ϴ�.>>\n");
		}
		else
			System.out.println("��ҵƽ��ϴ�.");

		System.out.println("���� �޴��� ���ư��ϴ�.");
		mm.mStorage();

	} // end mSAdd()


	public void mBowlChange() throws IOException	// ��� �߰� ���� �޼ҵ�
	{
		int bowlChangeNum;	// ��� ���� ����

		
		System.out.println();
		System.out.printf("���� ��� ���� : %d", bowl);
		System.out.println();
		System.out.print("��⸦ � �߰��Ͻðڽ��ϱ�? : ");
	
		bowlChangeNum = Integer.parseInt(br.readLine());

		if (bowl+bowlChangeNum>=0 && bowl+bowlChangeNum <= 30)	// ���� �������� �Է� ������ ���� 30 ���ϸ�
		{
			bowl = bowl+bowlChangeNum;	// ��� �߰� ����
			System.out.println("<<��Ⱑ �߰� �Ǿ����ϴ�.>>");
		}
		else
		{
			System.out.println("�Է¿� ������ �ֽ��ϴ�");	// �ƴҰ�� �������� �ʰ�
		}

		mStorageReturn();	// ��� �������� ����� �޼ҵ� ȣ��

	}// end mBowlChange()


	public void mStorageReturn() throws IOException	// ��� ���� ����� �޼ҵ� ����
	{
		// Password �ν��Ͻ� ����
		Password pw = new Password();

		System.out.print("������ �۾��� ��� �����Ͻðڽ��ϱ�? (Y/N) : ");

		Password.con = br.readLine().toUpperCase();

		// 'Y' �Է½� �߰� ����
		if(Password.con.equals("Y"))
		{
			mm.mStorage();
		}
		// �ٸ��� �Է½� ó�� ȭ������
		else
		{
			pw.modePrint();
			pw.modeSelect();
			pw.modeRun();
		}
	}// end mStorageReturn()

}// end class Storagechange