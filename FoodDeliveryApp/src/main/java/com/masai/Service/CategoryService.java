package com.masai.Service;

import java.util.List;

import com.masai.Exception.CategoryException;
import com.masai.Model.Category;

public interface CategoryService {
	
	public Category addCategory(Category cat)throws  CategoryException;
	
	public Category updateCategory(Category cat)throws  CategoryException;
	
	public String removeCategory(Integer catID)throws  CategoryException;

	public Category viewCategory(Integer catID)throws  CategoryException;

	public List<Category> viewAllCategory()throws  CategoryException;



}
