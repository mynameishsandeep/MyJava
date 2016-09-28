package com.altimetrik.java8features;

import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaFunctionSupplier {

	public static void main(String[] args) {
		AgreementSalesConnector val = null;
		maker(()->{return val.fun();});
		System.out.println(maker(CASConnector::foo));
	}

	private static Connector maker(Supplier<Connector> fx) {

		return fx.get();
	}

	// private static Connector
	// maker(Supplier<Function<Connector>,Function<Connector>> fx) {
	// if(fx.get()){
	//
	// }
	// return fx.get();
	// }
}

interface Connector {

}

class AgreementSalesConnector implements Connector {
	@Override
	public String toString() {
		return "Agreement Sales Connector";
	}

	public  Connector fun() {
		return new AgreementSalesConnector();
	}

}

class CASConnector implements Connector {
	@Override
	public String toString() {
		return "CAS Connector";
	}

	public static Connector foo() {
		return new CASConnector();
	}
}
