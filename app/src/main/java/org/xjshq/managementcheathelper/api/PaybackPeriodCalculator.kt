package org.xjshq.managementcheathelper.api

/**
 * Current interface is used to calculate the
 * payback period of required project.
 * </p>
 * There are two payback periods you can choose
 * to calculate:
 * <ul>
 *     <li>Default calculate period  (PP)</i>
 *     <li>Discount calculate period (DPP)</i>
 * </ul>
 */
interface PaybackPeriodCalculator {

    /**
     * Current @method is used to calculate PP.
     * @param project - project you want to calculate PP.
     */
    fun calculatePaybackPeriod(project: Project) = 0.0

    /**
     * Current @method is used to calculate DPP.
     * @param project - project you want to calculate DPP.
     */
    fun calculateDiscountPaybackPeriod(project: Project) = 0.0
}