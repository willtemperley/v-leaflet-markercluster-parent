package org.vaadin.addon.leaflet.markercluster;

import com.vaadin.util.ReflectTools;

import java.lang.reflect.Method;

public interface MarkerClusterClickListener {

    Method METHOD = ReflectTools.findMethod(MarkerClusterClickListener.class, "onClusterClick", LMarkerClusterClickEvent.class);

    void onClusterClick(LMarkerClusterClickEvent markerClusterClickEvent);
}
