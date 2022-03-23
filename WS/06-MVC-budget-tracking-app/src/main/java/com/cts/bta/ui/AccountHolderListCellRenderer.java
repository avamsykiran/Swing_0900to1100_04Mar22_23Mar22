package com.cts.bta.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cts.bta.entities.AccountHolder;

@SuppressWarnings("serial")
public class AccountHolderListCellRenderer extends DefaultListCellRenderer{

	private final static Color selectedColor =Color.GRAY;
	private final static Color unSelectedColor =Color.WHITE;
	
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		JPanel panel=null;
		
		if(value instanceof AccountHolder) {
			AccountHolder ah = (AccountHolder)value;
			panel = new JPanel();
			BoxLayout layout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
			panel.setLayout(layout);
			panel.setBackground(isSelected?selectedColor:unSelectedColor);
			//panel.setPreferredSize(new Dimension(300, 100));
			panel.setBorder(new EmptyBorder(10,10,10,10));
			panel.add(new JLabel(String.valueOf(ah.getId())));
			panel.add(new JLabel(ah.getName()));
			panel.add(new JLabel(ah.getMobile()));
			panel.add(new JLabel(ah.getMailId()));
			
		}
		
		return panel;
	}

}
