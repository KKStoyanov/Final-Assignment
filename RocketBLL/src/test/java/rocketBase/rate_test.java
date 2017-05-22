package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class rate_test {

	static RateDomainModel uno;
	static RateDomainModel dos;
	static RateDAL dal;
	static RateBLL rB;
	
	@BeforeClass
	public static void setup(){
		RateDAL DAL = new RateDAL();
		RateBLL rateBLL = new RateBLL();
		rateBLL.set_RateDAL(DAL);
		rB = rateBLL;
	}
	
	@Test(expected = RateException.class)
	public void testGetRate() throws RateException{
		rB.getRate(710);
	}
	
	@Test
	public void testGetRate2() throws RateException{
		assertEquals(rB.getRate(650), 6.5, .001);
	}
	
	@Test
	public void testGetPayment(){
		assertEquals(Math.round(rB.getPayment(6.5 / 12, 360, 300000, 0, false)), 162500);
	}


}
