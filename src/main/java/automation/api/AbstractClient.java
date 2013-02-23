package automation.api;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import automation.api.interfaces.ConnectedClient;
import automation.api.interfaces.ConnectedDevice;

public class AbstractClient implements ConnectedClient {

	protected ConnectedDevice device;

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

}