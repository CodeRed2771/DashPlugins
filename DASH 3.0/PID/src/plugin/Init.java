package plugin;

import com.coderedrobotics.dashboard.plugins.pidtuner.PID;
import com.coderedrobotics.dashboard.api.Plugin;
import com.coderedrobotics.dashboard.api.PluginGUITab;
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

    PID pid;

    @Override
    public void init() {
        pid = new PID();
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
        PluginGUITab[] pgt = {new PluginGUITab("PID", pid, true)};
        return pgt;
    }

    @Override
    public Component getSettingsGUI() {
        return null;
    }

    @Override
    public String pluginName() {
        return "PID Tuner";
    }

    @Override
    public double pluginVersion() {
        return 2;
    }

    @Override
    public String pluginAuthor() {
        return "Code Red Robotics";
    }

    @Override
    public String pluginDescription() {
        return "The Pid Tuner plugin allows a user to easily tune PID values "
                + "(or just see them).  The PID Tuner plugin comes bundled with "
                + "the Dashboard essentials pack.  ";
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
        return "2771coderedrobotics-PIDTunerv2";
    }

}
