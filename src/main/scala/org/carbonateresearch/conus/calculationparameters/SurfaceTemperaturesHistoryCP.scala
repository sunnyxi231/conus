package org.carbonateresearch.conus.calculationparameters

import spire.math.{Number, Numeric}
import spire.implicits._
import org.carbonateresearch.conus.calculationparameters.parametersIO.{CalculationParametersIOLabels, StandardsIOLabels}

final case class SurfaceTemperaturesHistoryCP (SurfaceTemperatureAgeMap:List[(Number, Number)]) extends CalculationParameters with StandardsIOLabels {

  override def calculate (step:Number,previousResults:Map[Number,Map[CalculationParametersIOLabels,Number]]): Map[Number,Map[CalculationParametersIOLabels ,Number]]  = {

    InterpolatorCP(inputValueLabel = Age, outputValueLabel = SurfaceTemperature, xyList = SurfaceTemperatureAgeMap).calculate(step,previousResults)

  }

}
