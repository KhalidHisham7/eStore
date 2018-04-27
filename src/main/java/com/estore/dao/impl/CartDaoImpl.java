package com.estore.dao.impl;

import com.estore.dao.CartDao;
import com.estore.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartDaoImpl implements CartDao {

    private Map<String, Cart> listOfCarts;

    public CartDaoImpl()
    {
        listOfCarts = new HashMap<String, Cart>();
    }

    public Cart create(Cart cart)
    {
        if(listOfCarts.keySet().contains(cart.getCartId()))
        {
            throw new IllegalArgumentException(String.format("Cannot create a cart. A cart with the given ID(%)" + "already"
                    + "exists", cart.getCartId()));
        }

        listOfCarts.put(cart.getCartId(), cart);

        return cart;
    }

    public Cart read(String cartId)
    {
        return listOfCarts.get(cartId);
    }

    public void update(String cartId, Cart cart)
    {
        if(!listOfCarts.keySet().contains(cartId))
        {
            throw new IllegalArgumentException(String.format("Cannot update cart. The cart with the given ID(%)" + "does not"
                    + "exist!", cart.getCartId()));
        }

        listOfCarts.put(cartId, cart);
    }

    public void delete(String cartId)
    {
        if(!listOfCarts.keySet().contains(cartId))
        {
            throw new IllegalArgumentException(String.format("Cannot delete cart. The cart with the given ID(%)" + "does not"
                    + "exist!", cartId));
        }

        listOfCarts.remove(cartId);
    }
}