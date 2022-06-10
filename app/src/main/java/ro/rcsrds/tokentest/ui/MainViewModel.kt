package ro.rcsrds.tokentest.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import ro.rcsrds.tokentest.model.UiProduct
import ro.rcsrds.tokentest.repository.MainRepository

class MainViewModel(application: Application): AndroidViewModel(application), LifecycleObserver {

    private val mRepository = MainRepository(this)
    val mProductsList = MutableLiveData(ArrayList<UiProduct>())
    val mProductsBasket = MutableLiveData(ArrayList<UiProduct>())

    fun getProductsData() {
        mRepository.getProductsData()
    }

    fun addProductToBasket(nUiProduct: UiProduct) {
        mProductsBasket.value?.add(nUiProduct)
    }

}