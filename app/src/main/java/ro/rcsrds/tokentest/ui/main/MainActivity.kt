package ro.rcsrds.tokentest.ui.main

import android.os.Bundle
import androidx.navigation.ActivityNavigator

class MainActivity : MainActivityBase() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDataBindingAndVM()
        setupMenuDrawer()
        setupFlags()
    }
}