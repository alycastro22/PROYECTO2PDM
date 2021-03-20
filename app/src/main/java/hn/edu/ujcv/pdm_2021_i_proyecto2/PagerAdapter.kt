package hn.edu.ujcv.pdm_2021_i_proyecto2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter (fm: FragmentManager, private var tabcount:Int ) :
    FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){




    override fun getCount(): Int {
        return tabcount
    }

    override fun getItem(position: Int): Fragment {
        TODO("Not yet implemented")
    }
}