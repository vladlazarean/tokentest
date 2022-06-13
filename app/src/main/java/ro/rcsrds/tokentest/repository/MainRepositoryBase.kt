package ro.rcsrds.tokentest.repository

import kotlinx.coroutines.CoroutineExceptionHandler
import ro.rcsrds.tokentest.model.UiBasket
import ro.rcsrds.tokentest.model.UiProduct
import ro.rcsrds.tokentest.ui.main.SharedActivityViewModel
import ro.rcsrds.tokentest.ui.other.CallableStates

open class MainRepositoryBase(protected val mViewModel: SharedActivityViewModel) {

    protected val mRepositoryLocal = MainRepositoryLocal()

    protected fun onProductsListSuccess(nProductsListData: ArrayList<UiProduct>) {
        mViewModel.mProductsList.postValue(nProductsListData)
        mViewModel.mFlagGetProducts.postValue(CallableStates.SUCCESS)
    }

    protected fun updateBasketSuccess(nUiBasket: UiBasket) {
        var mTempExistingProduct = false

        mViewModel.mProductsBasket.value?.let {
            it.find { it.mUiProduct == nUiBasket.mUiProduct }?.let { mUiBasket ->
                mUiBasket.mQuantity += nUiBasket.mQuantity
                mTempExistingProduct = true
            }

            if (!mTempExistingProduct) {
                it.add(nUiBasket)
            }
        }

        mViewModel.mFlagUpdateBasket.postValue(CallableStates.SUCCESS)
    }

    protected val errorGetProducts = CoroutineExceptionHandler { _, nException ->
        with(mViewModel) {
            mGeneralErrorMessage = nException
            mFlagGetProducts.postValue(CallableStates.ERROR)
        }
    }

    protected val errorUpdateBasket = CoroutineExceptionHandler { _, nException ->
        with(mViewModel) {
            mGeneralErrorMessage = nException
            mFlagUpdateBasket.postValue(CallableStates.ERROR)
        }
    }

}