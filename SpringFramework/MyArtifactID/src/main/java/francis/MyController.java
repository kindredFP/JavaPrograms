package francis;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import scala.annotation.meta.getter;

@RestController
public class MyController {

	// private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/parameterTest")
	public MyJsonObject greeting(
			@RequestParam(value = "param1", defaultValue = "emptyParam1") String param1,
			@RequestParam(value = "param2", defaultValue = "emptyParam2") String param2) {
		return new MyJsonObject(
				counter.incrementAndGet(),
				("Value of param1 = " + param1 + " Value of param2 = " + param2));
	}

	@RequestMapping("/return400")
	public ResponseEntity<MyJsonObject> return400() {
		return new ResponseEntity<MyJsonObject>(new MyJsonObject(
				counter.incrementAndGet(), ""), HttpStatus.BAD_REQUEST);

	}

	@RequestMapping("/return204")
	public ResponseEntity<String> return204() {
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);

	}

	@RequestMapping("/return200")
	public ResponseEntity<MyJsonObject> return200(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "alternative", defaultValue = "") String alternative) {
		return new ResponseEntity<MyJsonObject>(new MyJsonObject(
				counter.incrementAndGet(), (name + alternative)), HttpStatus.OK);

	}

	@RequestMapping("/returnHeader")
	public ResponseEntity<String> returnHeader(HttpServletRequest myRequest) {

		Map<String, String> map = new HashMap<String, String>();

		Enumeration headerNames = myRequest.getHeaderNames();
		HttpHeaders myResponseHeaders = new HttpHeaders();

		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = myRequest.getHeader(key);
			System.out.println(key + ":  " + value);
			myResponseHeaders.set(key, value);
		}

		return new ResponseEntity<String>(myResponseHeaders, HttpStatus.OK);
	}

	@RequestMapping("/**")
	public MyJsonObject captureAll(
			@RequestParam(value = "param1", defaultValue = "emptyParam1") String param1,
			@RequestParam(value = "param2", defaultValue = "emptyParam2") String param2) {
		return new MyJsonObject(
				counter.incrementAndGet(),
				("Value of param1 = " + param1 + " Value of param2 = " + param2));
	}

}