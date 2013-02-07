/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jlogparser;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jlogparser.ui.MainUI;

/**
 *
 * @author jjiang3
 */
public class JLogParserCore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JLogParserCore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JLogParserCore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JLogParserCore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(JLogParserCore.class.getName()).log(Level.SEVERE, null, ex);
        }
        MainUI m = new MainUI();
        m.setVisible(true);
        
    }
    
    
    public String generateQuery(String[] fields, HashMap<String,String> args) {
        String field = "*";
        String source = args.get("source");
        String dest = args.get("dest");
        String from = args.get("from");
        String to = args.get("to");
        if(fields!=null&&fields.length>1){
            for(int i=0;i<fields.length;i++) {
                String f = fields[i];
                if(i==(fields.length-1)) {
                    field += f;
                }else{
                    field += f + ",";
                }
            }
        }
        String where = "WHERE TimeGenerated >= '"+from+"' AND TimeGenerated <= '"+to+"'";
        
        
        String sql = "select "+field+" into '"+source+"' from '"+dest+"' "+where;
        
        
        
        return sql;
    }
    
    public String generateCommand(String sql) {
        String command = "logparser ";
        String inType = " -i:evt ";
        String outType = " -o:csv " ;
        
        
        return command+inType+outType+" \""+sql+"\"";
    }

    public void validateForm() {
       //TODO
    }
    
}
