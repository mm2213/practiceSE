package com.mihir;
// this class contains the type of message user will get during application usage

public class OutputPrinter {
	public void welcome() {
		printWithNewLine("Welcome to parking lot system/software.");
	}
	
	public void end() {
		printWithNewLine("Thanks for using services");
	}
	
	public void notFound() {
		printWithNewLine("Not found");
	}
	
	public void statusHeader() {
		printWithNewLine("Slot No.    Registration No    Colour");
	}
	
	public void parkingLotFull() {
		printWithNewLine("Parking lot is full.");
	}
	
	public void parkingLotEmpty() {
		printWithNewLine("Parking lot is empty.");
	}
	
	public void invalidFile() {
		printWithNewLine("Invalid file given.");
	}

	private void printWithNewLine(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}
}
