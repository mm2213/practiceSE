package com.mihir.mode;

import java.io.IOException;

import com.mihir.OutputPrinter;
import com.mihir.commands.CommandExecutorFactory;

public class InteractiveMode extends Mode {

	public InteractiveMode(final CommandExecutorFactory commandExecutorFactory,final OutputPrinter outputPrinter) {
		super(commandExecutorFactory,outputPrinter);
	}

	public void process() throws IOException{
		// TODO Auto-generated method stub
		
	}

}
