package org.vaadin.addon.leaflet.markercluster;

import com.vaadin.util.ReflectTools;

import java.lang.reflect.Method;

public interface LeafletAnimationEndListener {

    static final Method METHOD = ReflectTools.findMethod(LeafletAnimationEndListener.class, "onAnimationEnd", LeafletAnimationEndEvent.class);

    void onAnimationEnd(LeafletAnimationEndEvent event);
}
