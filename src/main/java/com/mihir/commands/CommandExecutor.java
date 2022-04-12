package com.mihir.commands;

import com.mihir.OutputPrinter;
import com.mihir.model.Command;
import com.mihir.service.ParkingLotService;

/**
 * Command executor interface.
 */

public abstract class CommandExecutor {
	protected ParkingLotService parkingLotService;
	protected OutputPrinter outputPrinter;
	
	public CommandExecutor(final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
		// TODO Auto-generated constructor stub
		this.parkingLotService=parkingLotService;
		this.outputPrinter=outputPrinter;
	}
/*	
	public boolean commonValidate(Command command) {
		if(!command.getCommandName().equals(getName())) {
			return false;
		}
		return validate(command);
	}
	
	public abstract String getName();
*/
	public abstract boolean validate(Command command);

	public abstract void execute(Command command);

}
