package plugin;

import com.coderedrobotics.dashboard.api.Plugin;
import com.coderedrobotics.dashboard.api.PluginGUITab;
import com.coderedrobotics.virtualrobot.GUI;
import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class Init implements Plugin {

    GUI gui;
    
    @Override
    public void init() {
        gui = new GUI();
    }

    @Override
    public void run() {
        
    }

    @Override
    public void close() {
        
    }

    @Override
    public boolean createGUI() {
        return true;
    }

    @Override
    public PluginGUITab[] getGUITabs() {
        PluginGUITab[] tabs = { new PluginGUITab("System Monitor", gui, true) };
        return tabs;
    }

    @Override
    public Component getSettingsGUI() {
        return null;
    }

    @Override
    public String pluginName() {
        return "System Monitor";
    }

    @Override
    public double pluginVersion() {
        return 1;
    }

    @Override
    public String pluginAuthor() {
        return "Code Red Robotics";
    }

    @Override
    public String pluginDescription() {
        return "The System Monitor was originally designed to be bundled with the VirtualRobot system,"
                + " but it immediately became apparent of the uses of a separate monitoring plugin.  "
                + "The System monitor displays the status of PWM ports, Relays, Pnuematics, and the "
                + "compressor as long as the robot's VirtualizationController has monitoring enabled.  "
                + "The DIO and Analog In panels can set the DIO and analog in on the robot as long as "
                + "virtualization is enabled.  ";
    }

    @Override
    public URL pluginURL() {
        try {
            return new URL("http://www.coderedrobotics.com/");
        } catch (MalformedURLException ex) {
            Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String pluginID() {
        return "coderedrobotics2771-systemmonitor";
    }

}
