package biz.opengate.sfursat;

public class Library {
	private static Library instance;
	
	public static synchronized Library getInstance() {
		if (instance==null) {
			instance = new Library();
		}
		return instance;
	}
	
	private Library() {
		super();
	}
	
	
}
