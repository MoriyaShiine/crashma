/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.crashma.common;

import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.world.World;

import java.util.Random;

public class DumbassException extends RuntimeException {
	private static final Random RANDOM = new Random();

	public static void crashma(World world) {
		long time = world.getTime();
		if (time > 0 && time % 1200 == 0 && RANDOM.nextInt(3) == 0) {
			throw new CrashException(new CrashReport("crashma game lmao idiot gottem", new DumbassException()));
		}
	}
}
