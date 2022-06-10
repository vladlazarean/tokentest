package ro.rcsrds.tokentest.tools.interfaces

import ro.rcsrds.tokentest.model.UiProduct

interface ProductSelectInterface {
    fun onProductSelected(nUiProduct: UiProduct)
}