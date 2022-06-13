package ro.rcsrds.tokentest.ui.main

import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationView
import ro.rcsrds.tokentest.databinding.ActivityMainBinding
import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.navigation.Navigation
import ro.rcsrds.tokentest.R
import ro.rcsrds.tokentest.model.UiBasket
import ro.rcsrds.tokentest.tools.interfaces.ButtonActionsInterface
import ro.rcsrds.tokentest.tools.interfaces.ProductSelectInterface
import ro.rcsrds.tokentest.ui.other.CallableStates



open class MainActivityBase: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    ProductSelectInterface, ButtonActionsInterface {

    lateinit var mBinding: ActivityMainBinding
    lateinit var mViewModel: SharedActivityViewModel

    fun setupDataBindingAndVM() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = ViewModelProvider(this)[SharedActivityViewModel::class.java]
        lifecycle.addObserver(mViewModel)

        with (mBinding) {
            vActivity = this@MainActivityBase as MainActivity
            vViewModel = mViewModel
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

    override fun onExitTap() {
        finishAffinity()
    }

    override fun onPaymentTap() {
        mBinding.navHostFragment.bringToFront()

        //TODO: **1 de verificat treaba asta, de ce butonul iese in prim plan
        mBinding.pay.visibility = View.GONE

        Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.payFragment)
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
                    }
                    else -> {}
                }
            }

            mFlagUpdateBasket.observe(this@MainActivityBase) { nFlag ->
                when(nFlag) {
                    CallableStates.SUCCESS -> {
                        // do other actions if this list is needed
                        // notify the data so that the bindingAdapter is called, we can make this in other ways:
                        // 1. get the list in updateBasketSuccess, make the modification on that list and then posting it back to the mutableLiveData
                        // 2. we can set a triggerFlag, update it here, and use it as param in bindingAdapter
                        mProductsBasket.postValue(mProductsBasket.value)
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

    fun selectContact() {
        startActivity(Intent(Intent.ACTION_SENDTO)
            .setData(Uri.parse("mailto:contact@tokeninc.com"))
            .putExtra(Intent.EXTRA_SUBJECT, "Your Subject Here")
            .putExtra(Intent.EXTRA_TEXT, "E-mail body"))
    }

    override fun onProductSelected(nUiBasket: UiBasket) {
        mViewModel.addProductToBasket(nUiBasket)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, "on contact", Toast.LENGTH_SHORT).show()
        selectContact()
        return true
    }

    fun setViewsBack() {
        //TODO: **1 de verificat treaba asta
        mBinding.pay.visibility = View.VISIBLE
    }
}