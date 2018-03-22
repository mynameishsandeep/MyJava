package com.sample.performance;

import org.apache.log4j.Logger;

public class StackTrace {
	public static void main(String[] args) {
		
		//Thread.dumpStack();
		
		AA a = new AA();
		a.main1(args);
	}
}
	
	class AA {
		public void main1(String[] args) {
			BB b = new BB();
			b.main1(args);
		}
	}
	
	class BB {
		private static final Logger LOG = Logger
				.getLogger(BB.class);
		public void main1(String[] args) {
			try {
			  throw new Exception();
			} catch (Exception e) {
				LOG.info("Exception ", e.fillInStackTrace());
			}

		}
	}

