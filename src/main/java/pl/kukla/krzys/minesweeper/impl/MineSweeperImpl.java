package pl.kukla.krzys.minesweeper.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.kukla.krzys.minesweeper.MineSweeper;

public class MineSweeperImpl implements MineSweeper{
	
	private String squareString;
	
	private Log log = LogFactory.getLog(this.getClass());

	public void setMineField(String mineField) throws IllegalArgumentException {
		final String[] line = mineField.split("\n");
		int ySize = line.length;
		int yMax = ySize-1;
		int xSize = line[0].length();
		int xMax = xSize-1;
		int square[][] = new int[ySize][xSize];
		for(int y=0;y<ySize;y++){
			if (xSize!=line[y].length()){
				log.error(line[y], new IllegalArgumentException());
				throw new IllegalArgumentException(line[y]);
			}
			System.out.println();
			for(int x=0;x<xSize;x++){
				char sign = line[y].charAt(x);
				System.out.print(sign);
				if (sign=='*'){
					// the number -1 represents mine type
					square[y][x]=-1;
					
					if (y<yMax){
						if (square[y+1][x]!=-1) square[y+1][x]++;
					}
					if (x<xMax){
						if (square[y][x+1]!=-1) square[y][x+1]++;
					}
					if (y>0){
						if (square[y-1][x]!=-1) square[y-1][x]++;
					}
					if (x>0){
						if (square[y][x-1]!=-1) square[y][x-1]++;
					}
					if (y<yMax && x<xMax){
						if (square[y+1][x+1]!=-1) square[y+1][x+1]++;
					}
					if (y>0 && x>0){
						if (square[y-1][x-1]!=-1) square[y-1][x-1]++;
					}
					if (y<yMax && x>0){
						if (square[y+1][x-1]!=-1) square[y+1][x-1]++;
					}
					if (y>0 && x<xMax){
						if (square[y-1][x+1]!=-1) square[y-1][x+1]++;
					}
					continue;
				}
				if (sign=='.'){
					continue;
				}
				log.error(x, new IllegalArgumentException());
				throw new IllegalArgumentException(line[y]);
			}
		}
		convertToString(square);
	}

	private void convertToString(int[][] square) {
		System.out.println();
		StringBuilder builder = new StringBuilder();
		for(int[] y: square){
			for(int x: y){
				if (x==-1) builder.append('*');
				else builder.append(x);
			}
			builder.append("\\n");
		}
		this.squareString = builder.toString();
		
	}

	public String getHintField() throws IllegalStateException {
		return squareString;
	}
	
	public static void main(String[] args) {
		MineSweeper m = new MineSweeperImpl();
		m.setMineField(".*..**\n*.**.*\n.*.*..");
		System.out.println(m.getHintField());
	}

}
