package org.xjshq.managementcheathelper.api.project

interface PaymentPayloadCalculator {

    fun calculatePP(project: Project) : Double

    fun calculateDPP(project: Project) : Double
}