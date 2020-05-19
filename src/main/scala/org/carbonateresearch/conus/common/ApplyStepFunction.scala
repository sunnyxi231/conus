package org.carbonateresearch.conus.common

import org.carbonateresearch.conus.common.{CalculationDescription, Step}
import org.carbonateresearch.conus.common.ModelVariable

case class ApplyStepFunction[T](equation:Step=>T){

  def storeResultAs(saveLabel:ModelVariable[T]): CalculationDescription[T] = CalculationDescription(equation,saveLabel)
}
