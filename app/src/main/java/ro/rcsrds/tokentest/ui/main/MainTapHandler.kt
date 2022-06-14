package ro.rcsrds.tokentest.ui.main

import android.content.Intent
import android.net.Uri
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.google.android.material.navigation.NavigationView
import ro.rcsrds.tokentest.R
import ro.rcsrds.tokentest.tools.interfaces.ButtonActionsInterface

open class MainTapHandler:  AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    ButtonActionsInterface {

    override fun onExitTap() {
        finishAffinity()
    }

    override fun onPaymentTap() {
        Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.payFragment)
    }

    override fun onCashPaymentTap() {
        // TODO: onCASHPayment
        Toast.makeText(this, "on Cash Payment selected", Toast.LENGTH_LONG).show()
    }

    override fun onCardPaymentTap() {
        // TODO: onCARDPayment
        Toast.makeText(this, "on Card Payment selected", Toast.LENGTH_LONG).show()
    }

    override fun onCancelPaymentTap() {
        // TODO: onCANCELPayment
        Toast.makeText(this, "on Cancel selected", Toast.LENGTH_LONG).show()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, "on contact", Toast.LENGTH_SHORT).show()
        selectContact()
        return true
    }

    fun selectContact() {
        startActivity(
            Intent(Intent.ACTION_SENDTO)
            .setData(Uri.parse("mailto:contact@tokeninc.com"))
            .putExtra(Intent.EXTRA_SUBJECT, "Your Subject Here")
            .putExtra(Intent.EXTRA_TEXT, "E-mail body"))
    }

}