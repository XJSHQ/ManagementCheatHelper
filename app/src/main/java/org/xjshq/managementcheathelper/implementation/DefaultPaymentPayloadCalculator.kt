package org.xjshq.managementcheathelper.implementation

import org.xjshq.managementcheathelper.api.project.PaymentPayloadCalculator
import org.xjshq.managementcheathelper.api.project.Project

class DefaultPaymentPayloadCalculator : PaymentPayloadCalculator {

    override fun calculatePP(project: Project): Double {
        val receiptsCount = project.receipts.size
        var investment = project.investment

        if (project.isReceiptsPermanent()) {
            return investment / receiptsCount
        } else {

            var receipts = project.receipts.takeWhile {
                (investment - it > 0).apply {
                    if (this) investment -= it
                }
            }

            if (receipts.size < project.receipts.size) {
                return receipts.size + investment / project.receipts[receipts.size]
            } else {
                return  receipts.size.toDouble()
            }
        }
    }

    override fun calculateDPP(project: Project): Double {
        var t = 0
        return project.receipts.sumByDouble {
            t++
            it / Math.pow(1.0 + project.interestRate, t.toDouble())
        }
    }



}