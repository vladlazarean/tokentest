package ro.rcsrds.tokentest.ui.fragments.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PayFragment: PayFragmentBase() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setUpDataBinding(inflater, container)
        return mBinding.root
    }

}