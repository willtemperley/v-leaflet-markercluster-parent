package org.vaadin.gleaflet.markercluster.client;

import org.peimari.gleaflet.client.LayerGroup;
import org.peimari.gleaflet.client.Marker;
import org.vaadin.gleaflet.markercluster.client.resources.LeafletMarkerClusterResourceInjector;

/**
 * 
 * @author Will Temperley
 *
 */
public class MarkerClusterGroup extends LayerGroup {
	
	static {
		LeafletMarkerClusterResourceInjector.ensureInjected();
	}
	
	protected MarkerClusterGroup() {}
	
	public static native MarkerClusterGroup create(MarkerClusterGroupOptions options)
	/*-{
		return new $wnd.L.MarkerClusterGroup(options);
	}-*/;
	
	public static native void addLayer(Marker marker) 
	/*-{
		this.addLayer(marker)
	}-*/;

}
