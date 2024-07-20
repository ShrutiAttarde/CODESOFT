import java.util.Scanner;

public class ATMinterface
{
    public static void main(String args[] )
    {
        int balance = 5000, withdraw, deposit;
        Scanner sc = new Scanner(System.in);

        while(true)
        {
			System.out.println("---------------------------------------------------");
            System.out.println("\tWelcome To Automated Teller Machine");
            System.out.println("---------------------------------------------------");
            System.out.println("\nATM Menu:");
            System.out.println("Choose 1 for Check Balance");
            System.out.println("Choose 2 for Deposit");
            System.out.println("Choose 3 for Withdraw");
            System.out.println("Choose 4 for EXIT");
            System.out.print("Choose the operation you want to perform:");
            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                		System.out.println("\nBalance : "+balance);
	                    System.out.println("");
						break;

                case 2:
						System.out.println("\nCurrently available Balance in you account: "+balance);
						System.out.print("\nEnter money to be deposited:");
						deposit = sc.nextInt();

						balance = balance + deposit;
						System.out.println("Your Money has been successfully deposited.");
						System.out.println("");
						break;

                case 3:
						System.out.println("\nCurrently available Balance in you account: "+balance);
						        				System.out.print("\nEnter money to be withdrawn:");
						        				withdraw = sc.nextInt();

												if(balance >= withdraw)
												{
													balance = balance - withdraw;
													System.out.println("Please collect your money");
												}
												else
												{
													System.out.println("\nInsufficient Balance");
												}
												System.out.println("");
						                        break;

                case 4:
       					System.exit(0);

       			default:
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

