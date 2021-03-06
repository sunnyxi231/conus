/*
 * Copyright © 2020 by Cédric John.
 *
 * This file is part of CoNuS.
 *
 * CoNuS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * CoNuS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CoNuS. If not, see <http://www.gnu.org/licenses/>.
 */

package org.carbonateresearch.conus.common

import org.carbonateresearch.conus.Simulator
import org.carbonateresearch.conus.calibration.Calibrator


final case class ModelCalculationSpace(models: List[SingleModel] = List(),
                                       modelName:String,
                                       calibrationSets: List[Calibrator] = List()) {

  var resultsList:List[SingleModelResults] = scala.collection.mutable.ListBuffer.empty[SingleModelResults].toList

  def defineCalibration(set:List[Calibrator]) : ModelCalculationSpace = {
    val updatedModels:List[SingleModel] = models.map(m => m.copy(m.ID,m.nbSteps,m.gridGeometry,
      m.calculations,
      m.initialConditions,
      set,
      modelName))

    this.copy(models=updatedModels,calibrationSets=set)
  }

  def defineCalibration(set:Calibrator*) : ModelCalculationSpace = {
    this.defineCalibration(set.toList)
  }

  def size : Int = models.size

  def results:ModelResults = Simulator.getResults(this)

  def save = Simulator.save(this)

  def run = Simulator.evaluate(this)

}


