package com.tesch.UserInterface;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class UI {

	protected Shell shell;
	Integer score = 0;
	String txt = new String();
	String fileName = "/Users/Teschtastic/Projects/Java/Clicker-Game/resources/click.txt";
	File file = new File(fileName);
	BufferedReader br = null;
	BufferedWriter bw = null;

	/**
	 * Open the window.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public void open() throws IOException {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() throws IOException {
		shell = new Shell();
		shell.setSize(800, 600);
		shell.setText("Sean's Clicker Game");
		
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
		    System.out.println("No file found");
		}
		
		 txt = br.readLine();
		 System.out.println(txt);
		 score = Integer.parseInt(txt);
		
		Label lblScore = new Label(shell, SWT.NONE);
		lblScore.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 20, SWT.NORMAL));
		lblScore.setBounds(100, 200, 150, 50);
		lblScore.setText("Score: " + score);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				score += 1;
				lblScore.setText("Score: " + score);
			}
		});
		btnNewButton.setBounds(100, 250, 150, 150);
		btnNewButton.setText("Click Here");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					bw = new BufferedWriter(new FileWriter(fileName));
					bw.write(score.toString());
					System.out.println(score);
					bw.close();
					br.close();
					System.exit(0);
				} catch (IOException e1) {
					System.out.println("Couldn't write to file");
				}
			}
		});
		btnNewButton_1.setBounds(100, 10, 150, 27);
		btnNewButton_1.setText("Save and Quit");

	}
}
