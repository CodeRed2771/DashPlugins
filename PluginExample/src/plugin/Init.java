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

    @Override
    public void load(DataStreamingModule dsm, SynchronizedRegisterArray sra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unload() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createGUI() {
        return true;
    }

    @Override
    public PluginGuiTab[] getGuiTabs() {
        PluginGuiTab[] gui = {};
        return gui;
    }

    @Override
    public String pluginName() {
        return "Name";
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
        return "Description";
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
