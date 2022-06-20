package ro.rcsrds.tokentest.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import ro.rcsrds.tokentest.model.UiBasket
import ro.rcsrds.tokentest.model.UiProduct
import ro.rcsrds.tokentest.ui.main.repository.MainRepository
import ro.rcsrds.tokentest.ui.other.CallableStates

class SharedActivityViewModel(application: Application): AndroidViewModel(application), LifecycleObserver {

    private val mRepository = MainRepository(this)
    val mProductsList = MutableLiveData(ArrayList<UiProduct>())
    val mProductsBasket = MutableLiveData(ArrayList<UiBasket>())


    var mGeneralErrorMessage = Throwable()
    val mFlagGetProducts = MutableLiveData(CallableStates.FLOW_NOT_STARTED)
    val mFlagUpdateBasket = MutableLiveData(CallableStates.FLOW_NOT_STARTED)
    val mFlagUpdater = MutableLiveData(CallableStates.FLOW_NOT_STARTED)

    fun getProductsData() {
        mRepository.getProductsData()
    }

    fun addProductToBasket(nUiBasket: UiBasket) {
        mRepository.addProductsInBasket(nUiBasket)
    }
}