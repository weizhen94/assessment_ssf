package ibfbatch2.ssf.assessment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ibfbatch2.ssf.assessment.model.Cart;
import ibfbatch2.ssf.assessment.model.ShippingAddress;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PurchaseOrderController {

    List<Cart> shoppingCart = new ArrayList<>(); 
    List<ShippingAddress> shippingAddress = new ArrayList<>(); 

    @GetMapping(path = {"/", "/index.html"})
    public String getCart(Model model, HttpSession session){
    
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

    model.addAttribute("cart", cart);
    model.addAttribute("cartItems", shoppingCart);
        return "view1"; 
    }

    @PostMapping("/submit")

    public String submitForm(Model model, HttpSession session, @Valid Cart cart, BindingResult result){

    if(result.hasErrors()){
        return "view1";
    }

    shoppingCart.add(cart); 

    session.setAttribute("cart", cart);

    return "redirect:/"; 
    }
    
    @GetMapping("/shippingaddress")
    public String getShippingAddress(Model model) {

    if (shoppingCart == null) {
        return "view1";
    }

    model.addAttribute("address", new ShippingAddress());
    
        return "view2";
    }

    // @PostMapping("/invoice")
    // public String getInvoice(Model model, HttpSession session, @Valid ShippingAddress address, BindingResult result) {

    //     if(result.hasErrors()){
    //         return "view2";
    //     }

    //     shippingAddress.add(address); 

    //     session.setAttribute("address", address);

    //     model.addAttribute("filledAddress", address);
    
    //     return "view3";
    // }



}
