package com.cts.swd.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.cts.swd.ui.HomeFrame;

public class HomeFrameController implements ActionListener,ChangeListener {

	HomeFrame homeFrame;
	int lowerLimit,upperLimit;
	
	public HomeFrameController() {
		homeFrame = new HomeFrame(this);
	}
	
	public void showHomeFrame() {
		homeFrame.init();
		homeFrame.setVisible(true);
	}
	
	@Override
	public void stateChanged(ChangeEvent event) {
		if(event.getSource()==homeFrame.getSpOperand1()) {
			lowerLimit = (Integer)homeFrame.getSpOperand1().getValue();
		}else {
			upperLimit= (Integer)homeFrame.getSpOperand2().getValue();
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(lowerLimit>upperLimit) {
			JOptionPane.showInternalMessageDialog(homeFrame, 
					String.format("%d > %d, invalid boundaries and hence can not start", lowerLimit,upperLimit), 
					"Error", JOptionPane.ERROR_MESSAGE);
		}else {
			homeFrame.getBtnStart().setEnabled(false);
			JProgressBar pb = homeFrame.getProgressBar();
			pb.setMinimum(0);
			pb.setMaximum(100);
			pb.setValue(0);
			((DefaultListModel<Integer>)homeFrame.getListResults().getModel()).removeAllElements();
			Worker w = new Worker();
			w.execute();
		}
	}

	class Worker extends SwingWorker<Integer, Integer> {

		@Override
		protected Integer doInBackground() throws Exception {
			int result=upperLimit;
			for(int i=lowerLimit;i<=upperLimit;i++) {
				Thread.sleep(200);
				publish(i);
				setProgress((i*100)/upperLimit);
			}
			return result;
		}

		@Override
		protected void process(List<Integer> chunks) {
			DefaultListModel<Integer> listModel = (DefaultListModel<Integer>)homeFrame.getListResults().getModel();
			listModel.addElement(chunks.get(chunks.size()-1));
			homeFrame.getProgressBar().setValue(getProgress());
		}

		@Override
		protected void done() {
			homeFrame.getBtnStart().setEnabled(true);
		}
		
		
	}
}
