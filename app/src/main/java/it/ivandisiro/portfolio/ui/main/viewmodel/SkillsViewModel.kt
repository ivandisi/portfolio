package it.ivandisiro.portfolio.ui.main.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import it.ivandisiro.portfolio.model.Skill
import java.lang.Exception

class SkillsViewModel: BaseObservable() {

    val skillList = MutableLiveData<List<Skill>>();

    fun setAllSkills(skills: List<Skill>) {
        skillList.postValue(skills)
    }
    
    fun hasDataInList(): Boolean {
        try {
            return skillList.value!!.isNotEmpty();
        } catch (e : Exception) {
            return false;
        }
    }
}