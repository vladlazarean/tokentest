package ro.rcsrds.tokentest.ui.main.repository

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ro.rcsrds.tokentest.model.UiBasket
import ro.rcsrds.tokentest.ui.main.SharedActivityViewModel

class MainRepository(mViewModel: SharedActivityViewModel): MainRepositoryBase(mViewModel) {

    fun getProductsData() {
        mViewModel.viewModelScope.launch(errorGetProducts) {
            withContext(Dispatchers.IO) {
                onProductsListSuccess(mRepositoryLocal.getProductsList())
            }
        }
    }

    fun addProductsInBasket(nUiProduct: UiBasket) {
        mViewModel.viewModelScope.launch(errorUpdateBasket) {
            withContext(Dispatchers.IO) {
                updateBasketSuccess(nUiProduct)
            }
        }
    }

}