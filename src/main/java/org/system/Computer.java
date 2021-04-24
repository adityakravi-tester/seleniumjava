package org.system;
import oshi.hardware.platform.windows.WindowsHardwareAbstractionLayer;

public class Computer {
	public Desktop computerModel() {
		String model = new WindowsHardwareAbstractionLayer().getComputerSystem().getModel();
		System.out.printf("%-30s%s", "Computer model:",model);
		return new Desktop();
	}
}
