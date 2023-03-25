package it.ivandisiro.portfolio.ui.main.viewmodel

import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import it.ivandisiro.portfolio.BR
import it.ivandisiro.portfolio.model.Me
import it.ivandisiro.portfolio.ui.main.viewmodel.support.ObservableViewModel


class MainViewModel(app: Application) : ObservableViewModel(app) {
    private var me: Me;

    init {
        this.me = Me();
    }

    fun setMe(me: Me){
        this.me = me;
        notifyChange();
    }

    @Bindable
    fun getAboutMe(): String{
        return this.me.aboutMe;
    }

    @Bindable
    fun getMyName(): String {
        return StringBuilder(this.me.name).append(" ").append(this.me.surname).toString();
    }

   @Bindable
    fun getMyJob(): String {
       return this.me.job;
   }

    @Bindable
    fun getMyNationality(): String {
        return this.me.nationality;
    }

    @Bindable
    fun getMyImage(): String {
        return this.me.url;
    }

    fun openLinkedin(view: View) {
        this.openLink(this.me.linkedin, view.context);
    }

    fun openStackOverflow(view: View){
        this.openLink(this.me.stackoverflow, view.context);
    }

    fun openPlaystore(view: View){
        this.openLink(this.me.playstore, view.context);
    }

    fun openGitHub(view: View){
        this.openLink(this.me.github, view.context);
    }

    private fun openLink(url: String, context: Context){
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(context, i, null);
    }

    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, url: String) {
            Glide.with(view.context).load(url).circleCrop().into(view)
        }
    }
}