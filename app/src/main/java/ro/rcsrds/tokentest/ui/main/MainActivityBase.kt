package ro.rcsrds.tokentest.ui.main


import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import ro.rcsrds.tokentest.databinding.ActivityMainBinding
import ro.rcsrds.tokentest.R
import ro.rcsrds.tokentest.model.UiBasket
import ro.rcsrds.tokentest.tools.interfaces.ProductSelectInterface
import ro.rcsrds.tokentest.ui.other.CallableStates

open class MainActivityBase: MainTapHandler(), ProductSelectInterface {

    lateinit var mBinding: ActivityMainBinding
    lateinit var mViewModel: SharedActivityViewModel

    fun setupDataBindingAndVM() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = ViewModelProvider(this)[SharedActivityViewModel::class.java]
        lifecycle.addObserver(mViewModel)

        with (mBinding) {
            vTapInterface = this@MainActivityBase

            lifecycleOwner = this@MainActivityBase
            executePendingBindings()
        }

        mViewModel.getProductsData()
    }

    fun setupMenuDrawer() {
        mBinding.navigation.setNavigationItemSelectedListener(this)
        mBinding.navigation.bringToFront()
    }


    fun setupFlags() {
        with(mViewModel) {
            mFlagGetProducts.observe(this@MainActivityBase) { nFlag ->
                when(nFlag) {
                    CallableStates.SUCCESS -> {
                        // do other actions if this list is needed
                    }

                    CallableStates.ERROR -> {
                        // show dialog or send error to crashlytics or other catchers
                        mViewModel.mGeneralErrorMessage
                    }
                    else -> {}
                }
            }

            mFlagUpdateBasket.observe(this@MainActivityBase) { nFlag ->
                when(nFlag) {
                    CallableStates.SUCCESS -> {
                        mFlagUpdater.postValue(CallableStates.UPDATE_BINDING_ADAPTER)
                    }

                    CallableStates.ERROR -> {
                        // show dialog or send error to crashlytics or other catchers
                    }
                    else -> {}
                }
            }
        }
    }

    fun selectLanguage() {

    }

    override fun onProductSelected(nUiBasket: UiBasket) {
        mViewModel.addProductToBasket(nUiBasket)
    }

}