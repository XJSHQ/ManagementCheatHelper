package org.xjshq.managementcheathelper.api.experts

/**
 * Current interface provides solving of
 * expert evaluation task, which was described
 * on laboratorium work.
 *
 * @see ExpertTaskSolver.calculateCF
 * @see ExpertTaskSolver.calculateECF
 * @see ExpertTaskSolver.calculateENPV
 */
interface ExpertTaskSolver {

    /**
     * Current interface is used to fill experts evaluation
     * with required values.
     */
    fun setupExperts(vararg probabilities: Double) = probabilities.forEach {
        val probability = it
        priorityExperts.forEach {
            it.second.probabilityEvaluation += Pair(probability, mutableListOf())
        }
    }

    /**
     * Current methods provides storing the
     * required expert, his evaluation of project
     * as value
     * and expert`s value of reliability stored
     * as key.
     */
    var priorityExperts: List<Pair<Double, Expert>>

    /**
     * Calculates CF_i(P)
     */
    fun calculateCF(): Map<Double, List<Double>>

    /**
     * Calculates ECF for each CF_i
     */
    fun calculateECF(): List<Double>

    fun calculateENPV(): Double

    /**
     * Checks that sum of probabilities equal 1.0
     */
    fun isDataAppropriate() = priorityExperts.map { it.first }.sum() == 1.0
}