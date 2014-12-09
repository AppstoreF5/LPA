
package app.management.prototype;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppManagementPrototype {

   
    public static void main(String[] args) 
    throws IOException
    {   SysFunc tSys = new SysFunc();
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Running from: " + s);
        tSys.logIn();
   }
}
