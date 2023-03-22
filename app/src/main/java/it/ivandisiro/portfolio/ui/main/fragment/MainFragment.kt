package it.ivandisiro.portfolio.ui.main.fragment

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import it.ivandisiro.portfolio.R
import it.ivandisiro.portfolio.data.Data
import it.ivandisiro.portfolio.model.Me
import it.ivandisiro.portfolio.databinding.FragmentMainBinding;
import it.ivandisiro.portfolio.networking.Networking
import it.ivandisiro.portfolio.networking.callback.ProfileCallback
import it.ivandisiro.portfolio.ui.main.viewmodel.MainViewModel


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment();
    }

    private lateinit var binding: FragmentMainBinding ;
    private lateinit var vm: MainViewModel;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        vm = MainViewModel();
        vm.setMe(Data.me);
        binding.viewModel = vm;
        binding.executePendingBindings();

        return binding.root;
    }


}