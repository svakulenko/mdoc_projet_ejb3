package generator.website;

public class T_jspHeader
{
  protected static String nl;
  public static synchronized T_jspHeader create(String lineSeparator)
  {
    nl = lineSeparator;
    T_jspHeader result = new T_jspHeader();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"" + NL + "    pageEncoding=\"UTF-8\"%>" + NL + "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">" + NL + "<html>" + NL + "<head>" + NL + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + NL + "<link href=\"cssStyle.css\" rel=\"stylesheet\" type=\"text/css\">" + NL + "<title>Mdoc projet (JSP, Hibernate, Spring)</title>" + NL + "</head>" + NL + "<body>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
