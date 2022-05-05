/*
 * Copyright (c) 2017-2020 DarkCompet. All rights reserved.
 */
package tool.compet.security

import java.math.BigInteger
import java.security.MessageDigest

/**
 * This class, provides common basic operations for crypto.
 */
object DkCryptos {
	fun calcMd5Hash(message: String): String {
		return try {
			val messageDigest = MessageDigest.getInstance("MD5")
			messageDigest.update(message.toByteArray())
			BigInteger(1, messageDigest.digest()).toString()
		}
		catch (e: Exception) {
			e.printStackTrace()
			message
		}
	}
}
