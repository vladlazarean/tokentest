package ro.rcsrds.tokentest.ui

import android.os.Bundle

class MainActivity : MainActivityBase() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDataBindingAndVM()
        setupMenuDrawer()
    }
}