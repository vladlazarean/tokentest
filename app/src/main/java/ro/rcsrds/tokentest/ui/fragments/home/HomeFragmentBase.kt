package ro.rcsrds.tokentest.ui.fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ro.rcsrds.tokentest.R
import ro.rcsrds.tokentest.databinding.FragmentHomeBinding
import ro.rcsrds.tokentest.ui.main.MainActivity
import ro.rcsrds.tokentest.ui.main.SharedActivityViewModel

open class HomeFragmentBase: Fragment() {

    lateinit var mBinding: FragmentHomeBinding
    protected val mViewModel: SharedActivityViewModel by activityViewModels()

    fun setUpDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        with (mBinding) {
            lifecycleOwner = viewLifecycleOwner
            vViewModel = mViewModel
            vActivity = activity as MainActivity
            vTapInterface = activity as MainActivity
            executePendingBindings()
        }

    }
}