import java.util.Vector;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.ArrayList;

class UserMode extends TempStation
{
	private static Scanner sc;
	private static BufferedReader br;

	static int count;
	static int pay;
	public int sumpay;			// ���Աݾ��� �����ؼ� ���� ����
	public int summoney;		// ������ �ݾ��� ����� ����

	static Password pw;


	static	// �ʱ�ȭ
	{
		// Scanner �ν��Ͻ� ���� 
		sc = new Scanner(System.in);

		br = new BufferedReader(new InputStreamReader(System.in));

		pw = new Password();
	}

	// �ϼ�
	// �޴� ��� �޼ҵ�
	public void uMenuPrint()
	{
		if (MStorage.bowl==0)
		{
			System.out.println("��Ⱑ �����ؼ� �ǸŰ� �Ұ����մϴ�.");
			System.out.println();
			System.out.println("�����ڿ��� ��ȭ�ּ���...");
			System.out.println("������ : ��ȣ��");
			System.out.println("�� 010-4848-4114");
			System.out.println();
			System.out.println();
			System.out.println("<<������ ����˴ϴ�.�������>>");
			System.exit(-1);
		}

		System.out.println();
		System.out.println("��������������������������������������������������������������������������������������");
		System.out.println("��                                         ��");
		System.out.println("��                                         ��");
		System.out.println("��            1 . ��Ű¡ ������            ��");
		System.out.println("��            2 . Ŀ���� ������            ��");
		System.out.println("��            3 . ���� ������              ��");
		System.out.println("��            4 . ���� �Ҹ�              ��");
		System.out.println("��                                         ��");
		System.out.println("��                                         ��");
		System.out.println("��������������������������������������������������������������������������������������");
		System.out.print(" >> �޴� ����(1~4) : ");
	}

	// �ϼ�
	// �޴� ���� �޼ҵ�
	public void uMenuSelect() throws IOException
	{
		do
		{
			Password.sel = sc.nextInt();
		}
		while ( Password.sel!=4646 && (Password.sel<1 || Password.sel>4) );
		// 4646�ƴϸ鼭, 1���� �۰� 4���� ũ�� �Է� �ٽ�.
	}


	// �ϼ�
	// ���õ� �޴� ���࿡ ���� ��� ȣ�� �޼ҵ�
	public void uMenuRun() throws IOException
	{
		UPackageSalad ups = new UPackageSalad();

		UCustomSalad ucs = new UCustomSalad();

		URandomSalad urs = new URandomSalad();

		switch (Password.sel)
		{
			case Menus.E_ONE : 
				{
					ups.uPackageSalad();
					uDecision();
				} break;
			case Menus.E_TWO   :
				{
					ucs.uCustomMenuSelect();
					uDecision();
				} break;
			case Menus.E_THREE : 
				{
					urs.limitCal();
					urs.cancel();
					urs.randomRun();
					uDecision();
				} break;
			case Menus.E_FOUR : uNote(); break;
			case Menus.E_SECRETCODE : 
				{
					pw.inputPass();

					pw.modePrint();
					pw.modeSelect();
					pw.modeRun();
				}
				//�����ڷ� ���ư��¸޼ҵ�ȣ��;  break;		
		}
	}

	// ���ǼҸ� �޼ҵ�
	public void uNote() throws IOException
	{
		String note;

		System.out.println("������������������������������������������������������������������������");
		System.out.println("                                       ");
		System.out.println("                                       ");
		System.out.println("      ������� �Ҹ��ԡ���        ");
		System.out.println("    ���Ͻô� ��û ������ �����ּ���    ");
		System.out.println("                                       ");
		System.out.print("- ");
		note = br.readLine();
		System.out.println("                                       ");
		System.out.println("                                       ");
		System.out.println("������������������������������������������������������������������������");

		ISetup.sbNote.append(note);
		ISetup.sbNote.append("\n");
		System.out.println("���������� ������ �ǰ� �����մϴ� ^^��");

		uMenuPrint();
		uMenuSelect();
		uMenuRun();
	}

