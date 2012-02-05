package generator.website;

public class T_jspBody
{
  protected static String nl;
  public static synchronized T_jspBody create(String lineSeparator)
  {
    nl = lineSeparator;
    T_jspBody result = new T_jspBody();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "<div class=\"MainDiv\">" + NL + "" + NL + "  <div class=\"header\">" + NL + "    <div align=\"center\"><h4>MDOC Projet: ";
  protected final String TEXT_3 = "</h4></div>" + NL + "  </div>" + NL + "  " + NL + "  <div class=\"sidebar\">" + NL + "<a href=\"menuAddContact\">add contact</a><br>" + NL + "<a href=\"menuRemoveClient\">remove contact</a><br>" + NL + "<a href=\"menuSearchPage\">search contact</a><br>" + NL + "<a href=\"updateContact.jsp\">update contact</a><br>" + NL + "<a href=\"ClearTable\">clear table</a><br>" + NL + "<a href=\"ShowAllContact\">showTable</a><br>" + NL + "  </div>" + NL + "  " + NL + "  <div class=\"mainBody\" style=\"overflow:auto\">" + NL + "  <%=request.getParameter(\"dbOutput\")  == null ? \"\" : request.getParameter(\"dbOutput\")%>" + NL + "  <%=request.getParameter(\"dbOutputRaw\")  == null ? \"\" : request.getParameter(\"dbOutputRaw\")%>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     Object obj = argument;  
     String header = (String)obj;  
    stringBuffer.append(TEXT_2);
    stringBuffer.append(header);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
