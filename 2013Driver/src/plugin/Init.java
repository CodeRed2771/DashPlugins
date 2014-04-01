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
    
    Driver driver;

    @Override
    public void load(DataStreamingModule dsm, SynchronizedRegisterArray sra) {
        driver = new Driver();
        driver.init(dsm, sra);
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
        PluginGuiTab[] gui = {new PluginGuiTab("Driver", driver, true)};
        return gui;
    }

    @Override
    public String pluginName() {
        return "Operator HUD";
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
        return "The Operator HUD Plugin is custom made by Code Red Robotics "
                + "every year to fit the current game, and our robot design.  "
                + "It relays important information and graphs to our Robot "
                + "Operators on the field.  Even though it is written to fit "
                + "the needs of our robot, The Operator HUD plugin comes bund"
                + "led with the Dashboard essentials pack, to reference as an "
                + "example if desired.  ";
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
