package com.cts.bta;

import com.cts.bta.controller.HomeFrameController;

public class BudgetTrackingApplication {

	public static void main(String[] args) {
		HomeFrameController ctrl = new HomeFrameController();
		ctrl.showHomeFrame();
		ctrl.loadData();
	}
}
