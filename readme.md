# Leaflet.markercluster wrappers for Vaadin & GWT

This project provides Java APIs for both client (GWT, with "g-" prefix) 
and server (Vaadin, "v-" prefix) side for the popular Leaflet marker cluster add-on:
[Leaflet.markercluster](https://github.com/Leaflet/Leaflet.markercluster)

Realeases can be downloaded form [https://vaadin.com/directory](https://vaadin.com/directory)


During development you might need to have development versions of v-leaflet and g-leaflet, the wrappers for [LeafletJS](http://leafletjs.com)
* Vaadin API for Leaflet: [V-Leaflet](https://github.com/mstahv/v-leaflet)
* The client (GWT) API: [G-Leaflet](https://github.com/mstahv/g-leaflet)

To run the test server with a few example uses of the lib, go to the v-leaflet-markercluster module:

`cd v-leaflet-markercluster`

Then run the following command to start the test server on port 19998:

`mvn -e exec:java -Dexec.mainClass="org.vaadin.addon.leaflet.demoandtestapp.util.TServer" -Dexec.classpathScope=test`

[http://localhost:19998](http://localhost:19998)
