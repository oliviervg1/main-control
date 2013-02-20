package automation.api;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.springframework.stereotype.Controller;

import automation.api.interfaces.ConnectedDevice;

@Controller
public class AbstractController {
	private Service service;
	protected ConnectedDevice device;
	
	public AbstractController(QName qname, String WS_URL) throws MalformedURLException {
		 service = Service.create(new URL(WS_URL), qname);
	     device = service.getPort(ConnectedDevice.class);
	}
}
