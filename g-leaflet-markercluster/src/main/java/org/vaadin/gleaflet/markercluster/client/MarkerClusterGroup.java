package org.vaadin.gleaflet.markercluster.client;

import org.peimari.gleaflet.client.ILayer;
import org.peimari.gleaflet.client.LayerGroup;
import org.peimari.gleaflet.client.Marker;
import org.vaadin.gleaflet.markercluster.client.resources.LeafletMarkerClusterResourceInjector;

/**
 * 
 * @author Will Temperley
 *
 */
public class MarkerClusterGroup extends LayerGroup implements ILayer {
	
	static {
		LeafletMarkerClusterResourceInjector.ensureInjected();
	}
	
	protected MarkerClusterGroup() {}
	
	public static native MarkerClusterGroup create() 
	/*-{
		return new $wnd.L.MarkerClusterGroup();
	}-*/;
	
	public static native void addLayer(Marker marker) 
	/*-{
		this.addLayer(marker)
	}-*/;

}
