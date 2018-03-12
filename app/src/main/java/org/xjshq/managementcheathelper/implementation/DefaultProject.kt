package org.xjshq.managementcheathelper.implementation

import org.xjshq.managementcheathelper.api.calculateNPV
import org.xjshq.managementcheathelper.api.project.PaymentPayloadCalculator
import org.xjshq.managementcheathelper.api.project.Project

data class DefaultProject(
        override var investment: Double,
        override var receipts: MutableList<Double>,
        override var interestRate: Double,
        private val calculator: PaymentPayloadCalculator = DefaultPaymentPayloadCalculator()
) : Project {

    @Throws(IllegalStateException::class)
    override fun calculateIRR(): Double {
        val currentNPV = calculateNPV()

        if (currentNPV < 0) {
            throw IllegalStateException("NPV is already less then zero.")
        }

        var newInterestRate = interestRate + 0.01
        var newNPV = calculateNPV(receipts, newInterestRate, investment)
        val isGrowing = currentNPV < newNPV

        while (currentNPV * newNPV >= 0) {
            newInterestRate += 0.01 * when (isGrowing) {
                true -> -1
                else -> 1
            }
            newNPV = calculateNPV(receipts, newInterestRate, investment)
        }

        return interestRate + currentNPV * (newInterestRate - interestRate) / (currentNPV - newNPV)
    }

    override fun calculatePP() = calculator.calculatePP(this)

    override fun calculateDPP() = calculator.calculateDPP(this)
}