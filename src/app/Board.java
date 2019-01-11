package app;

public class Board {
	private char[][] board;
	
	public Board() {
		board = new char[7][7];
		reset();
	}
	
	public boolean tieGame() {
		return !isWinner('x') && !isWinner('o') && !anotherPlayPossible();
	}
	
	public void reset() {
		// traverse the whole thing and give initial values 
		for(char[] row : board) {
			// regular for loop because foreach is read-only
			for(int c = 0; c < row.length; c++) {
				row[c] = '-';
			}
		}
		
	}
	
	public boolean dropPiece(char player, int column) {
		// check that column param makes sense
		if(column >= board.length || column < 0) return false;
		for(int x = board.length - 1; x >= 0; x--) { // loop backwards, drop to bottom
			if(board[x][column] == '-') {
				board[x][column] = player;
				return true;
			}
		}
		return false;
	}

	public boolean anotherPlayPossible() {
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board.length; col++) {
				if(board[row][col] == '-') {
					return true;
				}
			}
		}
		return false;
	}
 
	public boolean isWinner(char player) {
		if (verticalWin(player)||horizontalWin(player)||diagonalPosWin(player)||diagonalNegWin(player)) return true;
		// no winner:
		else return false;
	}

	public boolean verticalWin (char player) {
		for (int col = 0; col < board.length; col++) {
			int count = 0;
			for(int row = 0; row < board.length; row++) {
				if(board[row][col] == player) {
					count++;
				}
				else count = 0;
				
				if(count == 4) return true;
			}
		}
		return false;
	}

	public boolean horizontalWin(char player) {
		for(int col = 0; col < board.length; col++) {
			int count = 0;
			for(int row = 0; row < board.length; row++) {
				if(board[row][col] == player) {
					count++;
				}
				else count = 0;
				
				if(count == 4) return true;
			}
		}
		return false;
	}
		
	public boolean diagonalPosWin(char player) {
		for(int row = 3; row < board.length; row++) {
			int count = 0;
			for(int col = 0; col <= row; col++) {
				if(board[row-col][col] == player) count++;
				else count = 0;
				
				if (count == 4) return true;
			}
		}
		// Check rest of the board
		for(int col = 1; col <= 3; col++) {
			int count = 0;
			int col_copy = col;
			for(int row = 6; row >= col; row--) {
				if(board[row][col_copy] == player) count++;
				else count = 0;
				
				col_copy++;
				if (count == 4) return true;
			}
		}
		return false;
	}
	
	private boolean diagonalNegWin(char player) {
		for(int row = 0; row < board.length; row++) {
			int count = 0;
			int row_copy = row;
			for(int col = 0; row_copy < board.length; col++) {
				if(board[row_copy][col] == player) count++;
				
				else count = 0;
				
				row_copy++;
				if(count == 4) return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String result = "";
		// print board
		for(char[] row : board) {
			for(char col : row) {
				result += col + " ";
			}
			// line break after each row:
			result += "\n";
		}
		return result;
	}
	
}
