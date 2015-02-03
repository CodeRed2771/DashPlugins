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
    
    SRAandDSM data;

    @Override
    public void load(DataStreamingModule dsm, SynchronizedRegisterArray sra) {
        data = new SRAandDSM();
        data.init(sra, dsm);
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
        PluginGuiTab[] gui = {new PluginGuiTab("SRA & DSM", data, true)};
        return gui;
    }

    @Override
    public String pluginName() {
        return "Dashboard Network Info";
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
        return "The Dashboard Network Info plugin displays what is going on "
                + "under the hood of the dashboard.  While not practical for"
                + " every day use, it is good for debugging or for those who "
                + "are curious.  The Dashboard Network Info plugin comes "
                + "bundled with the Dashboard essentials pack.  ";
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
