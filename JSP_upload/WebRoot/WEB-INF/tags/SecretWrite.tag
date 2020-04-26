<%@ variable name-given="message" scope="AT_END" %>
<%@ tag pageEncoding="GB2312" %>
<%@ tag import="java.io.*" %>
<%@ attribute name="content" required="true" %>
<%  File dir=new File("C:/","Students");
    dir.mkdir();
    File f=new File(dir,"save.txt");
    try{ FileWriter outfile=new FileWriter(f);
         BufferedWriter bufferout=new BufferedWriter(outfile);
         char a[]=content.toCharArray();
         for(int i=0;i<a.length;i++)
             a[i]=(char)(a[i]^12);
         content=new String(a);
         bufferout.write(content);
         bufferout.close();
         outfile.close();
         jspContext.setAttribute("message","文件加密成功");
       }
    catch(IOException e){
         jspContext.setAttribute("message","文件加密失败");
    }
%>
