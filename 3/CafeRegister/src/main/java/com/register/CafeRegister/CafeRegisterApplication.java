package com.register.CafeRegister;

import com.register.CafeRegister.Controller.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@SpringBootApplication
@RestController
public class CafeRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeRegisterApplication.class, args);
	}
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", required = false) String name) {
		return String.format("Hello %s!", name);
	}
	@GetMapping("/add")
	public String add(@RequestParam(value = "name", 		required = false) String name,
					  @RequestParam(value = "providername", required = false) String providername,
					  @RequestParam(value = "cafename", 	required = false) String cafename,
					  @RequestParam(value = "clientname", 	required = false) String clientname,
					  @RequestParam(value = "dishname", 	required = false) String dishname,
					  @RequestParam(value = "place", 		required = false) String place,
					  @RequestParam(value = "feedback", 	required = false) String feedback,

					  @RequestParam(value = "score", 		required = false) String score,
					  @RequestParam(value = "tablecount", 	required = false) String tablecount,
					  @RequestParam(value = "maxtable", 	required = false) String maxtable,
					  @RequestParam(value = "money", 		required = false) String money,
					  @RequestParam(value = "cost", 		required = false) String cost,
					  @RequestParam(value = "bill", 		required = false) String bill,
					  @RequestParam(value = "tablenum", 	required = false) String tablenum,

					  @RequestParam(value = "basketid", 	required = false) String basketid,
					  @RequestParam(value = "orderid", 		required = false) String orderid,
					  @RequestParam(value = "dishid", 		required = false) String dishid,
					  @RequestParam(value = "providerid", 	required = false) String providerid,
					  @RequestParam(value = "cadeid", 		required = false) String cafeid,
					  @RequestParam(value = "clientid", 	required = false) String clientid) throws SQLException {
		Controller controller = new Controller();
		controller.add(name);
		return String.format(" name = "+name
							+" provider = "+providername
							+" cafe = "+cafename
							+" client = "+clientname
							+" dish = "+dishname
							+" place = "+place
							+" feedback = "+feedback);
	}
	@GetMapping("/del")
	public String del(@RequestParam(value = "name", 		required = false) String name,
					  @RequestParam(value = "providername", required = false) String providername,
					  @RequestParam(value = "cafename", 	required = false) String cafename,
					  @RequestParam(value = "clientname", 	required = false) String clientname,
					  @RequestParam(value = "dishname", 	required = false) String dishname,
					  @RequestParam(value = "place", 		required = false) String place,
					  @RequestParam(value = "feedback", 	required = false) String feedback,

					  @RequestParam(value = "score", 		required = false) String score,
					  @RequestParam(value = "tablecount", 	required = false) String tablecount,
					  @RequestParam(value = "maxtable", 	required = false) String maxtable,
					  @RequestParam(value = "money", 		required = false) String money,
					  @RequestParam(value = "cost", 		required = false) String cost,
					  @RequestParam(value = "bill", 		required = false) String bill,
					  @RequestParam(value = "tablenum", 	required = false) String tablenum,

					  @RequestParam(value = "basketid", 	required = false) String basketid,
					  @RequestParam(value = "orderid", 		required = false) String orderid,
					  @RequestParam(value = "dishid", 		required = false) String dishid,
					  @RequestParam(value = "providerid", 	required = false) String providerid,
					  @RequestParam(value = "cadeid", 		required = false) String cafeid,
					  @RequestParam(value = "clientid", 	required = false) String clientid) throws SQLException {
		Controller controller = new Controller();
		controller.delete(name);
		return String.format(" name = "+name
				+" provider = "+providername
				+" cafe = "+cafename
				+" client = "+clientname
				+" dish = "+dishname
				+" place = "+place
				+" feedback = "+feedback);
	}
	@GetMapping("/cha")
	public String cha(@RequestParam(value = "name", 		required = false) String name,
					  @RequestParam(value = "providername", required = false) String providername,
					  @RequestParam(value = "cafename", 	required = false) String cafename,
					  @RequestParam(value = "clientname", 	required = false) String clientname,
					  @RequestParam(value = "dishname", 	required = false) String dishname,
					  @RequestParam(value = "place", 		required = false) String place,
					  @RequestParam(value = "feedback", 	required = false) String feedback,

					  @RequestParam(value = "score", 		required = false) String score,
					  @RequestParam(value = "tablecount", 	required = false) String tablecount,
					  @RequestParam(value = "maxtable", 	required = false) String maxtable,
					  @RequestParam(value = "money", 		required = false) String money,
					  @RequestParam(value = "cost", 		required = false) String cost,
					  @RequestParam(value = "bill", 		required = false) String bill,
					  @RequestParam(value = "tablenum", 	required = false) String tablenum,

					  @RequestParam(value = "basketid", 	required = false) String basketid,
					  @RequestParam(value = "orderid", 		required = false) String orderid,
					  @RequestParam(value = "dishid", 		required = false) String dishid,
					  @RequestParam(value = "providerid", 	required = false) String providerid,
					  @RequestParam(value = "cadeid", 		required = false) String cafeid,
					  @RequestParam(value = "clientid", 	required = false) String clientid) throws SQLException {
		Controller controller = new Controller();
		controller.change(name);
		return String.format(" name = "+name
				+" provider = "+providername
				+" cafe = "+cafename
				+" client = "+clientname
				+" dish = "+dishname
				+" place = "+place
				+" feedback = "+feedback);
	}
	@GetMapping("/show")
	public String show(@RequestParam(value = "name", 		required = false) String name,
					   @RequestParam(value = "providername",required = false) String providername,
					   @RequestParam(value = "cafename", 	required = false) String cafename,
					   @RequestParam(value = "clientname", 	required = false) String clientname,
					   @RequestParam(value = "dishname", 	required = false) String dishname,
					   @RequestParam(value = "place", 		required = false) String place,
					   @RequestParam(value = "feedback", 	required = false) String feedback,

					   @RequestParam(value = "score", 		required = false) double score,
					   @RequestParam(value = "tablecount", 	required = false) int tablecount,
					   @RequestParam(value = "maxtable", 	required = false) int maxtable,
					   @RequestParam(value = "money", 		required = false) double money,
					   @RequestParam(value = "cost", 		required = false) double cost,
					   @RequestParam(value = "bill", 		required = false) double bill,
					   @RequestParam(value = "tablenum", 	required = false) int tablenum,

					   @RequestParam(value = "basketid", 	required = false) int basketid,
					   @RequestParam(value = "orderid", 	required = false) int orderid,
					   @RequestParam(value = "dishid", 		required = false) int dishid,
					   @RequestParam(value = "providerid", 	required = false) int providerid,
					   @RequestParam(value = "cadeid", 		required = false) int cafeid,
					   @RequestParam(value = "clientid", 	required = false) int clientid) throws SQLException {
				Controller controller = new Controller();
				controller.getFromId(name,basketid,orderid,dishid,providerid,cafeid,clientid);
				return String.format(" name = "+name
						+" provider = "+providername
						+" cafe = "+cafename
						+" client = "+clientname
						+" dish = "+dishname
						+" place = "+place
						+" feedback = "+feedback);

	}
	@GetMapping("/showa")
	public String showa(@RequestParam(value = "name", 		required = false) String name,
					  	@RequestParam(value = "providername", required = false) String providername,
					  	@RequestParam(value = "cafename", 	required = false) String cafename,
					  	@RequestParam(value = "clientname", 	required = false) String clientname,
					  	@RequestParam(value = "dishname", 	required = false) String dishname,
					  	@RequestParam(value = "place", 		required = false) String place,
					  	@RequestParam(value = "feedback", 	required = false) String feedback,

					  	@RequestParam(value = "score", 		required = false) String score,
					  	@RequestParam(value = "tablecount", 	required = false) String tablecount,
					  	@RequestParam(value = "maxtable", 	required = false) String maxtable,
					  	@RequestParam(value = "money", 		required = false) String money,
					  	@RequestParam(value = "cost", 		required = false) String cost,
					  	@RequestParam(value = "bill", 		required = false) String bill,
					  	@RequestParam(value = "tablenum", 	required = false) String tablenum,

					  	@RequestParam(value = "basketid", 	required = false) String basketid,
					  	@RequestParam(value = "orderid", 		required = false) String orderid,
					  	@RequestParam(value = "dishid", 		required = false) String dishid,
					  	@RequestParam(value = "providerid", 	required = false) String providerid,
					  	@RequestParam(value = "cadeid", 		required = false) String cafeid,
					  	@RequestParam(value = "clientid", 	required = false) String clientid) throws SQLException {
		Controller controller = new Controller();
		controller.getAll(name);
		return String.format(" name = "+name
				+" provider = "+providername
				+" cafe = "+cafename
				+" client = "+clientname
				+" dish = "+dishname
				+" place = "+place
				+" feedback = "+feedback);
	}
}