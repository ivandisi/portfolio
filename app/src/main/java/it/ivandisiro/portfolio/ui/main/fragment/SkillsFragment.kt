package it.ivandisiro.portfolio.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import it.ivandisiro.portfolio.R
import it.ivandisiro.portfolio.databinding.FragmentSkillsBinding;
import it.ivandisiro.portfolio.model.Me
import it.ivandisiro.portfolio.repository.ProfileRepository
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
        ProfileRepository.me.observe(viewLifecycleOwner, Observer<Me?> { meOb: Me? ->
            if (meOb != null) vm.setAllSkills(meOb.skills);
        });
        return binding.root;
    }
}