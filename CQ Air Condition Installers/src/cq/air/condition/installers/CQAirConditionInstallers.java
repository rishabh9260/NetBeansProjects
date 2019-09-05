package cq.air.condition.installers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *@author Mohit Redhu
 *#Student ID: S12100962
 */
public class CQAirConditionInstallers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<TechnicianDetails> tech = new ArrayList<>();
        List<InstallationDetails> ins = new ArrayList<>();
        MainFrame mainFrame = new MainFrame(tech, ins);
        mainFrame.setVisible(true);
    }
    
}
