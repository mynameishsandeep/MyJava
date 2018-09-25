package com.interview.leetcode.linkedin.medium;

/*
 =======IP V4 points==========
1) 4 groups separator “.”
2) Leading 0 not allowed
3) decimal numbers 0 to 255 // use short

String regex = "[0-9]{1,3}";

=======IP V6 points==========
1) 8 groups of hexadecimal numbers - 16 bits (0000 to FFFF) with Separator “:”

String regex = "[0-9A-Fa-f]{1,4}";

Note: 
1) Split with Special character needs "\\". so to split with "."--> IP.split("\\.");
2) At the end If empty or nothing present after ".". Then split is not adding an entry.
Ex: 1.2.3.4. --> split size is 4 only, it should be 5. So check for leading and trailing dots and colon in code.
    1..3.4. --> still split size is 4 only
3) Split using pattern matcher vs string matches... Refer StringMatchesVSPatternMatches.java

 */
public class ValidIP {

	public static void main(String[] args) {
		ValidIP v = new ValidIP();
		//System.out.println(v.validIPAddress("172.16.254.1"));
		//System.out.println(v.validIPAddress("01.01.01.01"));
		System.out.println(v.validIPAddress("1.0.0.1"));
		//System.out.println(v.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
		//System.out.println(v.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
	}

	public String validIPAddress(String IP) {
		if (!isValidStartEnd(IP)) {
			return validV4OrV6OrNeither(null);
		}
		String[] v4 = IP.split("\\.");
		if (v4.length == 4) {
			for (int i = 0; i < 4; i++) {
				if (!isValidNumber(v4[i])) {
					return validV4OrV6OrNeither(null);
				}
			}
			return validV4OrV6OrNeither(true);
		} else if (v4.length > 1 && v4.length < 4) {
			return validV4OrV6OrNeither(null);
		}

		String[] v6 = IP.split("\\:");
		if (v6.length == 8) {
			for (int i = 0; i < 8; i++) {
				if (!isValidHexNumber(v6[i])) {
					return validV4OrV6OrNeither(null);
				}
			}
			return validV4OrV6OrNeither(false);
		}
		return validV4OrV6OrNeither(null);
	}

	/*
	=====parameters========
	null - neither v4 or v6
	true - v4
	false - v6
	=====parameters========
	*/
	public String validV4OrV6OrNeither(Boolean result) {
		if (null == result) {
			return "Neither";
		} else if (result) {
			return "IPv4";
		}
		return "IPv6";

	}

	public boolean isValidNumber(String ip) {
		String regex = "[0-9]{1,3}";
		if (!ip.matches(regex)) {
			return false;
		}
		if (ip.startsWith("0") && ip.length()>1) {
			return false;
		}
		short b = new Short(ip);
		if (b > 255) {
			return false;
		}
		return true;
	}

	public boolean isValidStartEnd(String ip) {
		if (ip.startsWith(":") || ip.endsWith(":")) {
			return false;
		}

		if (ip.startsWith(".") || ip.endsWith(".")) {
			return false;
		}
		return true;
	}

	public boolean isValidHexNumber(String ip) {
		String regex = "[0-9A-Fa-f]{1,4}";
		if (!ip.matches(regex)) {
			return false;
		}
		return true;
	}
}
