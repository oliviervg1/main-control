package automation.api;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import automation.api.interfaces.ConnectedClient;
import automation.api.interfaces.ConnectedDevice;

abstract public class AbstractClient implements ConnectedClient {

	protected ConnectedDevice device;
	private Method method;

	public AbstractClient() {
		device = null;
	}
	
	public AbstractClient(String WS_URL, QName qname) {
		URL url = null;
		try {
			url = new URL(WS_URL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Service service = Service.create(url, qname);
        device = service.getPort(ConnectedDevice.class);
	}
	
	abstract public String getState();
	abstract public String homeTile();

	@Override
	final public Object invokeMethod(String methodName) throws NoSuchMethodException {
		return invokeMethod(methodName, null);
	}

	@Override
	final public Object invokeMethod(String methodName, Object[] parametersArray) throws NoSuchMethodException {
		Object ret = 0;

		if (parametersArray == null || parametersArray.length == 0) {
			method = this.getClass().getDeclaredMethod(methodName);
		}
		else {
			method = this.getClass().getDeclaredMethod(methodName, findParameterTypes(parametersArray));
		}

		try {
			ret = method.invoke(this, parametersArray);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// force to 0 if method has set ret to null
		if (ret == null) {
			ret = 0;
		}   

		return ret;
	}

	@SuppressWarnings("rawtypes")
	final private Class[] findParameterTypes(Object[] parameters) {
		Class[] parameterTypes = new Class[parameters.length];
		for (int i=0; i<parameters.length; i++) {
			parameterTypes[i] = parameters[i].getClass();
		}
		return parameterTypes;
	}

}