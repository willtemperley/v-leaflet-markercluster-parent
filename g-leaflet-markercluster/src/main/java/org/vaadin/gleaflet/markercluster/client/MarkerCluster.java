package org.vaadin.gleaflet.markercluster.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.peimari.gleaflet.client.Marker;

/**
 * A marker cluster created dynamically in JS by the plugin
 */
public class MarkerCluster extends JavaScriptObject {

    protected MarkerCluster() {};

    public native final int getLength()
	/*-{
        return this.getChildCount();
    }-*/;

    public native final JsArray<Marker> getAllChildMarkers()
	/*-{
        return this.getAllChildMarkers();
    }-*/;

}
