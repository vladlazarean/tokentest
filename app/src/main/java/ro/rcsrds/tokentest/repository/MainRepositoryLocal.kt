package ro.rcsrds.tokentest.repository

import ro.rcsrds.tokentest.R
import ro.rcsrds.tokentest.model.UiProduct

class MainRepositoryLocal {

    fun getProductsList() : ArrayList<UiProduct> {
        val mCountTemp = mImages.size
        val mProductsListTemp = arrayListOf<UiProduct>()

        repeat(mCountTemp) {
            mProductsListTemp.add(UiProduct(mImage = mImages[it], mTitle = mTitles[it], mPrice = mPrices[it]))
        }

        return mProductsListTemp
    }


    private val mImages = arrayOf(
        R.drawable.olive,
        R.drawable.bread,
        R.drawable.milk,
        R.drawable.coffee,
        R.drawable.tea,
        R.drawable.detergent,
        R.drawable.shampoo,
        R.drawable.cocacola,
        R.drawable.apples,
        R.drawable.tomatoes
    )

    private val mTitles = arrayOf(
        "Olive oil",
        "Bread",
        "Milk",
        "Coffee",
        "Tea",
        "Detergent",
        "Shampoo",
        "Coca-Cola",
        "Apples",
        "Tomatoes"
    )


    private val mPrices = arrayOf(
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10
    )

}