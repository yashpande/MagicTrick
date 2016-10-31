package classWork;
/**
 * @authors Yash Pande
 * @date October 1st 2013
 * @purpose Magic Trick - Ask the user to select a card, and give them a selection of cards. Then ask them to pick the column that their card is in. 
 * after doing this three times, the program will be able to tell the user their card.
 */
import java.util.Random;
import java.util.Scanner;
public class MagicTrick {
	/*Create a new array, cards. Fill this array with 21 cards, then arrange these cards. Print the card, and ask for the user input. Send the cards
	for sorting. Continue doing this three times.*/
	public static void main(String[] args)
	{
		String [] array = new String [21];
		String currentcard;
		boolean containscard;
		for (int i=0; i<21; i++)
			array[i] = " ";
		for (int i=0; i<21; i++)
		{
			containscard  = false;
			currentcard = cardgenerator();
			for (int j=0; j<21; j++)
				if (array[j].equals(currentcard))
					containscard=true;
			if(containscard==false)
				array[i] = currentcard;
			else
				i--;
		}
		Scanner in = new Scanner(System.in);
		printcards(array);
		System.out.println("Pick a card and tell me what column it is in.");
		int cardplace = in.nextInt();
		array = arrangecards(array,cardplace);
		for (int i = 0; i<2; i++){
			printcards(array);
			System.out.println("Find the card you picked and tell me what column it is in now.");
			cardplace = in.nextInt();
			array = arrangecards(array,cardplace);
		}
		String card = array[10].replaceAll(" ","");
		card = card.replaceAll("of"," of ");
		System.out.println("Your card is the " + card);
	}

	public static String[] arrangecards(String[] array, int cardplace)
	{
		String [] temparray = new String [21];
		switch(cardplace)
		{
		case 1:
			for (int i = 0; i<7; i++)
			{
				temparray[i] = array[3*i];
				array[3*i] = array[3*i+1];
				array[3*i+1] = temparray[i];
			}
			break;
		case 3:
			for (int i = 0; i<7; i++)
			{
				temparray[i] = array[3*i+2];
				array[3*i+2] = array[3*i+1];
				array[3*i+1] = temparray[i];		
			}
			break;
		}
		for (int i=0; i<3;i++)
			for (int j=0; j<7; j++)
			{
				temparray[7*i+j] = array[i+3*j];
			}
		array = temparray;
		return array;
	}
	public static void printcards(String[] array)
	{
		System.out.println ("|    Column 1     |    Column 2     |    Column 3     |");
		for (int row=0; row<7; row++)
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
