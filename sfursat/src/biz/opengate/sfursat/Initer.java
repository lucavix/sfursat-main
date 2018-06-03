package biz.opengate.sfursat;

import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns={"/initer"},loadOnStartup=1)
public class Initer extends HttpServlet{
	
	private final static Logger LOG = Logger.getLogger(Initer.class.getCanonicalName());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		LOG.info("Starting...");
		LOG.info("Catalina Base Path:" + PathUtils.getCatalinaBasePath().toString());
		LOG.info("Output Dir:" + PathUtils.getOutputDir().toString());
		LOG.info("Library Dir:" + PathUtils.getLibraryDir().toString());
		
	}
	
}
