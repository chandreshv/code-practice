package chandresh.practice.programs;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File f = new File("c:\\temp\\test.txt");
        File f2 = new File("c:\\temp\\newName.txt");
        if(!f.exists()){
        	try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("Error while creating file: "+e.getMessage());
			}
        }
    	if(f.renameTo(f2))
    		System.out.println("Successfully remaned to: " + f2.getName());
    	else
    		System.out.println("Error while renaming");

    }
}
