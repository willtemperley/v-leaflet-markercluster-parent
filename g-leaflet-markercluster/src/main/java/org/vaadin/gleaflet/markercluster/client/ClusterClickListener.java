package org.vaadin.gleaflet.markercluster.client;

import org.peimari.gleaflet.client.Layer;
import org.peimari.gleaflet.client.MouseEvent;

public interface ClusterClickListener {

    void onClick(MouseEvent event, MarkerCluster cluster);

}
