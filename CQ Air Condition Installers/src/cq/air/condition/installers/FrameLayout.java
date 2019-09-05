package cq.air.condition.installers;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 *@author Mohit Redhu
 *#Student ID: S12100962
 * 
 */
public class FrameLayout extends javax.swing.JFrame {
    public List<TechnicianDetails> techList = new ArrayList<>();
    public List<InstallationDetails> insList = new ArrayList<>();
    
    public void errorMessage(String message)
    {
        JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
    }
}
