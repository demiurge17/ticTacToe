package ticTacToe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ticTacToe implements ActionListener {
	
	Random random= new Random();
	JFrame frame= new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel= new JPanel();
	JLabel textField= new JLabel();
	JButton[] buttons= new JButton[9];
	JButton newGameButton = new JButton("New Game");
	JButton exitButton= new JButton("Exit Game");
	JPanel controlPanel = new JPanel();
	boolean player1_turn;
	
	
	
	ticTacToe(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(850, 850);
		frame.getContentPane().setBackground(new Color(0,50,100));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textField.setBackground(new Color(0,25,50));
		textField.setForeground(new Color(200, 75, 100));
		textField.setFont(new Font("Times New Roman", Font.BOLD,75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("TicTacToe");
		textField.setOpaque(true);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 800, 100);
		
		
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(0, 100,100));
		
		for(int i=0; i<9; i++)
		{
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("Poppins", Font.BOLD, 100));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			buttons[i].setBackground(new Color(0,100,100));
			
		}
		
		titlePanel.add(textField);
		frame.add(titlePanel,BorderLayout.NORTH);
		frame.add(buttonPanel);
		
		//new game and exit
		
		controlPanel.setLayout(new FlowLayout());
		controlPanel.setBackground(new Color(0,25,50));
		
		newGameButton.setFont(new Font("Poppins", Font.BOLD,25));
		newGameButton.setFocusable(false);
		newGameButton.setVisible(false);
		newGameButton.addActionListener(this);
		newGameButton.setBackground(new Color(100, 255, 200));
		
		
		exitButton.setFont(new Font("Poppins", Font.BOLD,25));
		exitButton.setFocusable(false);
		exitButton.setVisible(false);
		exitButton.addActionListener(this);
		exitButton.setBackground(new Color(100,255,200));
		
		controlPanel.add(newGameButton);
		controlPanel.add(exitButton);
		
		frame.add(controlPanel, BorderLayout.SOUTH);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== newGameButton)
		{
			resetGame();
			return;
		}
		
		if(e.getSource()== exitButton)
		{
			System.exit(0);
		}
		
		for (int i=0; i<9; i++)
		{
			if(e.getSource()== buttons[i])
			{
				if(player1_turn)
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(new Color(0,0,100));
						buttons[i].setText("X");
						player1_turn=false;
						textField.setText("Time for O");
						check();
					}
				}
				
				else {
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(new Color(100,0,100));
						buttons[i].setText("O");
						player1_turn=true;
						textField.setText("Time for X");
						check();
					}
					
				}
			}
		}
		
		
		
	}
	
	public void firstTurn() {
		
		if(random.nextInt(2) == 0) {
			player1_turn=true;
			textField.setText("Time for X");
		}
		else {
			player1_turn=false;
			textField.setText("Time for O");
		}
		
	}

	public void check() {
		
		//for X
		if( 
				(buttons[0].getText() == "X") &&
				(buttons[1].getText() == "X") &&
				(buttons[2].getText() == "X") 
				
				)
		{
			xWon(0,1,2);
		}
		
		if( 
				(buttons[3].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[5].getText() == "X") 
				
				)
		{
			xWon(3,4,5);
		}
		if( 
				(buttons[6].getText() == "X") &&
				(buttons[7].getText() == "X") &&
				(buttons[8].getText() == "X") 
				
				)
		{
			xWon(6,7,8);
		}
		if( 
				(buttons[0].getText() == "X") &&
				(buttons[3].getText() == "X") &&
				(buttons[6].getText() == "X") 
				
				)
		{
			xWon(0,3,6);
		}
		
		if( 
				(buttons[0].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[8].getText() == "X") 
				
				)
		{
			xWon(0,4,8);
		}
		if( 
				(buttons[1].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[7].getText() == "X") 
				
				)
		{
			xWon(1,4,7);
		}
		if( 
				(buttons[2].getText() == "X") &&
				(buttons[5].getText() == "X") &&
				(buttons[8].getText() == "X") 
				
				)
		{
			xWon(2,5,8);
		}
		if( 
				(buttons[2].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[6].getText() == "X") 
				
				)
		{
			xWon(2,4,6);
		}
		
		//for O
		if( 
				(buttons[0].getText() == "O") &&
				(buttons[1].getText() == "O") &&
				(buttons[2].getText() == "O") 
				
				)
		{
			oWon(0,1,2);
		}
		
		if( 
				(buttons[3].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[5].getText() == "O") 
				
				)
		{
			oWon(3,4,5);
		}
		if( 
				(buttons[6].getText() == "O") &&
				(buttons[7].getText() == "O") &&
				(buttons[8].getText() == "O") 
				
				)
		{
			oWon(6,7,8);
		}
		if( 
				(buttons[0].getText() == "O") &&
				(buttons[3].getText() == "O") &&
				(buttons[6].getText() == "O") 
				
				)
		{
			oWon(0,3,6);
		}
		
		if( 
				(buttons[0].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[8].getText() == "O") 
				
				)
		{
			oWon(0,4,8);
		}
		if( 
				(buttons[1].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[7].getText() == "O") 
				
				)
		{
			oWon(1,4,7);
		}
		if( 
				(buttons[2].getText() == "O") &&
				(buttons[5].getText() == "O") &&
				(buttons[8].getText() == "O") 
				
				)
		{
			oWon(2,5,8);
		}
		if( 
				(buttons[2].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[6].getText() == "O") 
				
				)
		{
			oWon(2,4,6);
		}
		
		//if it is a draw
		
		boolean draw= true;
		
		for(int i = 0; i<9; i++)
		{
			if(buttons[i].getText() == "")
			{
				draw = false;
				break;
			}
			
		}
		
		if(draw)
		{
			drawGame();
		}
	}
	
	public void xWon(int a, int b, int c) {
		buttons[a].setBackground(new Color(100, 255,200));
		buttons[b].setBackground(new Color(100, 255,200));
		buttons[c].setBackground(new Color(100, 255,200));
		
		for(int i=0; i<9; i++)
		{
			buttons[i].setEnabled(false);
		}
		
		textField.setText("X wins");
		
		newGameButton.setVisible(true);
		exitButton.setVisible(true);
		
	}
	
	public void oWon(int a, int b, int c) {
		buttons[a].setBackground(new Color(100, 255,200));
		buttons[b].setBackground(new Color(100, 255,200));
		buttons[c].setBackground(new Color(100, 255,200));
		
		for(int i=0; i<9; i++)
		{
			buttons[i].setEnabled(false);
		}
		
		textField.setText("O wins");
		
		newGameButton.setVisible(true);
		exitButton.setVisible(true);
		
		
	}
	
	public void resetGame() {
		for(int i= 0; i<9; i++) {
			buttons[i].setText("");
			buttons[i].setEnabled(true);
			buttons[i].setBackground(new Color(0,100,100));
		}
		
		newGameButton.setVisible(false);
		exitButton.setVisible(false);
		firstTurn();
	}
	
	public void drawGame() {
		for(int i= 0; i<9; i++) {
			buttons[i].setEnabled(true);
		}
		
		textField.setText("It's a draw");
		newGameButton.setVisible(true);
		exitButton.setVisible(true);
	}
}
