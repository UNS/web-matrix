package com.appspot.wm;

import java.io.*;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

/**
 *
 * @author <A HREF="mailto:nikolais@mail.ru">Nikolay</A>
 */
public class PrintMatrix extends TagSupport {

	private Matrix mtx;
	private int cp;
//-----------------------------------------

	public void setMatrix(Matrix A) {
		mtx = A;
	}

	public void setCellpadding(int cp) {
		if ((cp < 0) | (cp > 20)) {
			cp = 0;
		}
		this.cp = cp;
	}
////------------------------------------------------------\\\\

	public int doStartTag() throws JspException {
		try {
				pageContext.getOut().println("<TABLE cellpadding = " + cp + ">");
				for (int i = 1; i <= mtx.getM(); i++) {
					pageContext.getOut().println("<TR>");
					for (int j = 1; j <= mtx.getN(); j++) {
						pageContext.getOut().print("<TD>");
						pageContext.getOut().print(mtx.getElement(i, j));
						pageContext.getOut().println("</TD>");
					}
				}

				pageContext.getOut().print("</TABLE>");
		} catch (java.io.IOException ex) {
			throw new JspException(ex.getMessage());
		}
		return SKIP_BODY;
	}
//-----------------------------------------------------

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}
