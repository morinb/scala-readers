/*
 *     Copyright (C) 2015 morinb
 *     https://github.com/morinb
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.morinb.scalareader.log.logback

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase
import com.github.morinb.scalareader.log.logback.ANSIColors.Style._
import com.github.morinb.scalareader.log.logback.ANSIColors.Foreground._
import com.github.morinb.scalareader.log.logback.ANSIColors.Background._
/**
 *
 * @author morinb.
 */
class HighlightCompositeConverterEx extends ForegroundCompositeConverterBase[ILoggingEvent] {
  override def getForegroundColorCode(e: ILoggingEvent): String = e.getLevel.toInt match {
    case Level.ERROR_INT => ANSIColors.getColor(Bright, WhiteForeground, RedBackground)
    case Level.WARN_INT => ANSIColors.getColor(Bright, MagentaForeground)
    case Level.INFO_INT => ANSIColors.getColor(Bright, CyanForeground)
    case Level.DEBUG_INT => ANSIColors.getColor(Bright, YellowForeground)
    case Level.TRACE_INT => ANSIColors.getColor(Bright, WhiteForeground)
    case _ => ANSIColors.getColor()
  }
}
