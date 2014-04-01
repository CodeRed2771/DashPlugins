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
    
    Camera camera;

    @Override
    public void load(DataStreamingModule dsm, SynchronizedRegisterArray sra) {
        camera = new Camera();
    }

    @Override
    public void run() {
        camera.run();
    }

    @Override
    public void unload() {
        camera.Disconnect();
        camera.run = false;
    }

    @Override
    public boolean createGUI() {
        return true;
    }

    @Override
    public PluginGuiTab[] getGuiTabs() {
        PluginGuiTab[] gui = {new PluginGuiTab("Camera", camera, true)};
        return gui;
    }

    @Override
    public String pluginName() {
        return "Camera";
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
        return "The Camera plugin displays output from an axis camera, given an "
                + "IP address.  The Camera plugin comes bundled with the "
                + "Dashboard essentials pack.";
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
