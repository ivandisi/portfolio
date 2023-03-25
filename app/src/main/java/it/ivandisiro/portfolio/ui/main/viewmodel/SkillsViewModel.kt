package it.ivandisiro.portfolio.ui.main.viewmodel

import android.app.Application
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import it.ivandisiro.portfolio.BR
import it.ivandisiro.portfolio.model.Skill
import it.ivandisiro.portfolio.ui.main.viewmodel.support.ObservableViewModel

class SkillsViewModel(app: Application) : ObservableViewModel(app) {

    val skillList = MutableLiveData<List<Skill>>();
    var skillListEmpty: Boolean = true;

    fun setAllSkills(skills: List<Skill>) {
        this.skillListEmpty = skills.isNotEmpty();
        this.skillList.postValue(skills)
        notifyChange();
    }

    @Bindable
    fun getStateDataListEmpty(): Int {
        return if(this.skillListEmpty) View.GONE else View.VISIBLE;
    }
}