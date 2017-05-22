package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		boolean aRate = false;
		double dInterestRate = 0;
		RateDomainModel rateDM = null;
		
		//TODO - RocketBLL RateBLL.getRate - make sure you throw any exception
		
		//		Call RateDAL.getAllRates... this returns an array of rates
		//		write the code that will search the rates to determine the 
		//		interest rate for the given credit score
		//		hints:  you have to sort the rates...  you can do this by using
		//			a comparator... or by using an OrderBy statement in the HQL
		
		
		//TODO - RocketBLL RateBLL.getRate
		//			obviously this should be changed to return the determined rate
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		for(RateDomainModel rdm : rates){
			rateDM = rdm;
			if(rateDM.getiMinCreditScore() == GivenCreditScore){
				aRate = true;
				dInterestRate = rateDM.getdInterestRate();
			}
			else
				aRate = false;
		}
		
		if(aRate == false){
			throw new RateException(rateDM);
		}else

		//TODO: Filter the ArrayList...  look for the correct rate for the given credit score.
		//	Easiest way is to apply a filter using a Lambda function.
		//
		//	Example... how to use Lambda functions:
		//			https://github.com/CISC181/Lambda
		
		return dInterestRate;
		
		
	}	
	
	
	
	

	
	public static RateDAL get_RateDAL() {
		return _RateDAL;
	}





	public static void set_RateDAL(RateDAL _RateDAL) {
		RateBLL._RateDAL = _RateDAL;
	}





	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t) * -1;
	}
}
