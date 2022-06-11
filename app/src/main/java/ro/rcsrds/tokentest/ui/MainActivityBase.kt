package ro.rcsrds.tokentest.ui

import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationView
import ro.rcsrds.tokentest.databinding.ActivityMainBinding
import android.content.Intent
import android.net.Uri

import android.view.Menu
import ro.rcsrds.tokentest.R
import ro.rcsrds.tokentest.model.UiBasket
import ro.rcsrds.tokentest.model.UiProduct
import ro.rcsrds.tokentest.tools.interfaces.ProductSelectInterface
import ro.rcsrds.tokentest.ui.other.CallableStates


open class MainActivityBase: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, ProductSelectInterface {

    lateinit var mBinding: ActivityMainBinding
    lateinit var mViewModel: MainViewModel

    fun setupDataBindingAndVM() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        lifecycle.addObserver(mViewModel)

        with (mBinding) {
            vActivity = this@MainActivityBase as MainActivity
            vViewModel = mViewModel
            lifecycleOwner = this@MainActivityBase
            executePendingBindings()
        }

        mViewModel.getProductsData()
    }

    fun setupMenuDrawer() {
        mBinding.navView.setNavigationItemSelectedListener(this)
        mBinding.navView.bringToFront()

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
                    }

                    CallableStates.ERROR -> {
                        // show dialog or send error to crashlytics or other catchers
                    }
                    else -> {}
                }
            }
        }
    }

    fun selectPayment() {

    }

    fun selectBack() {
        super.onBackPressed()
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


}