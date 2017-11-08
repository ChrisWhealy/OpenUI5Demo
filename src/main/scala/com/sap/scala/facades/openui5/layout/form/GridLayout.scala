
package com.sap.scala.facades.openui5.layout.form

import com.sap.scala.facades.openui5.base._


import scala.scalajs.js
import scala.scalajs.js.{Array, |}
import scala.scalajs.js.annotation.{ScalaJSDefined, JSGlobal}

@JSGlobal("sap.ui.layout.form.GridLayout")
@js.native
class GridLayout() extends FormLayout {
//  def extend(sClassName: String, oClassInfo: Object, FNMetaImpl: js.Function1[Event[EventProps], Unit]): js.Function1[Event[EventProps], Unit] = js.native
//  def getMetadata(): Metadata = js.native
  def getSingleColumn(): Boolean = js.native
  def setSingleColumn(bSingleColumn: Boolean): this.type = js.native
}
     