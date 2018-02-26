package org.xjshq.managementcheathelper.api

import java.util.Comparator

interface MultyCriteriaProjectComparator {

    fun compareBy(comparator: ProjectComparator)

    fun result() : String

    interface ProjectComparator : Comparator<Project> {

        fun stringResult(result: Int) : String
    }
}