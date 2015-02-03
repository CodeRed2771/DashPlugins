package plugin;

import com.coderedrobotics.dashboard.api.Plugin;
import com.coderedrobotics.dashboard.api.PluginGUITab;
import com.coderedrobotics.dashboard.plugins.debugconsole.DebugConsole;
import com.coderedrobotics.dashboard.plugins.debugconsole.Options;
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

    Options options;
    DebugConsole console;

    @Override
    public void init() {
        options = new Options();
        console = new DebugConsole(options);
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
        PluginGUITab[] pgt = {new PluginGUITab("Debug Console", console, true)};
        return pgt;
    }

    @Override
    public Component getSettingsGUI() {
        return options;
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
        return "The Debug Console allows for easy debugging of Java code on the "
                + "roboRIO right in the dashboard.  You can create multiple streams, "
                + "and enable and disable them as you would like.";
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
        return "2771coderedrobotics-debugconsole";
    }

}
