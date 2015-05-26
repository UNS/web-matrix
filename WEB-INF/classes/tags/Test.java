package tags;

import java.io.*;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import matrix.*;



/**     Альбом   
 *
 *  @author <A HREF="mailto:nikolais@mail.ru">Nikolay</A>
 */

public class Test extends TagSupport {

private int x,y,width,height,list;
private String fullImgPath,smallImgPath,align;
private File imgFolder,smallImgFile;
//-----------------------------------------

public void setX(int x){
if (x>20 && x<1) x=3;
this.x = x;
}

public void setY(int y){
if (y<1) x=100;
this.y = y;
}

public void setList(int list){
this.list = list;
}

public void setAlign(String align){
this.align = align;
}

public void setWidth(int width){
if (width == 0) width = 150;
this.width = width;
}

public void setHeight(int height){
if (height == 0) height = 113;
this.height = height;
}


////------------------------------------------------------\\\\
	public int doStartTag() throws JspException {

Matrix A = new Matrix("2;2;1;2;3;4");

try{
pageContext.getOut().print(A);
pageContext.getOut().print(A.getDet());
pageContext.getOut().print(Matrix.reverse(A));
}
	catch(java.io.IOException ex) {
	throw new JspException(ex.getMessage());
	}
return SKIP_BODY;
	}
//-----------------------------------------------------
public int doEndTag() throws JspException {
	return EVAL_PAGE;
	}
}