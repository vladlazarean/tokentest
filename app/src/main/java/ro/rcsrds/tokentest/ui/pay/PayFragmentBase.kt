package ro.rcsrds.tokentest.ui.pay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ro.rcsrds.tokentest.R
import ro.rcsrds.tokentest.databinding.FragmentPayBinding
import ro.rcsrds.tokentest.ui.main.SharedActivityViewModel

open class PayFragmentBase: Fragment() {

    lateinit var mBinding: FragmentPayBinding
    protected val mViewModel: SharedActivityViewModel by activityViewModels()

    fun setUpDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_pay, container, false)
        with (mBinding) {
            lifecycleOwner = viewLifecycleOwner
            vViewModel = mViewModel
            executePendingBindings()
        }

    }
}