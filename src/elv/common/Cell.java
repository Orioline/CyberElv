package elv.common;

public class Cell {
	private Image rule = null;

	public Cell(Image rule) {
		this.rule = rule;
	}

	// public Image I(Image input){
	// this.workingMemory = input;
	// return this.workingMemory;
	// }
	//
	// public Image P(){
	// return this.workingMemory;
	// }
	//
	// public Image O(){
	// return this.workingMemory;
	// }
	// public Image P(Image input)
	// {
	// if(input.reason.equals(rule.reason))
	// {
	//
	// }
	// return input.reason;
	// }

	public int match(String signal) {
		if (signal.contains(this.rule.reason)) {
			return signal.indexOf(this.rule.reason);
		} else {
			return Image.REJECT;
		}
	}

	public String pass(String signal) {
		String newSignal = signal.replace(this.rule.reason, this.rule.result);
		return newSignal;
	}
}
