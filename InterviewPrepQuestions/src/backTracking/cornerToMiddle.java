package backTracking;

public class cornerToMiddle {

	public static void main(String[] args) {
		int[][] maze = 
		    { 
		        { 3, 5, 4, 4, 7, 3, 4, 6, 3 }, 
		        { 6, 7, 5, 6, 6, 2, 6, 6, 2 }, 
		        { 3, 3, 4, 3, 2, 5, 4, 7, 2 }, 
		        { 6, 5, 5, 1, 2, 3, 6, 5, 6 }, 
		        { 3, 3, 4, 3, 0, 1, 4, 3, 4 }, 
		        { 3, 5, 4, 3, 2, 2, 3, 3, 5 }, 
		        { 3, 5, 4, 3, 2, 6, 4, 4, 3 }, 
		        { 3, 5, 1, 3, 7, 5, 3, 6, 4 }, 
		        { 6, 2, 4, 3, 4, 5, 4, 5, 1 } 
		    }; 
		  
		cornerToMid(maze,0,0,"",new boolean[9][9]); 
		cornerToMid(maze,0,maze.length-1,"",new boolean[9][9]); 
		cornerToMid(maze,maze.length-1,0,"",new boolean[9][9]); 
		cornerToMid(maze,maze.length-1,maze.length-1,"",new boolean[9][9]); 
	}

	public static void cornerToMid(int[][] arr, int row, int col, String asf, boolean[][] visited) {
		
		if (row < 0 || col < 0 || row >= arr.length || col >= arr.length) {
			return;
		}
		if (row == arr.length / 2 && col == arr.length / 2) {
			System.out.println(asf);
			return;
		}
		if (visited[row][col] == true) {
			return;
		}
		visited[row][col] = true;
			cornerToMid(arr, row + arr[row][col], col, asf + " -> (" + row + ", " + col + ")", visited);
			cornerToMid(arr, row - arr[row][col], col, asf + " -> (" + row + ", " + col + ")", visited);
			cornerToMid(arr, row, col + arr[row][col], asf + " -> (" + row + ", " + col + ")", visited);
			cornerToMid(arr, row, col - arr[row][col], asf + " -> (" + row + ", " + col + ")", visited);
		visited[row][col] = false;
	}

}
