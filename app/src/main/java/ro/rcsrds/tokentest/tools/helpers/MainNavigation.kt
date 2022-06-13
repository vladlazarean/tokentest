package ro.rcsrds.tokentest.tools.helpers

import androidx.fragment.app.FragmentContainerView
import androidx.navigation.Navigation

class MainNavigation(private val mNavHost : FragmentContainerView) {
    fun goTo(nId: Int) {
        Navigation.findNavController(mNavHost).navigate(nId)
    }
}