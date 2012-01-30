package aspect;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class ContactAspect {
	@AroundInvoke
	public Object trace( InvocationContext ic ){
		System.out.println("ContactAspect::trace, aspect called ...");
		Object ret = null;
		try {
			ret = ic.proceed();
		} catch (Exception e) {
			System.out.println("ContactAspect::trace exception:");
			e.printStackTrace();
		} // calling the bean (optional)
		return ret;
	}
}
