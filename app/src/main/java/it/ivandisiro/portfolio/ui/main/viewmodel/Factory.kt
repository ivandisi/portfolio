package it.ivandisiro.portfolio.ui.main.viewmodel

import androidx.databinding.BaseObservable

class Factory {
    fun <T : BaseObservable?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel() as T;
        } else if (modelClass.isAssignableFrom(SkillsViewModel::class.java)) {
            return SkillsViewModel() as T;
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}
