package com.mihir.mode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.mihir.OutputPrinter;
import com.mihir.commands.CommandExecutorFactory;
import com.mihir.model.Command;

// Mode running in which commands are given from a file
public class FileMode extends Mode {
	private String fileName;
	
	public FileMode(final CommandExecutorFactory commandExecutorFactory, final OutputPrinter outputPrinter, final String fileName) {
		// TODO Auto-generated constructor stub
		super(commandExecutorFactory,outputPrinter);
		this.fileName=fileName;
	}

	@Override
	public void process() throws IOException {
		// TODO Auto-generated method stub
		final File file= new File(fileName);
		final BufferedReader reader;
		
		reader= new BufferedReader(new FileReader(file));
		
		String input = reader.readLine();
		while(input != null) {
			final Command command= new Command(input);
			processCommand(command);
			input = reader.readLine();
		}
		
		
		
	}

}
