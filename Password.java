
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Password
{
	private static BufferedReader br;
	public static Integer sel;
	public static String op;
	public static String con;


	static // static �ʱ�ȭ ��
	{
		// BufferedReader �ν��Ͻ� ����
		br = new BufferedReader(new InputStreamReader(System.in));

		// ����� �Է°� �ʱ�ȭ
		sel = 1;
		op = "+";
		con = "Y";
	}


	public void inputPass() throws IOException // �н����� �Է� �޼ҵ�
	{
		// �н�����, �Է�Ƚ�� ����
		int pass;
		int count=1;

		do	// �н����� �Է½� �ݺ��� ����������
		{	// 5ȸ �̻� �Է� ���н� ���α׷� ����
			System.out.println("=============================================================");
			System.out.println();
			System.out.print("�н����带 �Է��ϼ��� (Hint_ �츮�� ó�� ���� �� ��) : ");
			pass = Integer.parseInt(br.readLine());
			count++;
			if (count>5)
			{
				System.out.println("�Է�Ƚ���� �ʰ��Ͽ����ϴ�.");
				exit();
			}
		}
		while (pass != 210714);
	}


	public void modePrint() // �޴� ��� �޼ҵ�
	{
		System.out.println();
		System.out.println("��������������������������������������������������������������������������������������");
		System.out.println("��                                         ��");
		System.out.println("��                                         ��");
		System.out.println("��             [�޴� ���]                 ��");
		System.out.println("��                                         ��");
		System.out.println("��            1. ������ ���               ��");
		System.out.println("��            2. �Ǹ� ���                 ��");
		System.out.println("��            3. ����                      ��");
		System.out.println("��                                         ��");
		System.out.println("��                                         ��");
		System.out.println("��������������������������������������������������������������������������������������");
		System.out.println();
	}


	public void modeSelect() throws IOException // �޴� ���� �޼ҵ�
	{
		do	// 1~3 �ܿ� �ٸ� ���� ������ �ݺ�
		{
			System.out.print(">> �޴� ����(1~3) : ");
			sel = Integer.parseInt(br.readLine());
		}
		while (sel<1 || sel>3);
	}


	public void modeRun() throws IOException // �޴� ȣ�� �޼ҵ�
	{
		// ManagerMode �ν��Ͻ� ����
		ManagerMode mm = new ManagerMode();
		
		UserMode um = new UserMode();

		switch (sel)	// �Է¹��� ���� ���� ����
		{
			case Menus.E_ONE :						// ������ ����
				{
					mm.mMenuPrint();
					mm.mMenuSelect();
					mm.mMenuRun();
				} break;
			case Menus.E_TWO :						// �Ǹ� ����
				{
					um.uMenuPrint();
					um.uMenuSelect();
					um.uMenuRun();
				} break;
			case Menus.E_THREE : exit(); break;		// ���α׷� ����
			default : System.out.println(">> �޴� ���� ����~!!!"); break;
		}

	}

	public void exit() // �ý��� ���� �޼ҵ�
	{
		System.out.println();
		System.out.println("<<������ ����˴ϴ�.�������>>");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.exit(-1);
	}

}