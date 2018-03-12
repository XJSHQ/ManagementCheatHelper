package org.xjshq.managementcheathelper.api.project

/**
 * @author Dmitry Sokolov
 */
interface Project {

    /**
     * Represents the value of initial investments
     * of current project (I_0)
     */
    var investment: Double

    /**
     * Represents the list of input receipts of
     * current project per year. (CF_t)
     *
     * Make sure you input it in approopriate way cause
     * the order of receipts matter while calculating
     * DPP, NPV and so on.
     */
    var receipts: MutableList<Double>

    /**
     * Represents the value of an interest rate of
     * current project (i)
     */
    var interestRate: Double

    /**
     * Calculate the NPV of current project. (NPV)
     */
    fun calculateNPV() = calculateDPP() - investment

    /**
     * Calculates PP of current project. (PP)
     */
    fun calculatePP(): Double

    /**
     * Calculates DPP of current project. (DPP)
     */
    fun calculateDPP(): Double

    /**
     * Calculates IRR of current project. (RR)
     * Can produce illegal state exception
     * when NPV of current project is already
     * less then zero
     */
    fun calculateIRR(): Double

    /**
     * Calculates IR of current project. (IR)
     */
    fun calculateIR() = calculateDPP() / investment

    /**
     * Checks whether all receipts of current project
     * is equals to each other (receipt is permanent).
     */
    fun isReceiptsPermanent() = receipts.filter { it == receipts[0] }.size == receipts.size

}