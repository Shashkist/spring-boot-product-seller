package com.sha.springbootproductseller;

import com.sha.springbootproductseller.model.Product;
import com.sha.springbootproductseller.model.Purchase;
import com.sha.springbootproductseller.model.Role;
import com.sha.springbootproductseller.model.User;
import com.sha.springbootproductseller.repository.ProductRepository;
import com.sha.springbootproductseller.repository.PurchaseRepository;
import com.sha.springbootproductseller.repository.UserRepository;
import com.sha.springbootproductseller.repository.projection.PurchaseItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SpringBootProductSellerApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootProductSellerApplicationTests.class);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void saveUser() {
		User user = new User();
		user.setName("ilia");
		user.setUsername("shashkist2");
		user.setPassword("1234");
		user.setCreateTime(LocalDateTime.now());
		user.setRole(Role.USER);
		userRepository.save(user);
	}


	@Test
	void saveProduct() {
		Product product = new Product();
		product.setName("cattle");
		product.setDescription("simple cattle");
		product.setPrice(20D);
		product.setCreateTime(LocalDateTime.now());
		productRepository.save(product);
	}

	@Test
	void savePurchase() {
		Purchase purchase = new Purchase();
		User user = userRepository.getReferenceById(1L);
		purchase.setUserId(user.getId());
		purchase.setProductId(1L);
		purchase.setPrice(20D);
		purchase.setPurchaseTime(LocalDateTime.now());
		purchaseRepository.save(purchase);
	}

	@Test
	void checkGetPurchaseByTheUser() {
		List<PurchaseItem> purchaseItems = purchaseRepository.findAllPurchaseOfUser(1L);
		logger.info(purchaseItems.toString());
	}


	@Test
	void switchString() {
		String text = "abcd";
		String switchedText = "";
		for (int i = 0; i < text.length(); i++) {
			switchedText = text.charAt(i)+switchedText;
		}
		System.out.println(switchedText);

	}




}
