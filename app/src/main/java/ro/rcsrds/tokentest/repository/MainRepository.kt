package ro.rcsrds.tokentest.repository

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ro.rcsrds.tokentest.ui.MainViewModel

class MainRepository(mViewModel: MainViewModel): MainRepositoryBase(mViewModel) {

    fun getProductsData() {
        mViewModel.viewModelScope.launch(errorGetProducts) {
            withContext(Dispatchers.IO) {
                onProductsListSuccess(mRepositoryLocal.getProductsList())
            }
        }


    }

}