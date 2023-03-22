package it.ivandisiro.portfolio

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import it.ivandisiro.portfolio.data.Data
import it.ivandisiro.portfolio.model.Me
import it.ivandisiro.portfolio.networking.Networking
import it.ivandisiro.portfolio.networking.callback.ProfileCallback
import it.ivandisiro.portfolio.ui.main.pager.MyViewPagerAdapter

class MainActivity : AppCompatActivity() {

    lateinit var activity: AppCompatActivity;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;

        Networking().getProfile(object : ProfileCallback {
            override fun onSuccess(profileData: Me?) {
                if (profileData != null) {
                    Data.me = profileData;
                    var viewPager:ViewPager = findViewById(R.id.pager)
                    viewPager.adapter = MyViewPagerAdapter(activity, supportFragmentManager);
                } else {
                    Toast.makeText(activity, getString(R.string.neterr), Toast.LENGTH_LONG).show();
                }
            }

            override fun onError(code: Int, exception: Throwable?) {
                Toast.makeText(activity, getString(R.string.neterr), Toast.LENGTH_LONG).show();
            }
        })
    }
}