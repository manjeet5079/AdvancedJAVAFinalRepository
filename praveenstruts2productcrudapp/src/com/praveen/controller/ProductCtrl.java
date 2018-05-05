package com.praveen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.praveen.dao.ProductDAO;
import com.praveen.model.Product;

public class ProductCtrl extends ActionSupport {
	private static final long serialVersionUID = -9059161454058641925L;
	Product product = new Product();
	ProductDAO dao = new ProductDAO();
	private List<Product> productList;
	private String successMsg = "";
	private String errorMsg = "";

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductDAO getDao() {
		return dao;
	}

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	

	public String saveProduct() {

		product.setPname(product.getPname());
		product.setPrice(product.getPrice());
		product.setQty(product.getQty());
		boolean status = dao.saveProduct(product);
		if (status) {
			setSuccessMsg("Product Saved Successfully");
			return SUCCESS;
		} else {
			setErrorMsg("Product not saved");
			return "input";
		}

	}

	public String updateProduct() {

		product.setPid(product.getPid());
		product.setPname(product.getPname());
		product.setPrice(product.getPrice());
		product.setQty(product.getQty());
		boolean status = dao.updateProduct(product);
		if (status) {
			setSuccessMsg("Product update Successfully");
			return SUCCESS;
		} else {
			setErrorMsg("Product not update");
			return "input";
		}

	}

	public String editProduct() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		int pid = Integer.parseInt(request.getParameter("pid"));

		Product p = dao.getProduct(pid);

		product.setPid(p.getPid());
		product.setPname(p.getPname());
		product.setPrice(p.getPrice());
		product.setQty(p.getQty());

		return SUCCESS;

	}

	public String deleteProduct() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		int pid = Integer.parseInt(request.getParameter("pid"));
		boolean status = dao.deleteProduct(pid);

		if (status) {
			setSuccessMsg("Product delete Successfully");
			findAllProduct();
			return SUCCESS;
		} else {
			setErrorMsg("Product not deleted");
			return "input";
		}

	}

	public String findAllProduct() {
		productList = dao.getAllProduct();
		return SUCCESS;
	}

}
