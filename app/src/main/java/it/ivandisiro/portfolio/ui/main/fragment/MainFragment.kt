package it.ivandisiro.portfolio.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import it.ivandisiro.portfolio.R
import it.ivandisiro.portfolio.model.Me
import it.ivandisiro.portfolio.databinding.FragmentMainBinding;
import it.ivandisiro.portfolio.repository.ProfileRepository
import it.ivandisiro.portfolio.ui.main.viewmodel.Factory
import it.ivandisiro.portfolio.ui.main.viewmodel.MainViewModel


class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment();
    }

    private lateinit var binding: FragmentMainBinding ;
    private lateinit var vm: MainViewModel;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        vm = Factory(requireActivity().application).create(MainViewModel::class.java);
        ProfileRepository.me.observe(viewLifecycleOwner, Observer<Me?> { meOb: Me? ->
            if (meOb != null) vm.setMe(meOb);
        });
        binding.viewModel = vm;
        binding.executePendingBindings();

        return binding.root;
    }


}