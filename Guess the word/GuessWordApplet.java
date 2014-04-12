/*============================
 *=Author : wtarr            =
 *=                          =
 *=                          =
 *=  Title: GuessWord Applet = 
 *=                          =
 *=                          =
 *============================
 */
 
import javax.swing.JApplet;
import javax.swing.SwingUtilities;

public class GuessWordApplet extends JApplet {
    
    // ================================================================================
    // =========Called when this applet is loaded into the browser=====================
    // ================================================================================
    public void init() {
        //Execute a job on the event-dispatching thread; creating this applet's GUI.
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    createGUI();
                }
            });
        } catch (Exception e) { 
            System.err.println("createGUI didn't complete successfully");
        }
    }
    
    // ================================================================================
    // ==================Create and set up the content pane============================
    // ================================================================================
    private void createGUI() {
        GuessWord gw = new GuessWord();
        gw.setOpaque(true); 
        setContentPane(gw);        
    }
}