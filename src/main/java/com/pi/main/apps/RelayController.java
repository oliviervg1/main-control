//package com.pi.main.apps;
//
//import java.net.MalformedURLException;
//
//import javax.xml.namespace.QName;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import automation.api.AbstractController;
//
//@Controller
//@RequestMapping("/apps/lights")
//public class RelayController extends AbstractController {
//	
//	private static final String WS_URL = "http://192.168.0.9:8080/relay-control-1.0.0/SocketController?wsdl";
//	private static final QName qname = new QName("http://relay.pi.com/", "SocketControllerService");
//	
//	public RelayController() throws MalformedURLException {
//        super(qname, WS_URL);
//	}
//	
//	public void powerOn() {
//		try {
//			device.invokeMethod("powerOn");
//		} catch (NoSuchMethodException e) {
//			System.err.println("Method not found! Check method name :)");
//		}
//	}
//	
//	public void powerOff() {
//		try {
//			device.invokeMethod("powerOff");
//		} catch (NoSuchMethodException e) {
//			System.err.println("Method not found! Check method name :)");
//		}
//	}
//	
//	public String getState() {
//		try {
//			return (String) device.invokeMethod("getState");
//		} catch (NoSuchMethodException e) {
//			System.err.println("Method not found! Check method name :)");
//			return null;
//		}
//	}
//}
