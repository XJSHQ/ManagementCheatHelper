package org.xjshq.managementcheathelper.api.project

interface Project {

    var investment: Double

    var receipts: MutableList<Double>

    fun calculateNPV()

    fun calculatePP()

    fun calculateDPP()

    fun isReceiptsPernament() = receipts.filter { it == receipts[0] }.size == receipts.size

}