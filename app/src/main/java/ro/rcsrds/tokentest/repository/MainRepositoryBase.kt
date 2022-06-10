package ro.rcsrds.tokentest.repository

import kotlinx.coroutines.CoroutineExceptionHandler
import ro.rcsrds.tokentest.model.UiProduct
import ro.rcsrds.tokentest.ui.MainViewModel

open class MainRepositoryBase(protected val mViewModel: MainViewModel) {

    protected val mRepositoryLocal = MainRepositoryLocal()

    protected fun onProductsListSuccess(nProductsListData: ArrayList<UiProduct>) {
        mViewModel.mProductsList.postValue(nProductsListData)
    }

    protected val errorGetProducts = CoroutineExceptionHandler { _, nException ->
        with(mViewModel) {
            //mGeneralErrorMessage = nException
            //mFlagGetProducts.postValue(CallableStates.ERROR)
        }
    }

}