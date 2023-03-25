@file:Suppress("UNCHECKED_CAST")

package it.ivandisiro.portfolio.ui.main.viewmodel

import android.app.Application
import it.ivandisiro.portfolio.ui.main.viewmodel.support.ObservableViewModel

class Factory(app: Application) {

    var app: Application;

    init {
        this.app = app;
    }
    
    fun <T : ObservableViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(this.app) as T;
        } else if (modelClass.isAssignableFrom(SkillsViewModel::class.java)) {
            return SkillsViewModel(app) as T;
        }
        throw IllegalArgumentException("Unable to construct viewmodel");
    }
}
