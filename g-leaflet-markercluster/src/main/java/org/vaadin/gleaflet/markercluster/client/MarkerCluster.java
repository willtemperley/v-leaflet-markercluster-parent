package org.vaadin.gleaflet.markercluster.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.peimari.gleaflet.client.Marker;

/**
 * These are created dynamically in JS therefore can't be constructed
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
