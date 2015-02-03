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

    Gui pong;

    @Override
    public void load(DataStreamingModule dsm, SynchronizedRegisterArray sra) {
        pong = new Gui();
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
        PluginGuiTab[] gui = new PluginGuiTab[1];
        gui[0] = new PluginGuiTab("Pong!", pong, true);
        return gui;
    }

    @Override
    public String pluginName() {
        return "Pong Plugin";
    }

    @Override
    public double pluginVersion() {
        return 1.0;
    }

    @Override
    public String pluginAuthor() {
        return "Michael Spoehr";
    }

    @Override
    public String pluginDescription() {
        return "Just a fun plugin that runs inside of the dashboard.... if you "
                + "haven't noticed, you can play pong while queuing now.";
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
