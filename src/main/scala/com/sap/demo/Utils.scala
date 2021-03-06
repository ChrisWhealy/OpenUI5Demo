package com.sap.demo

import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel("Utils")
object Utils {
  // OpenWeather endpoint details
  def openWeatherMapHost = "openweathermap.org"
  def openWeatherMapAPI  = "https://api." + openWeatherMapHost
  def weatherEndpoint    = openWeatherMapAPI + "/data/2.5/weather"

  def mapBoxHost         = "https://api.tiles.mapbox.com"
  def mapBoxEndpoint     = mapBoxHost + "/v4/{id}/{z}/{x}/{y}.png"

  var owmQueryParams = scala.collection.mutable.Map[String,String](
    "q"      -> ""
    ,"type"   -> "like"
    ,"mode"   -> "json"
//    ,"apikey" -> "<Paste your API Key value here>"
    ,"apikey" -> "9ff16c79edd6ad12396c22ed8a7996ec"
  )

  var mbQueryParams = scala.collection.mutable.Map[String,String](
    "access_token" -> "pk.eyJ1IjoiZmFuY2VsbHUiLCJhIjoiY2oxMHRzZm5zMDAyMDMycndyaTZyYnp6NSJ9.AJ3owakJtFAJaaRuYB7Ukw"
  )

  // ASCII values of various characters
  def char_0  = 48
  def char_9  = 57
  def small_a = 97
  def small_f = 102

  // Inclusive "between" value check
  def between(a: Int, b: Int) = (x: Int) => x >= a && x <= b

  def isHexChar = between(small_a, small_f)
  def isNumChar = between(char_0, char_9)

  // Check if a character string is a valid hex number
  def isHexStr(s: String): Boolean = s.toLowerCase.foldLeft(true) {
    (acc, c) => acc && (isHexChar(c) || isNumChar(c))
  }

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  // Various text string constants
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  def months = Array(
    "January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"
  )

  def ordinalTxt = Array("th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th")

  def compassPoints = Array(
    "N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE",
    "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"
  )

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  // Various string formatting functions
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  // All temperatures are returned in Kelvin
  def kelvinToDegStr(k: Double, min: Double, max: Double):String = {
    val variation = (max - min) / 2
    (k - 272.15).toInt + "˚C" + (if (variation > 0) s" ±${variation}˚C" else "")
  }

  // Format the lat/lon coordinates into a text string
  def formatCoords(lat: Double, lon: Double): String = {
    val latStr = s"${Math.abs(lat)}˚${if (lat >= 0) "N" else "S"}"
    val lonStr = s"${Math.abs(lon)}˚${if (lon >= 0) "E" else "W"}"

    s"$latStr, $lonStr"
  }

  // The weather conditions text string is all lowercase.
  // Convert it to sentence case
  def formatDescription(d: String): String = {
    val (head, tail) = d.splitAt(1)
    head.toUpperCase + tail
  }

  // Convert the wind direction heading in degrees to the nearest compass point
  def formatHeading(h: Double): String = {
    val upper = Math.floor((h + 12.25) / 22.5).toInt % 16
    val lower = Math.floor((h - 12.25) / 22.5).toInt % 16

    h + s"˚ (${compassPoints(Math.max(upper,lower))})"
  }

  // Add the appropriate unit string after various values
  def formatVisibility(v: Int): String    = v + "m"
  def formatVelocity(v: Double): String   = v + "m/s"
  def formatPercentage(p: Double): String = p + "%"
  def formatPressure(p: Double): String   = p + " mBar"
}
