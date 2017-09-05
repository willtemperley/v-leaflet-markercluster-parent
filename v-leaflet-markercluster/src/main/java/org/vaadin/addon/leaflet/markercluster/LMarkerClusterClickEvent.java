package org.vaadin.addon.leaflet.markercluster;

import com.vaadin.event.ConnectorEvent;
import com.vaadin.server.ClientConnector;

public class LMarkerClusterClickEvent extends ConnectorEvent {
    private final String json;

    /**
     * Creates a new event fired by the given source.
     *
     * @param source the source connector
     * @param json the geoJson encoded cluster
     */
    public LMarkerClusterClickEvent(ClientConnector source, String json) {
        super(source);
        this.json = json;
    }

    public String getJson() {
        return json;
    }
}
