package com.mihir.mode;

import com.mihir.OutputPrinter;
import com.mihir.commands.CommandExecutorFactory;
import com.mihir.exception.InvalidCommandException;
import com.mihir.commands.CommandExecutor;
import com.mihir.model.Command;
import java.io.IOException;


/**
 * Interface for mode of the program in which it can be run.
 */

public abstract class Mode {
	private CommandExecutorFactory commandExecutorFactory;
	protected OutputPrinter outputPrinter;

	public Mode(
			CommandExecutorFactory commandExecutorFactory, OutputPrinter outputPrinter) {
		// TODO Auto-generated constructor stub
		this.commandExecutorFactory=commandExecutorFactory;
		this.outputPrinter=outputPrinter;
	}
	
	// helper method to process a command i.e it uses CommandExecutor to run the command
	protected void processCommand(final Command command) {
		final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(
																				command);
		if (commandExecutor.validate(command)) {
		      commandExecutor.execute(command);
		    } else {
		      throw new InvalidCommandException();
		    }
	}
	
	public abstract void process() throws IOException;
}
