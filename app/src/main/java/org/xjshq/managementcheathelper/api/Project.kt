package org.xjshq.managementcheathelper.api

/**
 * Current interface represents the instance of
 */
interface Project {

    /**
     * Represents an array of project`s receipts (CF_i).
     */
    var receiptsOfFunds: Array<Double>

    /**
     * Represents an array of project initial .
     */
    var initialInvestment: Double

    var paybackPeriodCalculator: PaybackPeriodCalculator

    /**
     * Current method represents the NPV of
     * current project.
     */
    fun rateOfProfitability() = 0.0

    /**
     * CF_t / (1 + i) ^ t
     * @param receiptsOfFunds - CF_t
     * @param index - t
     */
    fun calculateReceiptDueToPeriod(receiptsOfFunds: Double, index: Int) : Double {
        return receiptsOfFunds / Math.pow(1.0 + rateOfProfitability(), index.toDouble())
    }

    /**
     * Current method provides count of CF_t.
     */
    fun receiptsCount() = receiptsOfFunds.size

    /**
     * Current method provides checking is
     * all receipts are the same.
     */
    fun isReceiptsPermanent() : Boolean {
        receiptsOfFunds.forEach { if (receiptsOfFunds[0] != it) return false }
        return true
    }

    /**
     * Current methods provides checking that
     * rateOfProfitability is positive.
     */
    fun isProjectAppropriate() = rateOfProfitability() > 0.0

    /**
     * Calculates PP.
     * @see PaybackPeriodCalculator.calculatePaybackPeriod
     */
    fun getPaybackPeriod() = paybackPeriodCalculator.calculatePaybackPeriod(this)

    /**
     * Calculates DPP
     * @see PaybackPeriodCalculator.calculateDiscountPaybackPeriod
     */
    fun getDiscountPaybackPeriod() = paybackPeriodCalculator.calculateDiscountPaybackPeriod(this)

}