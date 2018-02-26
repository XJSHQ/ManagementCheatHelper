package org.xjshq.managementcheathelper.api

/**
 *
 * Current method provides calculating of second parameter
 * using linear interpolation equation.
 *
 * @param x - required attribute;
 * </p>
 * @param lbound - the dot which is locate
 * in left of current x;
 * </p>
 * @param rbound - the dot which is locate
 * in right of current x;
 * </p>
 * @return value of function in x.
 * </p>
 * @see calculateY for more information
 */
fun calculateY(x: Double, lbound: Pair<Double, Double>, rbound: Pair<Double, Double>) : Double {
    val (lx, ly) = lbound
    val (rx, ry) = rbound
    return calculateY(x, lx, ly, rx, ry)
}

/**
 *
 * Current method provides calculating of second parameter
 * using linear interpolation equation.
 *
 * @param x - required attribute;
 * </p>
 * @param lx - the x axis value of dot
 * which is locate in left of current x;
 * </p>
 * @param ly - the y axis value of dot
 * which is locate in left of current x;
 * </p>
 * @param rx - the x axis value of dot
 * which is locate in right of current x;
 * </p>
 * @param ry - the y axis value of dot
 * which is locate in right of current x;
 * </p>
 */
fun calculateY(x: Double, lx: Double, ly: Double, rx: Double, ry: Double) = lx + (x - lx) / (x - rx) * (ry - ly);