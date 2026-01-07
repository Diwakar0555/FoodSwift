package com.diw.servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.diw.dao.OrderDAO;
import com.diw.daoimplementation.OrderDAOImpl;
import com.diw.model.Cart;
import com.diw.model.CartItem;
import com.diw.model.Order;
import com.diw.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/placeOrder")
public class PlaceOrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("loggedUser");

		Cart cart = (Cart) session.getAttribute("cart");

		if (user == null || cart == null || cart.getItems().isEmpty()) {
			response.sendRedirect("home.jsp");
			return;
		}

		String paymentMode = request.getParameter("paymentMode");

		double totalAmount = 0;
		for (CartItem item : cart.getItems()) {
			totalAmount += item.getPrice() * item.getQuantity();
		}

		int restaurantId = cart.getItems().iterator().next().getRestaurantId();

		Order order = new Order();
		order.setUserId(user.getUserId());
		order.setRestaurantId(restaurantId);
		order.setTotalAmount(totalAmount);
		order.setStatus("PLACED");
		order.setPaymentMode(paymentMode);

		OrderDAO orderDAO = new OrderDAOImpl();
		int orderId = orderDAO.placeOrder(order, new ArrayList<>(cart.getItems()));

		if (orderId == 0) {
			response.sendRedirect("cart.jsp");
			return;
		}

		session.removeAttribute("cart");

		session.setAttribute("lastOrderId", orderId);

		response.sendRedirect("orderconfirmation.jsp");
	}
}
