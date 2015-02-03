package com.coderedrobotics.dashboard.plugins.pidtuner;

import com.coderedrobotics.dashboard.communications.Connection;
import com.coderedrobotics.dashboard.communications.Subsocket;
import com.coderedrobotics.dashboard.communications.exceptions.InvalidRouteException;
import com.coderedrobotics.dashboard.communications.exceptions.NotMultiplexedException;
import com.coderedrobotics.dashboard.plugins.pidtuner.MultiOverrideValueController.OverrideValue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
class PIDController {

    private OverrideValue p, i, d;
    private OverrideValue setpoint;
    private String route;
    
    PIDController(String basePath, MultiOverrideValueController movcP,
            MultiOverrideValueController movcI, MultiOverrideValueController movcD,
            MultiOverrideValueController movcSetpoint) {
        try {
            Subsocket root = Connection.getInstance().getRootSubsocket().enableMultiplexing();
            root.createNewRoute(basePath).enableMultiplexing();
            p = new OverrideValue();
            i = new OverrideValue();
            d = new OverrideValue();
            setpoint = new OverrideValue();
            p.setup(basePath + ".p", movcP);
            i.setup(basePath + ".i", movcI);
            d.setup(basePath + ".d", movcD);
            setpoint.setup(basePath + ".setpoint", movcSetpoint);
            route = basePath;
        } catch (NotMultiplexedException | InvalidRouteException ex) {
            Logger.getLogger(PIDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    OverrideValue getP() {
        return p;
    }

    OverrideValue getI() {
        return i;
    }

    OverrideValue getD() {
        return d;
    }

    OverrideValue getSetpoint() {
        return setpoint;
    }
    
    String getRoute() {
        return route;
    }
}
