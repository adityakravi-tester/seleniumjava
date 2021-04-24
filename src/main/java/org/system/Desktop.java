package org.system;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Desktop extends Computer{
	public Desktop desktopSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.printf("%n%-30s%d%s%d", "Desktop Size:", screenSize.height, "x", screenSize.width);
		return this;
	}
	
	public static void main(String[] args) {
		new Desktop().computerModel().desktopSize();
	}
}
