package controller;

public class RaidController {
	int sectorsSize=32;
	int qtyDisks;
	DiskController[] disks;
	
	public RaidController(int qtyDisks) {
		this.qtyDisks=qtyDisks;
		this.disks= new DiskController[qtyDisks];
		for(int x=0;x<disks.length;x++) {
			this.disks[x] = new DiskController(6400, this.sectorsSize);
		}				
	}
	
	public void saveFileInDisk(int sizeLength) {
		int sectorsNeeded =(int)Math.ceil((Double.valueOf(sizeLength)/Double.valueOf(this.sectorsSize)));
		for (int sectors = 0; sectors < sectorsNeeded/this.qtyDisks; sectors++) {
			for(int eachDisk = 0; eachDisk<qtyDisks;eachDisk++ ) {
				this.disks[eachDisk].insertInSector(sectors);
			}
		}
	}
	
	
}
