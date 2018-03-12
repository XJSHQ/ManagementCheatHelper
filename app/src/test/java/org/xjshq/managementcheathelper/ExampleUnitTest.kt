package org.xjshq.managementcheathelper

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.xjshq.managementcheathelper.api.project.Project
import org.xjshq.managementcheathelper.implementation.DefaultProject

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    lateinit var project: Project

    @Before
    fun init() {
        project = DefaultProject(
                investment = 20000.0,
                receipts = mutableListOf(10000.0, 8000.0, 7000.0, 6000.0),
                interestRate = 0.15
        )
    }

    @Test
    fun assetReceiptsNotPernament() {
        assertFalse(project.isReceiptsPermanent())
    }

    @Test
    fun assertPPCalculationCorrect() = assertSame( 2.0, project.calculatePP())

    @Test
    fun assertDPPCalculationCorrect() = assertSame( 20246, project.calculateDPP().toInt())

    @Test
    fun assertIRRCalculationCorrect() = assertSame(22.67, project.calculateIRR())
}
