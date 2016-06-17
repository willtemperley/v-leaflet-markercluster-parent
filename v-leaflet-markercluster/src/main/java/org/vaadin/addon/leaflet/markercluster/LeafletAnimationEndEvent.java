package org.vaadin.addon.leaflet.markercluster;

import com.vaadin.event.ConnectorEvent;
import com.vaadin.server.ClientConnector;

public class LeafletAnimationEndEvent extends ConnectorEvent {

    public LeafletAnimationEndEvent(ClientConnector source) {
        super(source);
    }

}
