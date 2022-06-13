package ro.rcsrds.tokentest.ui.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import ro.rcsrds.tokentest.R
import ro.rcsrds.tokentest.ui.main.MainActivity

class PayFragment: PayFragmentBase() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setUpDataBinding(inflater, container)

        // implementarea de back din fragment
        // TODO: se verificat daca este o modalitate mai buna
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.mainActivity)
            (activity as MainActivity).setViewsBack()
        }

        return mBinding.root
    }


}