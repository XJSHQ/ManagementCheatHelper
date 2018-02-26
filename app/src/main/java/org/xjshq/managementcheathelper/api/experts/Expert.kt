package org.xjshq.managementcheathelper.api.experts

/**
 * Current class provides expert evaluation of project.
 *
 * @param probabilityEvaluation represents the amount
 * of CF per each probability.
 *
 * The key set of #proprobabilityEvaluation is a declared
 * probability for each CF.
 *
 * The value set of #proprobabilityEvaluation represents
 * the amount of each CF.
 */
data class Expert(
        var probabilityEvaluation: Map<Double, List<Double>> = mutableMapOf()
)