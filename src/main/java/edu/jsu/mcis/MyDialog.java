package edu.jsu.mcis;

import javax.swing.*;

public class MyDialog implements Runnable{
	private String message;
	
	public MyDialog(String s){
		message = s;
	}
	
	public void run(){
		JOptionPane.showMessageDialog(null, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
	}
}