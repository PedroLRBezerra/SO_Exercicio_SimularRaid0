package view;

import controller.RaidController;

public class Main {
	public static void main(String[] args) {
		RaidController raid0= new RaidController(2);
		raid0.saveFileInDisk(250);
		
	}
}
