package edu.jsu.mcis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TicTacToeGame extends JPanel implements ActionListener{
	private TicTacToe model;
	
	private JButton[][] button;

	public TicTacToeGame(){
		model = new TicTacToe();
		button = new JButton[3][3];
		setLayout(new GridLayout(3,3));
		for(int i=0;i<button.length;i++){
			for(int j=0;j<button.length;j++){
				button[i][j] = new JButton();
				button[i][j].setPreferredSize(new Dimension(100,100));
				button[i][j].addActionListener(this);
				button[i][j].setName("Location"+i+""+j);
				add(button[i][j]);
			}
		}
		
	}
	
	private void checkForWin(){
		if(model.getCurrentGameState() != TicTacToe.GameState.NOTDONE){
			String s;
			if(model.getCurrentGameState() == TicTacToe.GameState.X){
				s = "X";
			}else if(model.getCurrentGameState() == TicTacToe.GameState.O){
				s = "O";
			}else if(model.getCurrentGameState() == TicTacToe.GameState.TIE){
				s = "TIE";
			}else{
				s = "";
			}
			if(s.length()>0){
				MyDialog d = new MyDialog("The winner is "+s);
				Thread t = new Thread(d);
				t.start();
			}
		}
	}
	
	public void actionPerformed(ActionEvent event){
		JButton b = (JButton)event.getSource();
		String loc = b.getName().substring(8);
		int r = Integer.parseInt(loc.substring(0,1));
		int c = Integer.parseInt(loc.substring(1,2));
		model.markLocationByRowAndColumn(r,c);
		b.setText(model.getMarkByRowAndColumn(r,c));
		checkForWin();
	}
	
	public static void main (String[] args){
		JFrame win = new JFrame("Tic Tac Toe");
		win.add(new TicTacToeGame());
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.pack();
		win.setVisible(true);
	}
}