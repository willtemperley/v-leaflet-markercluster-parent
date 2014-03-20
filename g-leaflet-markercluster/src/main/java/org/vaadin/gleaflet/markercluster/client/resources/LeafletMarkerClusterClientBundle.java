package org.vaadin.gleaflet.markercluster.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.TextResource;

/**
 * @author Will Temperley
 */
public interface LeafletMarkerClusterClientBundle extends ClientBundle {
 
    @Source("leaflet.markercluster.js")
    @DoNotEmbed
    TextResource clusterScript();

    @Source("MarkerCluster.css")
    @CssResource.NotStrict
    CssResource css();

    @Source("MarkerCluster.Default.css")
    @CssResource.NotStrict
    CssResource defaultCss();

}
