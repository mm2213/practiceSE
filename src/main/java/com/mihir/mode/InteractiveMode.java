package com.mihir.mode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mihir.OutputPrinter;
import com.mihir.commands.CommandExecutorFactory;
import com.mihir.commands.ExitCommandExecutor;
import com.mihir.model.Command;

public class InteractiveMode extends Mode {

	public InteractiveMode(final CommandExecutorFactory commandExecutorFactory,final OutputPrinter outputPrinter) {
		super(commandExecutorFactory,outputPrinter);
	}

	public void process() throws IOException{
		// TODO Auto-generated method stub
		outputPrinter.welcome();
		final BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			final String input =reader.readLine();
			final Command command= new Command(input);
			processCommand(command);
			if(command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME));{
				break;
			}
		}
	}

}
