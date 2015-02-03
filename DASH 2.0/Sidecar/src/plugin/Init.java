package plugin;

import com.coderedrobotics.dashboard.api.Plugin;
import com.coderedrobotics.dashboard.api.PluginGuiTab;
import com.coderedrobotics.dashboard.communications.DataStreamingModule;
import com.coderedrobotics.dashboard.communications.SynchronizedRegisterArray;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class Init implements Plugin {

    PWMandDIO sidecar;
    
    @Override
    public void load(DataStreamingModule dsm, SynchronizedRegisterArray sra) {
        sidecar = new PWMandDIO();
        sidecar.init(dsm, sra);
    }

    @Override
    public void run() {
    }

    @Override
    public void unload() {
    }

    @Override
    public boolean createGUI() {
        return true;
    }

    @Override
    public PluginGuiTab[] getGuiTabs() {
        PluginGuiTab[] gui = {new PluginGuiTab("Sidecar", sidecar, true)};
        return gui;
    }

    @Override
    public String pluginName() {
        return "Sidecar Monitor";
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
        return "The Sidecar Monitor plugin allows for the easy monitoring of "
                + "PWM and DIO ports on the FRC Digital Sidecar.  The Sidecar "
                + "Monitor plugin comes bundled with the Dashboard essentials "
                + "pack.  ";
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

}
