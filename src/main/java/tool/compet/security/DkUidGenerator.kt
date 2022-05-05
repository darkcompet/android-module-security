/*
 * Copyright (c) 2017-2020 DarkCompet. All rights reserved.
 */
package tool.compet.security

import java.util.*

object DkUidGenerator {
	private val random = Random()
	private val idoms = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray()

	/**
	 * Generate unique key which has given length. Each character ise alphabet or underscore.
	 *
	 * @param expectLength should greater than or equals 19.
	 * @return unique random key which has length is at least expectLength.
	 */
	@JvmOverloads
	fun generateRandomKey(expectLength: Int = 32): String {
		val key = StringBuilder(expectLength)
		val suffix = System.nanoTime().toString()
		val bounds = idoms.size
		for (i in 0 until expectLength - suffix.length - 1) {
			key.append(idoms[random.nextInt(bounds)])
		}
		key.append('_').append(suffix)
		return key.toString()
	}
}
