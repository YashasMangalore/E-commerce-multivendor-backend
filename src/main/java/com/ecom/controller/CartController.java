package com.ecom.controller;

import com.ecom.exception.CartItemException;
import com.ecom.exception.ProductException;
import com.ecom.exception.UserException;
import com.ecom.model.Cart;
import com.ecom.model.CartItem;
import com.ecom.model.Product;
import com.ecom.model.User;
import com.ecom.request.AddItemRequest;
import com.ecom.response.ApiResponse;
import com.ecom.service.CartItemService;
import com.ecom.service.CartService;
import com.ecom.service.ProductService;
import com.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
	
	private final CartService cartService;
	private final UserService userService;
	private final ProductService productService;
	private final CartItemService cartItemService;


	
	@GetMapping
	public ResponseEntity<Cart> findUserCartHandler(@RequestHeader("Authorization") String jwt) throws UserException{
		
		User user=userService.findUserProfileByJwt(jwt);
		
		Cart cart=cartService.findUserCart(user);
		
		System.out.println("cart - "+cart.getUser().getEmail());
		
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}
	
	@PutMapping("/add")
	public ResponseEntity<CartItem> addItemToCart(@RequestBody AddItemRequest req,
												  @RequestHeader("Authorization") String jwt) throws UserException, ProductException{
		
		User user=userService.findUserProfileByJwt(jwt);
		Product product=productService.findProductById(req.getProductId());
		
		CartItem item = cartService.addCartItem(user,
				product,
				req.getSize(),
				req.getQuantity());
		

		return new ResponseEntity<>(item,HttpStatus.ACCEPTED);
		
	}

	@DeleteMapping("/item/{cartItemId}")
	public ResponseEntity<ApiResponse>deleteCartItemHandler(
			@PathVariable Long cartItemId,
			@RequestHeader("Authorization")String jwt)
			throws CartItemException, UserException{

		User user=userService.findUserProfileByJwt(jwt);
		cartItemService.removeCartItem(user.getId(), cartItemId);

		ApiResponse res=new ApiResponse("Item Remove From Cart",true);

		return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
	}

	@PutMapping("/item/{cartItemId}")
	public ResponseEntity<CartItem>updateCartItemHandler(
			@PathVariable Long cartItemId,
			@RequestBody CartItem cartItem,
			@RequestHeader("Authorization")String jwt)
			throws CartItemException, UserException{

		User user=userService.findUserProfileByJwt(jwt);

		CartItem updatedCartItem = null;
		if(cartItem.getQuantity()>0){
			updatedCartItem=cartItemService.updateCartItem(user.getId(),
					cartItemId, cartItem);
		}
	



		return new ResponseEntity<>(updatedCartItem,HttpStatus.ACCEPTED);
	}
	

}
