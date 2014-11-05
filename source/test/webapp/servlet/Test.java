package webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String protocol = req.getProtocol();
		String msg = "<h1>from Mead servelt</h1>";
		if (protocol.endsWith("1.1")) {
			resp.getWriter().append(msg);
		} else {

		}
	}

}
