package org.carbonateresearch.test

import org.carbonateresearch.conus.util.StepFunctionUtils.Step

import org.carbonateresearch.conus.equations.CalculateStepValue

case class ApplyStepFunction[T](equation:Step=>T){

  def storeResultAs(saveLabel:ModelVariable[T]): SingleCalculationDescription[T] = SingleCalculationDescription(equation,saveLabel)
}


