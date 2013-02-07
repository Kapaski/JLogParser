/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jlogparser;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author jjiang3
 */
public class LogFileFilter extends FileFilter{
    private String extension;

    private String description;

    public LogFileFilter(String extension, String description) {
        super();
        this.extension = extension;
        this.description = description;
    }
    @Override
    public boolean accept(File f) {
       if(f!=null)  {
           if(f.isDirectory()){
               return true;
           }
           String filename = f.getName();
           if (extension != null && filename.endsWith(extension)) {
               return true;
           }
       }
       return false;
       
    }

    @Override
    public String getDescription() {
        return description;
    }

    public String getExtention() {
        return extension;
    }
    
}