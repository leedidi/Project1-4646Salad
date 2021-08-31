import java.util.Scanner;
import java.io.IOException;

//�Ž����� ���� �� ��� Ŭ����
public class Change
{
	static int[] giveMoney = new int[5];	// �մԿ��� �帱 ȭ������������(����, ��õ��, õ��, �����, ���)
	static final int[] bills = {10000, 5000, 1000, 500, 100};	// ȭ�� ������
	static int [] moneyCount = {5, 2, 10, 4, 10};	// �ݰ� �� �ʱⰪ


	// �Ž����� ���	  
	public static void changeCal(int pay, int price) throws IOException // ���� ��(����� �Է��� ��), �޴�����
	{
		int won = 10000;
		int sw = 1;				// ���� ���� ����
		int change;				// �Ž�����
		int totalChange = 0;	// ������ �� �ݾ�
		int lack = 0;			// (������ ������)ȭ�� ���ڸ��� �Ÿ��� ����

		Scanner sc = new Scanner(System.in);

		UserMode um = new UserMode();

		UCustomSalad ucs = new UCustomSalad();

		TempStation ts = new TempStation();

		// ������ �� �ݾ� ���
		for (int a=0; a<5; a++)
			totalChange += bills[a] * moneyCount[a];

		change = pay - price;

		int x = 0;				// moneyCount[x] ����
		int count = 1;			// 
		int temple = change;

		// �� �ݾ� < �Ž�����
		if (totalChange < change)
		{
			System.out.println("�Ž������� �����մϴ�.");
			System.out.println("��� �߰�/���� ���ּ���.");
			
			System.out.println();
			System.out.println("�ʿ� �� �����ڿ��� ��ȭ�ּ���...");
			System.out.println("������ : ��ȣ��");
			System.out.println("�� 010-4848-4114");

			ucs.uCustomMenuSelect();
		}
		// �� �ݾ� > �Ž�����
		else
		{
			// �Ž����� ������ ���� ���
			while (true)
			{
				if (moneyCount[x] == 0 || change - won < 0)
				{
					count = 1;
					x++;
					if (sw == 1)
					{
						won = won/2;
						sw = 0;
					}
					else
					{
						won = won/5;
						sw = 1;
					}	
				}
				else
				{
					change = change - won;
					giveMoney[x] = count++;
					moneyCount[x] -= 1;
				}
				
				if (x == 5)
				{
					for (int b=0; b<giveMoney.length; b++)
						lack += bills[b] * giveMoney[b];

					break;
				}
			}	// end while~!!!
		}	// end else
		

		// �� �ݾ� > �Ž�����(�׷��� ���� ����)
		if (temple != lack)
		{
			System.out.println("�Ž������� �����մϴ�.");
			System.out.println();
			System.out.println("�ʿ� �� �����ڿ��� ��ȭ�ּ���...");
			System.out.println("������ : ��ȣ��");
			System.out.println("�� 010-4848-4114");
			System.out.println();
			System.out.println();
			return;
		}

		ISetup.payNum.put(UserMode.count, UserMode.pay);
		ts.temp.clear();

		System.out.println("�Ա����� �Ž������� ����������.");
		System.out.println("===============================");
		System.out.println();
		for (int i =0; i<5; i++)
			System.out.printf("%5d�� : %2d��\n", bills[i],giveMoney[i]);
		System.out.println();

		System.out.println("�Ž����� : " + temple);
		System.out.println();
		System.out.println("===============================");
		System.out.print("�������� �Ϸ� �Ǿ����ϴ�.��");

		um.uMenuPrint();
		um.uMenuSelect();
		um.uMenuRun();
		
		//um.uPayRun(temp);
		
		// �� ���� ���� �ʼ� ~!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//UserMode um = new UserMode();
		//um.uPayRun(����<Ingredient> Ÿ��);

	}
	
}