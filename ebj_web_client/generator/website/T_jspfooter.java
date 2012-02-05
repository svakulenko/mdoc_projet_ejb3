package generator.website;

public class T_jspfooter
{
  protected static String nl;
  public static synchronized T_jspfooter create(String lineSeparator)
  {
    nl = lineSeparator;
    T_jspfooter result = new T_jspfooter();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "  </div>" + NL + "  " + NL + "  <jsp:include page=\"/commonPages/footer.jsp\" />" + NL + "" + NL + "</div>" + NL + "" + NL + "" + NL + "" + NL + "</body>" + NL + "" + NL + "</html>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
