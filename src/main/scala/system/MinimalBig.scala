// See LICENSE.SiFive for license details.

package freechips.rocketchip.system

import Chisel._
import freechips.rocketchip.config.Parameters
import freechips.rocketchip.diplomacy._
import freechips.rocketchip.subsystem._
import freechips.rocketchip.prci.SimpleClockGroupSource
import freechips.rocketchip.devices.tilelink._
import freechips.rocketchip.util.DontTouch

/** Example Top with periphery devices and ports, and a Rocket subsystem */
class MinimalBigSystem(implicit p: Parameters) extends RocketSubsystem
    with HasHierarchicalBusTopology
    with HasAsyncExtInterrupts
    with CanHaveMasterAXI4MemPort
    with CanHaveMasterAXI4MMIOPort
    with HasPeripheryBootROM {
  override lazy val module = new MinimalBigSystemModuleImp(this)
}

class MinimalBigSystemModuleImp[+L <: MinimalBigSystem](_outer: L) extends RocketSubsystemModuleImp(_outer)
    with HasExtInterruptsModuleImp
    with HasPeripheryBootROMModuleImp
    with DontTouch
