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
    
    DebugConsole console;

    @Override
    public void load(DataStreamingModule dsm, SynchronizedRegisterArray sra) {
        console = new DebugConsole();
        console.init(dsm, sra);
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
        PluginGuiTab[] gui = {new PluginGuiTab("Debug Console", console, true)};
        return gui;
    }

    @Override
    public String pluginName() {
        return "Debug Console";
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
        return "The Debug Console allows for advanced debug output without a"
                + " headache.  You can set a debug level, connect multiple"
                + " clients, and more.  The Debug Console Plugin comes bundled"
                + " with the Dashboard essentials pack.  ";
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
