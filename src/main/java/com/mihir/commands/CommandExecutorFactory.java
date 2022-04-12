package com.mihir.commands;

import java.util.HashMap;
import java.util.Map;

import com.mihir.OutputPrinter;
import com.mihir.model.Command;
import com.mihir.service.ParkingLotService;

/**
 * Factory to get correct {@link CommandExecutor} from a given command.
 */

public class CommandExecutorFactory {
	private Map<String, CommandExecutor> commands = new HashMap<>();
	
	public CommandExecutorFactory(ParkingLotService parkingLotService) {
		// TODO Auto-generated constructor stub
		
		final OutputPrinter outputPrinter = new OutputPrinter();
	    commands.put(
	        CreateParkingLotCommandExecutor.COMMAND_NAME,
	        new CreateParkingLotCommandExecutor(parkingLotService, outputPrinter));
	    commands.put(
	        ParkCommandExecutor.COMMAND_NAME,
	        new ParkCommandExecutor(parkingLotService, outputPrinter));
	    commands.put(
	        LeaveCommandExecutor.COMMAND_NAME,
	        new LeaveCommandExecutor(parkingLotService, outputPrinter));
	    commands.put(
	        StatusCommandExecutor.COMMAND_NAME,
	        new StatusCommandExecutor(parkingLotService, outputPrinter));
	    commands.put(
	        ColorToRegNumberCommandExecutor.COMMAND_NAME,
	        new ColorToRegNumberCommandExecutor(parkingLotService, outputPrinter));
	    commands.put(
	        ColorToSlotNumberCommandExecutor.COMMAND_NAME,
	        new ColorToSlotNumberCommandExecutor(parkingLotService, outputPrinter));
	    commands.put(
	        SlotForRegNumberCommandExecutor.COMMAND_NAME,
	        new SlotForRegNumberCommandExecutor(parkingLotService, outputPrinter));
	    commands.put(
	        ExitCommandExecutor.COMMAND_NAME,
	        new ExitCommandExecutor(parkingLotService, outputPrinter));
		
	}

	public CommandExecutor getCommandExecutor(Command command) {
		// TODO Auto-generated method stub
		return null;
	}

}
