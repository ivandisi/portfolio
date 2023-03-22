package it.ivandisiro.portfolio.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import it.ivandisiro.portfolio.R
import it.ivandisiro.portfolio.data.Data
import it.ivandisiro.portfolio.databinding.FragmentSkillsBinding;
import it.ivandisiro.portfolio.ui.main.adapter.SkillAdapter
import it.ivandisiro.portfolio.ui.main.viewmodel.SkillsViewModel


class SkillsFragment : Fragment() {

    companion object {
        fun newInstance() = SkillsFragment();
    }

    private lateinit var binding: FragmentSkillsBinding ;
    private lateinit var vm: SkillsViewModel;
    private var adapter = SkillAdapter();

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_skills, container, false);
        vm = SkillsViewModel();
        binding.recyclerview.adapter = adapter
        vm.skillList.observe( viewLifecycleOwner, Observer {
            adapter.setSkillsList(it);
        })
        vm.setAllSkills(Data.me.skills);
        return binding.root;
    }
}