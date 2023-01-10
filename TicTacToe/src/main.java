import java.util.Scanner;

public class main
{

	public static void main(String[] args) 
	{
		
		Scanner scan = new Scanner(System.in);
		
		//get player's names
			System.out.println("PLayer 1, what's your name? ");
			String p1 = scan.nextLine();
			System.out.println("Player 2, what's your name? ");
			String p2 =scan.nextLine();
			
	   /*   3x3 Tic Tac Toe board
			for an empty space
		 	x --> player 1
			o -->player 2 
		*/
		char[][] board = new char[3][3];
			
		//filling the board with the dashes
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					board[i][j]='-';
				}
			}
				
		//Keep track of whose turn it is 
			boolean isPlayer1 = true;
			
		//condition for the loop
			boolean gameEnded = false;
			
			while(!gameEnded)
			{
				
				//Draw the board
					drawBoard(board);
				
			
				//keep track of what symbol we have used
					char symbol = ' ';
					if(isPlayer1)
					{
						symbol = 'x';
					}
					else {
						symbol = 'o';
					}
					
					//Print out the pplayer's turn
					if(isPlayer1)
					{
						System.out.println(p1 + "'s turn(x)");
					}
					else
					{
						System.out.println(p1 + "'s turn(o)");
					}
					
					
					int row =0;
					int col = 0;
					
				    while(true) 
					 {
					      //Get row and col from user
						System.out.println("Enter a row (0, 1, or 2)");
						 row = scan.nextInt();
						System.out.println("Enter a col (0, 1, or 2)");
						 col = scan.nextInt();
					
				      //we need to check if row and col are valid
						if(row < 0 || col < 0 || row > 2 || col > 2)
						{
							System.out.println("row and col are out of bounds");
						}
						else if(board[row][col]!= '-')
						{
							System.out.println("Someone has already made a move there ");
						}
						else
						{
							//row and col are valid
							break;
						}
					 }
				  
				  //setting the position on the board to the player's symbol
				  board[row][col]=symbol;
				  
				  //checking if the player has won
				  if(hasWon(board)=='x')
				  {
					  //player 1 has won
					  System.out.println(p1 + " has won ");
					  gameEnded = true;
					  
				  }else if(hasWon(board)=='o'){
					  //player 2 has won
					  System.out.println(p2 + " has won");
					  gameEnded = true;
				  }else{
					  
					  if(hasTied(board))
					  {
						  System.out.println("It's a tie!");
						  gameEnded = true;
					  }
					  else
					  {
						  isPlayer1 = !isPlayer1;
					  }
				  }
			} 
			drawBoard(board);
	}
	
      //drawBoard()--->for printing the board
	public static void drawBoard(char[][] board)
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public static char hasWon(char[][] board)
	{
		//checking the row
		for(int i=0;i<3;i++)
		{
			if(board[i][0] == board[i][1] && board[i][1]==board[i][2] && board[i][0] != '-')
			{
				return board[i][0];
			}
		}
		
		//same for col
		for(int j=0;j<3;j++)
		{
			if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j]!= '-')
			{
				return board[0][j];
			}
		}
		
		//Diagonals
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0]!= '-')
		{
			return board[0][0];
		}
		
		if(board[2][0] == board[1][1] && board[1][1]==board[0][2] && board[2][0]!='-')
		{
			return board[2][0];
		}
		
		return '-';
	}
	
	
	//checking for eny tie
	public static boolean hasTied(char[][] board)
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j] == '-')
				{
					return false;
				}
			}
		}
		return true;
	}
}
