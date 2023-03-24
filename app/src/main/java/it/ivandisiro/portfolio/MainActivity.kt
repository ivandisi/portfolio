package it.ivandisiro.portfolio

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import it.ivandisiro.portfolio.model.Me
import it.ivandisiro.portfolio.networking.Networking
import it.ivandisiro.portfolio.networking.callback.ProfileCallback
import it.ivandisiro.portfolio.repository.ProfileRepository
import it.ivandisiro.portfolio.room.RoomDatabaseSingleton
import it.ivandisiro.portfolio.ui.main.pager.MyViewPagerAdapter
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    lateinit var activity: AppCompatActivity;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        RoomDatabaseSingleton.initDB(this);

        runBlocking {
            ProfileRepository.initData();
            getData();
        }

        setContentView(R.layout.activity_main);
        activity = this;
        var viewPager:ViewPager = findViewById(R.id.pager)
        viewPager.adapter = MyViewPagerAdapter(activity, supportFragmentManager);

        val connectivityManager = getSystemService(ConnectivityManager::class.java) as ConnectivityManager
        connectivityManager.requestNetwork(this.generateRequest(), networkCallback)
        
    }

    suspend fun getData() = coroutineScope {
        launch {
            ProfileRepository.refreshProfile();
        }
    }

    fun generateRequest(): NetworkRequest {
        return NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()
    }

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            runBlocking {
                getData();
            }
        }
    }
}