package com.cts.ld;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class CardLayoutDemo extends JDialog {
	
	JPanel cardPanel,buttonsPanel,titlesPanel;
	JButton btnNext,btnPrev;
	JComboBox<String> cbTitles;
	CardLayout cardLayout;
	
	public CardLayoutDemo() {
		setTitle("Card layout demo");
		setBounds(50,50,500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		
		Map<String,Color> titlesAndColors = new TreeMap<>();
		
		titlesAndColors.put("RedPanel",Color.RED);
		titlesAndColors.put("BlackPanel",Color.BLACK);
		titlesAndColors.put("WhitePanel",Color.WHITE);
		titlesAndColors.put("YellowPanel",Color.YELLOW);
		titlesAndColors.put("OrangePanel",Color.ORANGE);
		
		for(String title:titlesAndColors.keySet())
			cardPanel.add(title,createColoredPanel(titlesAndColors.get(title)));
		
		titlesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cbTitles = new JComboBox<String>(new Vector<String>(titlesAndColors.keySet()));
		titlesPanel.add(cbTitles);
		
		cbTitles.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String title = (String) cbTitles.getSelectedItem();
				cardLayout.show(cardPanel, title);
			}
		});
		
		buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnPrev = new JButton("<<Prev");
		btnNext = new JButton("Next>>");
	
		buttonsPanel.add(btnPrev);
		buttonsPanel.add(btnNext);
		
		btnPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.previous(cardPanel);
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(cardPanel);
			}
		});
		
		add(titlesPanel,BorderLayout.NORTH);
		add(cardPanel);
		add(buttonsPanel,BorderLayout.SOUTH);
	}
	
	JPanel createColoredPanel(Color color) {
		JPanel p = new JPanel();
		p.setBackground(color);
		return p;
	}

	public static void main(String[] args) {
		CardLayoutDemo fd = new CardLayoutDemo();
		fd.setVisible(true);
	}

}
