package com.mihir.commands;

import com.mihir.OutputPrinter;
import com.mihir.model.Command;
import com.mihir.service.ParkingLotService;

/**
 * Executor to handle command of exiting from the parking lot service. This is used in interactive
 * mode to exit.
 */

public class ExitCommandExecutor extends CommandExecutor {
	public static String COMMAND_NAME="exit";
	
	public ExitCommandExecutor(
		 final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
		 super(parkingLotService, outputPrinter);
	}
	
	@Override
	public boolean validate(final Command command) {
		// TODO Auto-generated method stub
		return command.getParams().isEmpty();
	}
	
	@Override
	public void execute(final Command command) {
		// TODO Auto-generated method stub
		outputPrinter.end();
	}
}
