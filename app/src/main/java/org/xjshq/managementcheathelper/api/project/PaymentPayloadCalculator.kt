package org.xjshq.managementcheathelper.api.project

/**
 * @author Dmitry Sokolov
 *
 * Current class is used as helper to calculate
 * the payment`s payloads (PP and DPP).
 *
 * @see DefaultPaymentPayloadCalculator
 * to see default implementation
 * and
 * @see DefaultProject
 * to see default usage.
 */
interface PaymentPayloadCalculator {

    /**
     * Calculates PP of required project.
     */
    fun calculatePP(project: Project): Double

    /**
     * Calculates DPP of required project.
     */
    fun calculateDPP(project: Project): Double
}