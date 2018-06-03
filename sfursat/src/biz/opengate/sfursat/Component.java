package biz.opengate.sfursat;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class Component {
	private String name;
	private List<String> molds = new LinkedList<>();
	private Path path;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getMolds() {
		return molds;
	}
	public void setMolds(List<String> molds) {
		this.molds = molds;
	}
	public Path getPath() {
		return path;
	}
	public void setPath(Path path) {
		this.path = path;
	}
	
	
}
