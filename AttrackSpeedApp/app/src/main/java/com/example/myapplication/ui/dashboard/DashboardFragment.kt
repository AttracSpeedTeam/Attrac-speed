package com.example.myapplication.ui.dashboard

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment
import android.preference.PreferenceManager
import android.widget.TextView
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
        mapController.setZoom(18)

        // on récupère notre localisation
        val mGpsMyLocationProvider = GpsMyLocationProvider(requireContext())
        val mLocationOverlay = MyLocationNewOverlay(mGpsMyLocationProvider, map)
        mLocationOverlay.enableMyLocation()
        mLocationOverlay.enableFollowLocation()
        mLocationOverlay.runOnFirstFix {
            map.overlays.add(mLocationOverlay)
            mapController.animateTo(mLocationOverlay.myLocation)
        }

        val startPoint = GeoPoint(48.870601, 2.779272)

        mapController.setCenter(startPoint)

        // Création d'un marqueur au coordonnées de l'utilisateur
        val marker = Marker(map)
        marker.position = startPoint
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker.title = "Vous êtes ici"
        marker.icon = resources.getDrawable(R.drawable.personne)
        map.overlays.add(marker)

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

        val marker2 = Marker(map)
        marker2.position = GeoPoint(48.87350796980345, 2.773361923733266)
        marker2.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker2.title = "Pirates of the Caribbean"
        marker2.snippet = "attraction"
        map.overlays.add(marker2)

        val marker3 = Marker(map)
        marker3.position = GeoPoint(48.874640198713415, 2.7787671408728443)
        marker3.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker3.title = "Stars Tours"
        marker3.snippet = "attraction"
        map.overlays.add(marker3)

        val marker4 = Marker(map)
        marker4.position = GeoPoint(48.87055478922558, 2.7768818822670074)
        marker4.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker4.title = "Phantom Manor"
        marker4.snippet = "attraction"
        map.overlays.add(marker4)

        val marker5 = Marker(map)
        marker5.position = GeoPoint(48.87148658141752, 2.7745565811849127)
        marker5.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker5.title = "Big Thunder Mountain"
        marker5.snippet = "attraction"
        map.overlays.add(marker5)

        val marker6 = Marker(map)
        marker6.position = GeoPoint(48.87385325706409, 2.774057660524966)
        marker6.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker6.title = "Peter Pan's Flight"
        marker6.snippet = "attraction"
        map.overlays.add(marker6)

        val marker7 = Marker(map)
        marker7.position = GeoPoint(48.87343665768157, 2.7779261226809795)
        marker7.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker7.title = "Buzz Lightyear Laser Blast"
        marker7.snippet = "attraction"
        map.overlays.add(marker7)

        val marker1 = Marker(map)
        marker1.position = GeoPoint(48.87374320146056, 2.7753337431335074)
        marker1.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker1.title = "Le Carrousel de Lancelot"
        marker1.snippet = "attraction"
        map.overlays.add(marker1)

        //********************************************************//
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}