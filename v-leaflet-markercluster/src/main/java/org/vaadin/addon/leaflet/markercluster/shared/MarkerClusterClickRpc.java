package org.vaadin.addon.leaflet.markercluster.shared;

import com.vaadin.shared.communication.ServerRpc;

public interface MarkerClusterClickRpc extends ServerRpc {

    void onClusterClick(String json);
}
