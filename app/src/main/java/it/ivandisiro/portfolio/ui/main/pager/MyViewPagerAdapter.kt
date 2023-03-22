package it.ivandisiro.portfolio.ui.main.pager

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import it.ivandisiro.portfolio.R
import it.ivandisiro.portfolio.ui.main.fragment.MainFragment
import it.ivandisiro.portfolio.ui.main.fragment.SkillsFragment

class MyViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    lateinit var context: Activity;

    constructor (context: Activity, fragmentManager: FragmentManager) : this(fragmentManager) {
        this.context = context;
    }

    override fun getCount(): Int  = 2

    override fun getItem(i: Int): Fragment {
        return when (i) {
            0 -> MainFragment();
            1 -> SkillsFragment();
            else -> MainFragment();
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position){
            0 -> context.getString(R.string.main_fragment);
            1 -> context.getString(R.string.skills_fragment);
            else -> context.getString(R.string.main_fragment);
        }
    }
}