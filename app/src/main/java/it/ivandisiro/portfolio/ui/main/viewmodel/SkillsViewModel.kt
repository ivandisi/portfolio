package it.ivandisiro.portfolio.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import it.ivandisiro.portfolio.model.Skill

class SkillsViewModel: ViewModel() {

    val skillList = MutableLiveData<List<Skill>>();

    fun setAllSkills(skills: List<Skill>) {
        skillList.postValue(skills)
    }

}