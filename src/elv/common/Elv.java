package elv.common;

import java.util.ArrayList;


/**
 * 
 * @author knight.Leo
 *
 */
public class Elv {

	private ArrayList<Cell> mind = new ArrayList<Cell>();
	private ArrayList<Cell> path = new ArrayList<Cell>();
	private Cell activeCell;
	private int activeSignalLevel = Image.REJECT;

	public Elv() {
		// mind.add(new Cell());
	}

	public void learn(Image img) {
		this.mind.add(new Cell(img));
	}

	public String IPO(String input) {
		// process input,get intermediate,until get result
		String workingMemory = input;
		int thinkingTimes = 0;
		while (1 != workingMemory.length()) {
			for (int i = 0; i <= workingMemory.length(); i++) {
				for (Cell cell : mind) {
					int curSignal = cell.match(workingMemory.substring(0, i));
					if (curSignal < this.activeSignalLevel) {
						this.activeCell = cell;
					}
				}

				if (null != this.activeCell) {
					workingMemory = this.activeCell.pass(workingMemory);
					break;
				}
			}
			this.activeCell = null;
			this.activeSignalLevel = Image.REJECT;

			if (thinkingTimes > input.length()) {
				workingMemory = "INVALID";
				break;
			}

			thinkingTimes++;
		}

		return workingMemory.toString();
	}
}
