import java.util.Scanner;

public class VM {
	
	static Scanner scan = new Scanner (System.in);
	final static int COKE = 10;
	final static int COFFEE = 7;
	final static int WATER = 3;
	final static String D1 = "COKE";
	final static String D2 = "COFFEE";
	final static String D3 = "WATER";
	static int money; // amount
	static int t_money=0; // temporary storage
	
  public static void main(String args[]){
	  char exit; // variable for confirmation

  System.out.println("Vending Machine");
  System.out.println("------------------------------------------");
  System.out.println("1. Coke ($10), 2. Coffee ($7) 3. Water ($3)");
  System.out.println("------------------------------------------");
  System.out.println();
  
  money = 0; // initial value for confirmation
  while (true) { 
	  if(money==0) {
	  money = InputCoin();
	  }
	  SelectDrink(money);
	  System.out.print("Do you want to choose more  (y/n)?");
	  exit = scan.next().charAt(0);
	  
	  money = t_money;
	  
	  if (exit == 'n' || exit == 'N') { // exit confirmation
		  System.out.println("Good bye");
		  break;
	  }
	  System.out.println();
	  }
  }
  static void ChangePay(int money, int s, String drink) { // change
	  int temp;
	  int m_20, m_10, m_5;
	  char sel;
	  
	  if (money < s) { // the amount is too small
		  System.out.println("Error select money < drink");
		  System.out.print("\n" + "Would you like to add more money (y/n)? "); 
		  sel = scan.next().charAt(0);
		  if(sel == 'y') // additional money
			  InputCoin();
		  else if(sel == 'n') { //end of program
			  System.out.println("Exit"); 
			  System.exit(0);
		  }
		  else
		  SelectDrink(money);
	  }
	  else { //calculate your change
	  money -= s;
	  m_20 = money / 20;
	  temp = money % 20;
	  m_10 = temp / 10; 
	  temp = temp % 10; 
	  m_5 = temp / 5; 
	  temp = temp % 5;
	  
	  System.out.println();
	  System.out.println("------------------------------------------");
	  System.out.println("The drink you choose " + drink + " and your change is $ " + money + ".");
	  System.out.print("$ 20 : " + m_20 + ", "); 
	  System.out.print("$ 10 : " + m_10 + ", "); 
	  System.out.print("$ 5 : " + m_5 + ", "); 
	  System.out.println("$ 1 : " + temp);
	  System.out.println("------------------------------------------");
	  System.out.println();
	  
	  t_money = money;
	  }
  }

static void SelectDrink(int money) {
	int sel;
	
	System.out.print("Please choose your drink: ");
	sel = (int) (scan.next().charAt(0)) - 48;
	
	if (sel < 1 || sel > 4) { // choose wrong drink
		System.out.println("You have chosen wrong number, choose again 1~3");
		SelectDrink(money);
	}
	else {
		switch (sel) {
		
		case 1:
			ChangePay(money, COKE, D1); 
			break;
		case 2:
			ChangePay(money, COFFEE, D2); 
			break;
		case 3:
			ChangePay(money, WATER, D3); 
			break;
		default:
			System.out.println("Switch Error");
			break;
		}
	  }
	}
		static int InputCoin() {
		System.out.print("\n" + "Please enter your amount: ");
		money = scan.nextInt();
		money += t_money;
		t_money = money; // at the same price 
		return money;
		}
	}