package test;
 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
 
public class SessionServlet extends HttpServlet {
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      // Set the response message's MIME type
      response.setContentType("text/html;charset=UTF-8");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
 
      // Return the existing session if there is one. Create a new session otherwise.
      HttpSession session = request.getSession();
      Integer accessCount;
      synchronized(session) {
         accessCount = (Integer)session.getAttribute("accessCount");
         if (accessCount == null) {
            accessCount = 0;   // autobox int to Integer
         } else {
            accessCount = new Integer(accessCount + 1);
         }
         session.setAttribute("accessCount", accessCount);
      }
 
      // Write the response message, in an HTML page
      try {
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title>Munkamenet TestServlet</title></head><body>");
         out.println("<h2>" + accessCount + " alkalommal f�rt�l hozz� ehhez a munkamenethez.</h2>");
         out.println("<p>(Munkamenet Azonos�t�: " + session.getId() + ")</p>");
 
         out.println("<p>(Munkamenet l�trehozatali ideje: " +
               new Date(session.getCreationTime()) + ")</p>");
         out.println("<p>(Munkamenet utols� hozz�f�r�si ideje: " +
               new Date(session.getLastAccessedTime()) + ")</p>");
         out.println("<p>(Munkamenet inaktivit�si ideje: " +
               session.getMaxInactiveInterval() + " m�sodperc)</p>");
 
         out.println("<p><a  href='" + request.getRequestURI() +  "'>Friss�t�s</a>");
         out.println("<p><a  href='" + response.encodeURL(request.getRequestURI())  +
                     "'>Friss�t�s URL �jra�r�ssal</a>");
         out.println("</body></html>");
      } finally {
         out.close();  // Always close the output writer
      }
   }
}