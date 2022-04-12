package com.mihir.commands;

import java.util.List;

import com.mihir.OutputPrinter;
import com.mihir.model.Command;
import com.mihir.service.ParkingLotService;
import com.mihir.validator.IntegerValidator;

public class CreateParkingLotCommandExecutor extends CommandExecutor {
	public static String COMMAND_NAME="create_parking_lot";
	
	public CreateParkingLotCommandExecutor(final ParkingLotService parkingLotService,final OutputPrinter outputPrinter) {
		// TODO Auto-generated constructor stub
		super(parkingLotService,outputPrinter);
	}

	@Override
	public boolean validate(Command command) {
		// TODO Auto-generated method stub
		final List<String> params = command.getParams();
		if(params.size()!=1) {
			return false;
		}
		return IntegerValidator.isInteger(params.get(0));
	}

	@Override
	public void execute(Command command) {
		// TODO Auto-generated method stub
		
	}	

}
