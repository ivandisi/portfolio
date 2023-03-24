package it.ivandisiro.portfolio.ui.main.viewmodel

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import it.ivandisiro.portfolio.BR
import it.ivandisiro.portfolio.model.Skill

class SkillsViewModel: BaseObservable() {

    val skillList = MutableLiveData<List<Skill>>();
    var skillListEmpty: Boolean = true;

    fun setAllSkills(skills: List<Skill>) {
        this.skillListEmpty = skills.isNotEmpty();
        this.skillList.postValue(skills)
        notifyPropertyChanged(BR.stateDataListEmpty);
    }

    @Bindable
    fun getStateDataListEmpty(): Int {
        return if(this.skillListEmpty) View.GONE else View.VISIBLE;
    }
}