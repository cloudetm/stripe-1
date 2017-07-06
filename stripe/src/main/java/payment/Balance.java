package payment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.*;

public class Balance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Balance() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("GET: Should not serve this.");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append(checkBalance());
	}

	protected String checkBalance(){
		Stripe.apiKey = "sk_test_BQokikJOvBiI2HlWgH4olfQ2";

		try {
			BalanceTransaction bt = BalanceTransaction.retrieve("txn_19XJJ02eZvKYlo2ClwuJ1rbA");
			return bt.toString();
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
