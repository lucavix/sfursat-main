package biz.opengate.sfursat;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PathUtils {

	private final static Logger LOG = Logger.getLogger(PathUtils.class.getCanonicalName());

	public static Path getCatalinaBasePath() {
		return Paths.get(System.getProperty("catalina.base"));
	}

	public static Path getOutputDir() {
		Path output = getCatalinaBasePath().resolve("webapps/output");
		if (Files.notExists(output)) {
			try {
				Files.createDirectories(output);
			} catch (IOException e) {
				LOG.log(Level.SEVERE, "While creating output dir:" + output.getFileName(), e);
			}
		}
		return output;
	}

	public static void recreateOutputDir() {
		Path output = getOutputDir();

		try {
			Files.walkFileTree(output, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					Files.delete(file);
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					Files.delete(dir);
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "While clenaning output dir:" + output.getFileName(), e);
		}
	}
	
	public static Path getLibraryDir() {
		String libDir = System.getProperty("sfursat.library");
		Path res = null;
		if (libDir==null) {
			res = getCatalinaBasePath().resolve("sfursat");
		} else {
			res = Paths.get(libDir);
		}
		return res;
	}
}
