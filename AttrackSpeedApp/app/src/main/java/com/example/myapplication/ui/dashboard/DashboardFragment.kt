package com.example.myapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment
import android.preference.PreferenceManager
import com.example.myapplication.BuildConfig
import com.example.myapplication.databinding.FragmentDashboardBinding
import org.osmdroid.api.IMapController
import com.example.myapplication.R
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        // on défini la vue de la page
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        // on configure la page
        val ctx = activity!!.applicationContext
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        Configuration.getInstance().userAgentValue = BuildConfig.APPLICATION_ID;

        // on défini les principaux parametres de la map
        val map = view.findViewById<MapView>(R.id.mapview)
        map.setUseDataConnection(true)
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setMultiTouchControls(true)
        val mapController: IMapController = map.controller

        // on configure le zoom de la map (mapController.zoomTo(14, 1))
        mapController.setZoom(5)

        // on récupère notre localisation
        val mGpsMyLocationProvider = GpsMyLocationProvider(requireContext())
        val mLocationOverlay = MyLocationNewOverlay(mGpsMyLocationProvider, map)
        mLocationOverlay.enableMyLocation()
        mLocationOverlay.enableFollowLocation()
        mLocationOverlay.runOnFirstFix {
            map.overlays.add(mLocationOverlay)
            mapController.animateTo(mLocationOverlay.myLocation)
        }

        // Création d'un marqueur au coordonnées de l'IUT
        val markerIUT = Marker(map)
        markerIUT.position = GeoPoint(49.109584, 6.181)
        markerIUT.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        markerIUT.title = "IUT de Metz"
        markerIUT.snippet = "Premier test de marqueur"
        map.overlays.add(markerIUT)

        // Création d'un marqueur au coordonnées de Walygator
        val markerWaly = Marker(map)
        markerWaly.position = GeoPoint(49.2258744, 6.1552788)
        markerWaly.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        markerWaly.title = "Walygator"
        markerWaly.snippet = "Parc d'attraction"
        map.overlays.add(markerWaly)

        // Création d'un marqueur au coordonnées de Europa-park
        val markerEuro = Marker(map)
        markerEuro.position = GeoPoint(48.266354, 7.722883)
        markerEuro.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        markerEuro.title = "Europa-park"
        markerEuro.snippet = "Parc d'attraction"
        map.overlays.add(markerEuro)

        // Création d'un marqueur au coordonnées de Disneyland Paris
        val markerDisney = Marker(map)
        markerDisney.position = GeoPoint(48.872234, 2.775808)
        markerDisney.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        markerDisney.title = "Disneyland Paris"
        markerDisney.snippet = "Parc d'attraction"
        map.overlays.add(markerDisney)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}