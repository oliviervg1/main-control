package automation.api;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;

import automation.api.interfaces.ConnectedClient;
import automation.api.interfaces.ConnectedDevice;

abstract public class AbstractClient implements ConnectedClient {

	protected ConnectedDevice device;
	private URL url;
	private QName qname;
	private Method method;

	public AbstractClient() {
		device = null;
		url = null;
		qname = null;
		onStartup();
	}
	
	abstract public void onStartup();
	abstract public String getState() throws NoSuchMethodException;
	abstract public String homeTile() throws NoSuchMethodException;
	
	@Override
	final public void connectToRemoteDevice(String WS_URL, QName qname) {
		try {
			this.url = new URL(WS_URL);
			this.qname = qname;
		} catch (MalformedURLException e) {
			this.url = null;
			this.qname = null;
		}
	}
	
	@Override
	final public boolean isDeviceAvailable() {
		try {                              
			Service service = Service.create(url, qname);
			device = service.getPort(ConnectedDevice.class);
			return true;
		} catch (WebServiceException e) {
			return false;
		}
	}

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