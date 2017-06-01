package org.vaadin.addon.leaflet.demoandtestapp.util;

import com.vaadin.annotations.Widgetset;

@Widgetset("org.vaadin.addon.leaflet.markercluster.Widgetset")
public class TServer extends org.vaadin.addonhelpers.TServer {

    /**
     * Starts and embedded server for the tests
     */
    public static void main(String[] args) throws Exception {
        new TServer().startServer(19998);
    }
}
