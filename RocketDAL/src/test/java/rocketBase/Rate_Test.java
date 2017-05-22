package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {

	static RateDomainModel uno;
	static RateDomainModel dos;
	static RateDAL dal;
	
	@BeforeClass
	public static void setup(){
		RateDomainModel one = new RateDomainModel();
		one.setdInterestRate(.02);
		one.setiMinCreditScore(600);
		one.setiRateID(1);
		RateDomainModel two = new RateDomainModel();
		two.setdInterestRate(.03);
		two.setiMinCreditScore(700);
		two.setiRateID(2);
		RateDAL DAL = new RateDAL();
		DAL.addRateDomainModel(one);
		DAL.addRateDomainModel(two);
	}
	
	@Test
	public void testGetAllRates(){
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		assertNotNull(rates);
	}

}
