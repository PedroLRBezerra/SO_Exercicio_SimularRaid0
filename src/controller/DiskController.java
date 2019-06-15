package controller;

public class DiskController {
	
	private int [] sectors;
	
	public DiskController(int storageCapacity, int sectorsSize ) {
		this.sectors=new int[storageCapacity/sectorsSize];
	}
	
	public void insertInSector(int pos) {
		this.sectors[pos]=1;
	}
	
	
}
