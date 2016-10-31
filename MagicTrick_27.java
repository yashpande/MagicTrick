package classWork;
/**
 * @authors Yash Pande
 * @date October 1st 2013
 * @purpose Magic Trick - Ask the user to select a card, and give them a selection of cards. Then ask them to pick the column that their card is in. 
 * after doing this three times, the program will be able to tell the user their card.
 */
import java.util.Random;
import java.util.Scanner;
public class MagicTrick_27 {
	/*Create a new array, cards. Fill this array with 27 cards, then arrange these cards. Print the card, and ask for the user input. Send the cards
	for sorting. Continue doing this three times.*/
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int choice;
		do{
		System.out.println("  #####  #######        #####                          ######                                \n #     # #    #        #     #   ##   #####  #####     #     # #  ####  #    # #    # #####  \n       #     #         #        #  #  #    # #    #    #     # # #    # #   #  #    # #    # \n  #####     #    ##### #       #    # #    # #    #    ######  # #      ####   #    # #    # \n #         #           #       ###### #####  #    #    #       # #      #  #   #    # #####  \n #         #           #     # #    # #   #  #    #    #       # #    # #   #  #    # #      \n #######   #            #####  #    # #    # #####     #       #  ####  #    #  ####  #      \n\n27 Card Pickup.\nPress 1 to play game.\nPress 2 For instructions\nPress 3 to quit\n");
		choice = in.nextInt();
		switch(choice)
		{
		case 1:
			game();
			break;
		case 2:
			System.out.println(" ### #    #  ####  ##### #####  #    #  ####  ##### #  ####  #    #  ####  \n  #  ##   # #        #   #    # #    # #    #   #   # #    # ##   # #      \n  #  # #  #  ####    #   #    # #    # #        #   # #    # # #  #  ####  \n  #  #  # #      #   #   #####  #    # #        #   # #    # #  # #      # \n  #  #   ## #    #   #   #   #  #    # #    #   #   # #    # #   ## #    # \n ### #    #  ####    #   #    #  ####   ####    #   #  ####  #    #  ####  \nI will show you a magic trick. First, I will show you 27 cards - you have to pick one of them and tell me what column it is in.\nThen, I will reshuffle these cards and show them to you. Again, you have to tell me the column of the card.\nFinally, I will reshuffle the cards for the last time and ask you the column of your card. \nOnce you tell me the column, I will tell you what your card was.\nREMEMBER - if you enter a column wrong, I will tell you the wrong card. Make sure you enter the column right!\nPress a key if you got all this.\n");
			in.next();
			break;
		case 3:
			break;
		default:
			System.out.println("  #####  #######        #####                          ######                                \n #     # #    #        #     #   ##   #####  #####     #     # #  ####  #    # #    # #####  \n       #     #         #        #  #  #    # #    #    #     # # #    # #   #  #    # #    # \n  #####     #    ##### #       #    # #    # #    #    ######  # #      ####   #    # #    # \n #         #           #       ###### #####  #    #    #       # #      #  #   #    # #####  \n #         #           #     # #    # #   #  #    #    #       # #    # #   #  #    # #      \n #######   #            #####  #    # #    # #####     #       #  ####  #    #  ####  #      \n\n27 Card Pickup.\nYour choice was invalid.\nPlease press either 1, 2 or 3.\nEnter any key to continue.\n");
			in.next();
			break;
		}
		}while(choice!=3);
		System.out.println("\n\n\n .----------------.  .----------------.  .----------------. \n| .--------------. || .--------------. || .--------------. |\n| |   ______     | || |  ____  ____  | || |  _________   | |\n| |  |_   _ \\    | || | |_  _||_  _| | || | |_   ___  |  | |\n| |    | |_) |   | || |   \\ \\  / /   | || |   | |_  \\_|  | |\n| |    |  __'.   | || |    \\ \\/ /    | || |   |  _|  _   | |\n| |   _| |__) |  | || |    _|  |_    | || |  _| |___/ |  | |\n| |  |_______/   | || |   |______|   | || | |_________|  | |\n| |              | || |              | || |              | |\n| |              | || |              | || |              | |\n| '--------------' || '--------------' || '--------------' |\n '----------------'  '----------------'  '----------------' ");
	}
	public static void game()
	{
		String [] cards = new String [27];
		String currentcard;
		boolean containscard;
		for (int i=0; i<27; i++)
			cards[i] = " ";
		for (int i=0; i<27; i++)
		{
			containscard  = false;
			currentcard = cardgenerator();
			for (int j=0; j<27; j++)
				if (cards[j].equals(currentcard))
					containscard=true;
			if(containscard==false)
				cards[i] = currentcard;
			else
				i--;
		}
		Scanner in = new Scanner(System.in);
		printcards(cards);
		System.out.println("\nPick a card and tell me what column it is in.\n");
		int cardplace = in.nextInt();
		cards = arrangecards(cards,cardplace);
		for (int i = 0; i<2; i++){
			printcards(cards);
			System.out.println("\nFind the card you picked and tell me what column it is in now.\n");
			cardplace = in.nextInt();
			cards = arrangecards(cards,cardplace);
		}
		String card = cards[13].replaceAll(" ","");
		card = card.replaceAll("of"," of ");
		System.out.println("Your card is the " + card + ". Enter a letter to continue.");
		in.next();
	}

	public static String[] arrangecards(String[] array, int cardplace)
	{
		String [] temparray = new String [27];
		switch(cardplace)
		{
		case 1:
			for (int i = 0; i<9; i++)
			{
				temparray[i] = array[3*i];
				array[3*i] = array[3*i+1];
				array[3*i+1] = temparray[i];
			}
			break;
		case 3:
			for (int i = 0; i<9; i++)
			{
				temparray[i] = array[3*i+2];
				array[3*i+2] = array[3*i+1];
				array[3*i+1] = temparray[i];		
			}
			break;
		}
		for (int i=0; i<3;i++)
			for (int j=0; j<9; j++)
			{
				temparray[9*i+j] = array[i+3*j];
			}
		array = temparray;
		return array;
	}
	public static void printcards(String[] array)
	{
		System.out.println ("|    Column 1     |    Column 2     |    Column 3     |");
		for (int row=0; row<9; row++)
		{
			System.out.print("|");
			for (int column = 0; column<3; column++){
				int place = 3*row + column;
				System.out.print(array[place]);
				System.out.print("|");
			}
			System.out.println();
		}
	}
	public static String cardgenerator()
	{
		Random rand = new Random();
		int card = rand.nextInt(4);
		String suit = null;
		switch(card)
		{
			case 0:
				suit = "Spades  ";
				break;
			case 1:
				suit = "Hearts  ";
				break;
			case 2:
				suit = "Clubs   ";
				break;
			case 3:
				suit = "Diamonds";
				break;
		}
		int number = rand.nextInt(13) + 1;
		String value = null;
		switch(number)
		{
			case 1:
				value = "Ace  ";
				break;
			case 2:
				value = "Two  ";
				break;
			case 3:
				value = "Three";
				break;
			case 4:
				value = "Four ";
				break;
			case 5:
				value = "Five ";
				break;
			case 6:
				value = "Six  ";
				break;
			case 7:
				value = "Seven";
				break;
			case 8:
				value = "Eight";
				break;
			case 9:
				value = "Nine ";
				break;
			case 10:
				value = "Ten  ";
				break;
			case 11:
				value = "Jack ";
				break;
			case 12:
				value = "Queen";
				break;
			case 13:
				value = "King ";
				break;
		}
		return (value + " of " + suit);
	}
}
