package com.mihir;

import com.mihir.commands.CommandExecutorFactory;
import com.mihir.exception.InvalidModeException;
import com.mihir.mode.FileMode;
import com.mihir.mode.InteractiveMode;
import com.mihir.service.ParkingLotService;
import java.io.IOException;

public class Main {

	public static void main(final String[] args) throws IOException {
		// TODO Auto-generated method stub
		final OutputPrinter outputPrinter = new OutputPrinter();
		final ParkingLotService parkingLotService = new ParkingLotService(); 
		final CommandExecutorFactory commandExecutorFactory = 
							new CommandExecutorFactory(parkingLotService);
		
		// input mode are of two types 1. using command line and 2. using file
		
		if(isInteractiveMode(args)) {
			new InteractiveMode(commandExecutorFactory, outputPrinter).process();
		}else if(isFileInputMode(args)) {
			new FileMode(commandExecutorFactory, outputPrinter,args[0]).process();
		}else {
			throw new InvalidModeException();
		}
		
	}

	private static boolean isInteractiveMode(final String[] args) {
		return args.length == 0;
	}
	
	private static boolean isFileInputMode(final String[] args) {
			return args.length == 1;
		}

}
