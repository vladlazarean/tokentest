package ro.rcsrds.tokentest.tools.interfaces

interface ButtonActionsInterface {
    fun onExitTap()
    fun onPaymentTap()

    fun onCashPaymentTap()
    fun onCardPaymentTap()
    fun onCancelPaymentTap()
}