	// ���� ������ ����� �޼ҵ� -> ���굵 �̷��������
	public void uDecision() throws IOException
	{
		UCustomSalad ucs = new UCustomSalad();

		TempStation ts = new TempStation();

		// ������ ���� ����..���ͷ� �޾Ƽ� ȭ�鿡 ���
		for (int i=0; i<temp.size(); i++)
		{
			for (int j=0; j<ISetup.v.size(); j++)
			{
				if (temp.get(i).name.equals(ISetup.v.get(j).name))
				{
					if (ISetup.v.get(j).num < temp.get(i).num)
					{
						System.out.println("[%s] ������");
						System.out.println("��� ����â���� �ǵ��ư��ϴ�. �...");

						ucs.uCustomMenuSelect();
					}
				}
			}
		}

		System.out.println(" =============================================================================");

		System.out.print("  ���      :  ");
		for (int i=0; i<temp.size(); i++)
			System.out.printf("%s ", temp.get(i).name);
		System.out.println();


		int sumkcal=0;	// Į�θ� �������� ���� ����
		for (int i=0; i<temp.size(); i++)
			sumkcal += temp.get(i).kcal;
		System.out.printf("  Į�θ�    :  %dKcal\n", sumkcal);
		

		summoney=0;	// �ݾ� �������� ���� ����
		for (int i=0; i<temp.size(); i++)
			summoney += temp.get(i).money;
		System.out.printf("  �ݾ�      :  %d��\n", summoney);


		// System.out.printf("������� : %d�ϱ���...\n", ��);
		Calendar rightNow = Calendar.getInstance();		// Ķ���� Ŭ���� ����

		int y = rightNow.get(Calendar.YEAR);
		int m = rightNow.get(Calendar.MONTH) + 1;
		int d = rightNow.get(Calendar.DATE);
		System.out.printf("  ��������  :  %d-%d-%d�� \n", y, m, d);	


		int n = (temp.get(0).name == "����") ?  3 : 5;
		rightNow.add(Calendar.DATE, n);
		//	get(i)�� ���� �ε������� ���� ��������� ���÷κ��� �߰�
		//	���� true �� 3
		//	���� false �� 5


		y = rightNow.get(Calendar.YEAR);
		m = rightNow.get(Calendar.MONTH)+1;
		d = rightNow.get(Calendar.DATE);
		System.out.printf("  �������  :  %d-%d-%d�ϱ���...\n", y, m, d);
		System.out.println(" =============================================================================");




		// ���� (���±��� ���� ������ �Ҳ��� ������)
		System.out.print("���� �Ͻðڽ��ϱ�? (Y/N) : ");
		Password.con = sc.next().toUpperCase();	

		// yes��� �����޼ҵ��, no�� �ܰ� 1��- 
		if (Password.con.equals("Y"))
		{
			uPayRun(temp);
			uPayment();
		}
			// ���׽�Ʈ�Ϸ���,
		else if(!Password.con.equals("Y"))
		{
			System.out.println("ó������ ���ư��ϴ�. ");
			
			ts.temp.clear();

			uMenuPrint();
			uMenuSelect();
			uMenuRun();
		}
	 }// end uDecision

	// ���� Ȯ�� �޼ҵ�
	// uPayment()������ temp ������ ������, uPayRun�� �Ѱ���� ��.
	// �Ű������� �ȹް� uDecision�� �ִ� temp�� ������ ����..?

	public void uPayment() throws IOException
	{
		TempStation ts = new TempStation();

		System.out.print("<<���� ����� �����ϼ��� (ī��/����)>>");
		Password.con = sc.next();
			if (Password.con.equals("����"))
			{
				do
				{
					System.out.print("�� ������ �ݾ��� �Է��ϼ��� : ");
					pay = sc.nextInt();
					
				}
				while (pay<summoney);
				
				if (pay == summoney)
				{
					System.out.print("�������� �Ϸ� �Ǿ����ϴ�.��");
					ISetup.payNum.put(count, pay);

					ts.temp.clear();

					uMenuPrint();
					uMenuSelect();
					uMenuRun();
				}
				else
				{
					// �Ž����� ����
					// �Ž����� ����
					Change.changeCal(pay, summoney);
					//			������ �ݾ�, �޴� ����

				}// end if 
			}
			else if (Password.con.equals("ī��"))
			{
				System.out.print("�������� �Ϸ� �Ǿ����ϴ�.��");

				ts.temp.clear();

				uMenuPrint();
				uMenuSelect();
				uMenuRun();

			}
	}//end uPayment


	public void uPayRun(Vector<Ingredient> temp) // ������ �Ϸ�� �� ��. �����͸� ����?����?�ϴ� ���.
	{
		// 1. �Ǹŵ� ������ (= ���� Ƚ��) ���� ī��Ʈ
		count ++;
		
		// 2. ��� ������ - : // �ǽð� ���������� 1.�� �и�.
		MStorage.bowl--;

		// temp�� ��� �̸��� �̾Ƽ� ������Ų��.
		ArrayList<String> tempArray= new ArrayList<String>();

		for (int i =0;i<temp.size();i++ )
		{
			tempArray.add(temp.get(i).name);	// �ֹ߼�
			ISetup.payArray.add(temp.get(i).name);	// ������
		}
		
		// �ǽð����� ��� �����ϴ� ����.
		// temp�̸��� ����� �̸��� ���ٸ� ����� ���� ����.
		for (int i =0;i<temp.size();i++ )
		{
			for (int j=0;j<ISetup.v.size();j++)
			{
				if (ISetup.v.get(j).name.equals(temp.get(i).name))
					ISetup.v.get(j).num--;
			}
		}

		temp.clear();

		// ���Թ��� �ݾ��� ���� �ٿ��� Hashtable�� ���


	}//end uPayRun()

}