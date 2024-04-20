package suduko;

import java.util.Scanner;

public class Suduko {
	public static int gridsize=3;
	private static int size=9;
	
	private static boolean checkRow(int[][] mat,int row,int num) {
		for(int i=0;i<mat.length;i++) {
			if(mat[row][i]==num)return true;
		}
		return false;
	}
	private static boolean checkCol(int[][] mat,int col,int num) {
		for(int i=0;i<mat.length;i++) {
			if(mat[i][col]==num)return true;
		}
		return false;
	}
	private static boolean checkGrid(int[][] mat,int col,int row,int num) {
		
		int startCol=col-col%gridsize;
		int startRow=row-row%gridsize;
		for(int i=startRow;i<startRow+gridsize;i++) {
			for(int j=startCol;j<startCol+gridsize;j++) {
				if(mat[i][j]==num)return true;
			}
		}
		return false;
	}
	private static boolean validPlace(int[][] mat,int col,int row,int num) {
		if(!checkGrid(mat,col,row,num)&&!checkCol(mat,col,num)&&!checkRow(mat,row,num)) {
			return true;
		}
		return false;
	}
	private static void printSuduko(int [][]mat) {
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat.length;j++) {
				System.out.print(mat[i][j]+"|");
			}
			System.out.println();
			//if(size%gridsize==i)System.out.println("---------");
		}
	}
	private static boolean  solve(int[][]mat) {
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat.length;j++) {
			if(mat[i][j]==0) {
				for(int k=1;k<=size;k++) {
					if(validPlace(mat,j,i,k)) {
						mat[i][j]=k;
						if(solve(mat)) {
							return true;
						}
						else mat[i][j]=0;
					}
				}
				return false;
			}
			}
		}
		return true;
	}
	public static void main(String[] args) {
//		System.out.println("enter the no of colum");
//		Scanner s=new Scanner(System.in);
//		size=s.nextInt();
//		for(int i=0;i<size;i++)if(i*i==size) {gridsize=i;break;}
//		int[][] mat=new int[size][size];
//		while(true) {
//			System.out.println("enter 1 for partial input or anyother  to solve the suduko");
//			int a=s.nextInt();
//			if(a==1) {
//				System.out.println("enter initial input\n enter the rownumber");
//				int row=s.nextInt();
//				System.out.println("enter the col number");
//				int col=s.nextInt();
//				System.out.println("enter the input");
//				int input=s.nextInt();
//				mat[row][col]=input;
//			}
//			else {printSuduko(mat);
//				break;}
//			
//		}
		int [][]mat= {{1,2,0,3,0,4,0,5,6},
					{7,0,0,0,0,6,0,0,1},
					{0,0,0,0,0,0,0,0,0},
					{0,8,0,4,0,9,0,2,0},
					{0,0,0,0,6,0,0,0,0},
					{0,3,0,5,0,1,0,8,0},
					{0,0,0,0,0,0,0,0,0},
					{9,0,0,2,0,0,0,0,8},
					{8,4,0,6,0,7,0,1,9}};
		
		if(solve(mat)) {
			System.out.println("suduko solved");
			printSuduko(mat);
		}
		else {System.out.println("unsolvable suduko");
			printSuduko(mat);}
	}
}
