package com.sodamachine.demo.jobschedule;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sodamachine.demo.model.Product;
import com.sodamachine.demo.service.EmailService;
import com.sodamachine.demo.service.ProductService;

@Component
public class JobScheduler {

	@Autowired
	private ProductService productService;

	@Autowired
	private EmailService emailService;

	@Scheduled(cron = "0 0 12 * * ?")
	public void getTodaysInventory() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		String formattedDate = dateFormat.format(today);

		List<Product> inventory = this.productService.listProducts();
		String emailBody = String.format("%-10s %-10s %-10s", "Product", "Capacity", "Inventory Left") + "\n";

		for (int i = 0; i < inventory.size(); i++) {
			emailBody += (String.format("%-10s %-15s %-20s", inventory.get(i).getProductName(),
					inventory.get(i).getCapacity().toString(), inventory.get(i).getInventory().toString()) + "\n");
		}

		this.emailService.sendMail("davut.disci@gmail.com", "Product Inventory/" + formattedDate, emailBody);

	}

}
