package md.work.artspace.fragments.shopping

import androidx.fragment.app.Fragment
import md.work.artspace.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import md.work.artspace.adapters.HomeViewpagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import md.work.artspace.databinding.FragmentHomeBinding
import md.work.artspace.fragments.categories.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragments = arrayListOf(
            AllCategoryFragment(),
            AbstractFragment(),
            NatureFragment(),
            GeometricFragment(),
            MinimalistFragment(),
            SurrealistFragment(),
            PortraitureFragment(),
            StillLifeFragment(),
            PopFragment(),
            TypographyFragment()
        )

        val viewPager2Adapter =
            HomeViewpagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        binding.viewpagerHome.adapter = viewPager2Adapter
        TabLayoutMediator(binding.tabLayout, binding.viewpagerHome) { tab, position ->
            when (position) {
                0 -> tab.text = "All"
                1 -> tab.text = "Abstract"
                2 -> tab.text = "Nature"
                3 -> tab.text = "Geometric"
                4 -> tab.text = "Minimalist"
                5 -> tab.text = "Surrealist"
                6 -> tab.text = "Portraiture"
                7 -> tab.text = "Still Life"
                8 -> tab.text = "Pop"
                9 -> tab.text = "Typography"
            }
        }.attach()
    }
}