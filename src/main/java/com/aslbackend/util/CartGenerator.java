package com.aslbackend.util;

import com.aslbackend.data.model.Cart;
import com.aslbackend.data.model.Product;
import com.aslbackend.data.model.User;
import com.aslbackend.data.repository.CartRepository;
import com.aslbackend.data.repository.ProductRepository;
import com.aslbackend.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

//@Component
public class CartGenerator {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    public CartGenerator(UserRepository userRepository, ProductRepository productRepository, CartRepository cartRepository) throws InterruptedException {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;

        List<User> users = userRepository.findAll();
        List<Product> products = productRepository.findAll();

        List<Cart> carts = new ArrayList<>();
        for (User user : users) {
            Random rand = new Random();
            int cartsNumber = rand.nextInt(20);


            for (int i = 0; i < cartsNumber; i++) {
                Cart cart = new Cart();

                cart.setUser(user);

                LocalDateTime date = LocalDateTime.now();
                date = date.plusDays(rand.nextInt(30));
                date = date.plusMinutes(rand.nextInt(60));
                cart.setDateTime(date);

                int productsNumber = rand.nextInt(12) + 2;
                List<Product> cartProducts = new ArrayList<>();
                for (int j = 0; j < productsNumber; j++) {
                    boolean isInList = false;
                    while (!isInList) {
                        Product product = products.get(rand.nextInt(products.size()));
                        if (!cartProducts.contains(product)) {
                            cartProducts.add(product);
                            isInList = true;
                        }
                    }
                }
                cart.setCartProducts(cartProducts);

                carts.add(cart);
            }
        }
        cartRepository.saveAll(carts);
        System.out.println(carts.size());

    }

}
