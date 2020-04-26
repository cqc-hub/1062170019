<%@ tag pageEncoding="GB2312" %>
<%@ tag import="java.io.*" %>
<%@ attribute name="dir" required="true" %>
<%@ attribute name="fileName" required="true" %>
<%@ attribute name="content" type="java.lang.String" required="true"  %>
<%!
   public void writeContent(String str,File f){ 
      try{  FileWriter outfile=new FileWriter(f);
            BufferedWriter bufferout=new BufferedWriter(outfile);
            bufferout.write(str);
            bufferout.close();
            outfile.close();
       } 
       catch(IOException e){}
   }
%>
<%  File mulu=new File(dir);
    mulu.mkdir();
    File f=new File(mulu,fileName);
    if(content.length()>0){
       writeContent(content,f);
       out.println("³É¹¦Ð´Èë");
    } 
%>
