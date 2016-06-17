package org.vaadin.addon.leaflet.markercluster.shared;

import com.vaadin.shared.communication.ServerRpc;

public interface AnimationEndServerRpc extends ServerRpc {

    void onAnimationEnd();
}
