package org.vaadin.addon.leaflet.markercluster.shared;

import com.vaadin.shared.communication.ServerRpc;

/**
 * RPC fired on cluster click
 */
public interface MarkerClusterClickRpc extends ServerRpc {

    /**
     * @param json geoJson encoded list of markers
     */
    void onClusterClick(String json);
}
